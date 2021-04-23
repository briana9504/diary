package gdu.diary.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import gdu.diary.util.DBUtil;
import gdu.diary.vo.Member;

public class TodoDao {
	private DBUtil dbUtil;
	
	//게시물 삭제
	public int deleteTodoByMember(Connection conn, int memberNo) throws SQLException {
		this.dbUtil = new DBUtil();
		int rowCnt = 0;
		PreparedStatement stmt = null;
		
		try {
			stmt = conn.prepareStatement(TodoQuery.DELETE_TODO_BY_MEMBER);
			stmt.setInt(1, memberNo);
			System.out.printf("stmt: %s<TodoDao.deleteTodoByKey()>\n", stmt);
			rowCnt = stmt.executeUpdate();
		} finally {
			this.dbUtil.close(null, stmt, null);
		}
	
		return rowCnt;
		
	}

}
