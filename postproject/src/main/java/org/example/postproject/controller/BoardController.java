package org.example.postproject.controller;

import lombok.RequiredArgsConstructor;
import org.example.postproject.domain.Board;
import org.example.postproject.service.BoardService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/list")
    public String boards(Model model, @RequestParam(defaultValue = "1")int page,
                         @RequestParam(defaultValue = "5") int size){
        Pageable pageable = PageRequest.of(page-1,size);

        Iterable<Board> boards = boardService.findAllPost(pageable);
        model.addAttribute("boards",boards);
        model.addAttribute("currentPage",page);
        return "list";
    }

    @GetMapping("/view")
    public String detail(@RequestParam(name = "id") Long id, Model model){
        Board board = boardService.findBoardById(id);
        model.addAttribute("board",board);
        return "detail";
    }

    @GetMapping("/writeform")
    public String addForm(Model model){
        model.addAttribute("board",new Board());
        return "form";
    }

    @PostMapping("/writeform")
    public String addBoard(@ModelAttribute Board board, RedirectAttributes redirectAttributes){
        boardService.saveBoard(board);
        redirectAttributes.addFlashAttribute("message","등록 성공!!");
        return "redirect:/list";
    }

    @GetMapping("/deleteform")
    public String deleteForm(@RequestParam(name = "id") Long id, Model model){
        Board board = boardService.findBoardById(id);
        model.addAttribute("board",board);
        return "deleteform";
    }

    @PostMapping("/delete")
    public String deleteBoard(@RequestParam("id") Long id, @RequestParam("password") String password, Model model){
        Board board = boardService.findBoardById(id);
        if (board == null) {
            model.addAttribute("error", "해당 보드는 없습니다.");
            return "deleteform";
        }

        if (board.getPassword().equals(password)) {
            boardService.deleteBoardById(id);
            model.addAttribute("success", "게시물 삭제를 성공했습니다");
            return "redirect:/list";
        } else {
            model.addAttribute("board", board);
            model.addAttribute("error", "비밀번호가 틀렸습니다. 다시 입력해주세요.");
            return "deleteform";
        }
    }

    //수정
    @GetMapping("/updateform")
    public String updateForm(@RequestParam(name = "id") Long id, Model model){
        Board board = boardService.findBoardById(id);
        model.addAttribute("board",board);
        return "updateform";
    }

    @PostMapping("/update")
    public String updateBoard(@ModelAttribute Board board){
        boardService.saveBoard(board);
        return "redirect:/list";
    }
}
