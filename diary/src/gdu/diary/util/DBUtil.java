package gdu.diary.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	//Connection을 만들어줌
	public Connection getConnection() {
		Connection conn = null;
		//정확한 예외 처리
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/diary","root","java1004");
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//finally에 close를 안쓰는 이유?
		//Connection을 만들어서 쓰는거기 때문에 close를 쓰는것이 아님...
		return conn;
	}
	
	//2. DB연결(conn, stmt, rs) 해제 -gabage collect가 정리하기 전에 정리해야할 것이 있음: 강제로 메모리 안에서 삭제해줄 필요가 있음
		//정리할때는 최근에 생긴 순서로 정리함
		public void close(ResultSet rs, PreparedStatement stmt, Connection conn) {
			if(rs != null) {//if 문으로 NullpointException 막음
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}	
		}

}
