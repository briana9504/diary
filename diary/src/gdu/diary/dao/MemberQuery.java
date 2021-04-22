package gdu.diary.dao;

public class MemberQuery {
	public final static String SELECT_MEMBER_BY_KEY;
	public final static String INSERT_MEMBER;
	public final static String CHECK_MEMEBER_ID;//id유효성 검사
	public final static String UPDATE_MEMBER_PW;//비밀번호 변경
	
		static {//초기화
			SELECT_MEMBER_BY_KEY = "SELECT member_no memberNo, member_id memberId FROM member WHERE member_id=? AND member_pw=PASSWORD(?)";
			INSERT_MEMBER = "INSERT INTO member(member_id, member_pw, member_date) VALUES(?, PASSWORD(?), NOW())";
			CHECK_MEMEBER_ID = "SELECT member_id memberId FROM member WHERE member_id=?";
			UPDATE_MEMBER_PW = "UPDATE member SET member_pw=PASSWORD(?) WHERE member_no=?";
		}
}
