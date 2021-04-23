package gdu.diary.dao;

public class TodoQuery {
	public final static String DELETE_TODO_BY_MEMBER;//아이디 삭제시 게시물 삭제
	
	static {//스태틱 블럭은 스태틱 필드를 초기화 하기 위해서 사용한다.
		DELETE_TODO_BY_MEMBER = "DELETE FROM member WHERE member_no=?";
	}

}
