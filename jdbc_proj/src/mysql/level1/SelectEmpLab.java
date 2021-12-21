package mysql.level1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectEmpLab {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			
		} catch (ClassNotFoundException cnfe) {
			System.out.println("해당 클래스를 찾을 수 없습니다." + cnfe.getMessage());
			return;
		}
		String url = "jdbc:mysql://localhost:3306/sqldb?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "root";
		String passwd = "1234";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(url, user, passwd);
			System.out.println(conn.getClass().getName());
			
			stmt = conn.createStatement();
			System.out.println(stmt.getClass().getName());
			rs = stmt.executeQuery("Select ename, sal, hiredate from emp");
			System.out.println(rs.getClass().getName());
			
			while(rs.next()) {
				System.out.println(rs.getString("ename") + "," + rs.getDate("hiredate") + "," + rs.getInt("sal"));
			}
			conn.close();
			System.out.println("MYSQL 연결 성공");
		} catch (SQLException se1) {
			System.out.println(se1.getMessage());
			// TODO: handle exception
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (rs != null) {
					stmt.close();
				}
				if (rs != null) {
					conn.close();
				}
				
			} catch (SQLException se2) {
				System.out.println(se2.getMessage());
			}
			
		}

	}

}
