package gdu.diary.service;

import java.sql.Connection;
import java.sql.SQLException;

import gdu.diary.dao.MemberDao;
import gdu.diary.dao.TodoDao;
import gdu.diary.util.DBUtil;
import gdu.diary.vo.Member;

public class MemberService {
	private MemberDao memberDao;
	private TodoDao todoDao;
	private DBUtil dbUtil;
	//select -> get
	//insert -> add
	//update -> modify
	//delete -> remove
	
	//회원탈퇴 - 삭제 실패(rollback) : false  삭제 실패: true
	public boolean removeMemberByKey(Member member) {
		this.dbUtil = new DBUtil();
		this.memberDao = new MemberDao();
		this.todoDao = new TodoDao();
		Connection conn = null;
		int todoRowCnt = 0;
		int memberRowCnt = 0;
		
		try {
			conn = dbUtil.getConnection();
			todoRowCnt = this.todoDao.deleteTodoByMember(conn, member.getMemberNo());
			memberRowCnt = this.memberDao.deleteMemberByKey(conn, member);
			System.out.printf("todo: %s\n member: %s\n",todoRowCnt,memberRowCnt);
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			return false;
		} finally {
			this.dbUtil.close(null, null, conn);
		}
		return (todoRowCnt+memberRowCnt) > 0;
	}
	
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
	
	//아이디 중복검사 + 회원가입...?
	public boolean checkMemberIdAndAddMember(Member member) {
		this.dbUtil = new DBUtil();
		this.memberDao = new MemberDao();
		Connection conn = null;
		boolean checkId = false;
			
		try {
			conn = this.dbUtil.getConnection();
			if(this.memberDao.checkMemberId(conn, member) != null){//아이디 있음..아이디 생성하면 안됨
				System.out.println("아이디가 이미 존재합니다.");
				checkId = false;
			} else {//아이디 없음 ..생성가능
				this.memberDao.insertMember(conn, member);
				checkId = true;
			}
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			checkId = false;
		} finally {
			this.dbUtil.close(null, null, conn);
		}
		return checkId;
	}
	/*
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
	//회원가입
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
	*/
	
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
