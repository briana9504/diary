package gdu.diary.service;

import java.sql.Connection;
import java.sql.SQLException;

import gdu.diary.dao.MemberDao;
import gdu.diary.util.DBUtil;
import gdu.diary.vo.Member;

public class MemberService {
	private MemberDao memberDao;
	private DBUtil dbUtil;
	//select -> get
	//insert -> add
	//update -> modify
	//delete -> remove
	
	//비밀번호 바꿈
	public void modifyMemberPw(Member member) {
		this.dbUtil = new DBUtil();
		this.memberDao = new MemberDao();
		Connection conn = null;
		
		
		try {
			conn = this.dbUtil.getConnection();
			this.memberDao.updateMemberPw(conn, member);
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			this.dbUtil.close(null, null, conn);
		}
		
	}
	
	
	//아이디 중복검사
	public String checkMemberIdForInsert(Member member) {
		String returnMemberId = null;
		this.dbUtil = new DBUtil();
		this.memberDao = new MemberDao();
		Connection conn = null;
			
		try {
			conn = this.dbUtil.getConnection();
			returnMemberId = this.memberDao.checkMemberId(conn, member);
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			this.dbUtil.close(null, null, conn);
		}
		return returnMemberId;
	}
	//회원가입 = 아이디 중복검사는...?
	public void addMember(Member member) {
		this.dbUtil = new DBUtil();
		this.memberDao = new MemberDao();
		Connection conn = null;
		try {
			conn = this.dbUtil.getConnection();
			this.memberDao.insertMember(conn, member);
			conn.commit();
		} catch(SQLException e){
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			this.dbUtil.close(null, null, conn);
		}
	}
	
	//로그인
	public Member getMemberByKey(Member member) {
		this.memberDao = new MemberDao();
		this.dbUtil = new DBUtil();
		Member returnMember = null;
		Connection conn = null;
		try {
			conn = dbUtil.getConnection();
			returnMember = this.memberDao.selectMemberByKey(conn, member);
			conn.commit();
		} catch(SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			this.dbUtil.close(null, null, conn);
		}
		return returnMember;
	}

}
