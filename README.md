[구현 완료한 기능]
1. 목록보기 (/list)
   -> ID, 제목, 이름, 등록일(YYYY/MM/DD 형식)로 목록이 구성하였습니다
   -> 게시판 등록하기 기능을 추가하였습니다.
   -> 리스트 내역을 클릭했을 때, 상세조회 페이지로 이동하게 구현하였습니다.

2. 게시글 상세 조회 (view?id=아이디)
   -> list(목록보기),Edit(수정하기),Delete(삭제하기)를 바로 사용할 수 있게 링크를 연결하였습니다.
   -> 게시글 등록일을  YYYY/MM/DD hh24:mi 형식으로 표시하였습니다.

3. 게시글 등록 (/writeform)
   -> name, title, content, password를 입력받게끔 구현하였습니다.

4. 게시글 삭제 (/deleteform?id=아이디)
   -> 삭제하기 전 password를 입력받고 password를 일치시켜야 delete가 가능하게끔 구현하였습니다.

5. 게시글 수정 (/updateform?id=아이디)
   -> name, title, content, password를 수정할 수 있게끔 하였습니다.


[미구현한 기능]
게시글 등록 시 created at이 default값으로 설정되지 않아 수정이 필요합니다.
