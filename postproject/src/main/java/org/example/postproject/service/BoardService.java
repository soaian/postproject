package org.example.postproject.service;

import lombok.RequiredArgsConstructor;
import org.example.postproject.domain.Board;
import org.example.postproject.repository.BoardRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    @Transactional(readOnly = true)
    public Page<Board> findAllPost(Pageable pageable){
        Pageable sortedByDescId = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(),
                Sort.by(Sort.Direction.DESC,"id"));

        return boardRepository.findAll(sortedByDescId);
    }

    @Transactional(readOnly = true)
    public Board findBoardById(Long id){
        return boardRepository.findById(id).orElse(null);
    }

    @Transactional
    public Board saveBoard(Board board){
        return boardRepository.save(board);
    }

    @Transactional
    public void deleteBoardById(Long id){
        boardRepository.deleteById(id);
    }
}
