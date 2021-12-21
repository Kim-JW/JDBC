package mysql.level1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.*;
import java.sql.Statement;
import java.util.Random;

/*
 * URL : Uniform Resource Locator
 * --> HTTP URL
 * 
 * 
 */

public class SelectEmp {
	public static void main(String args[]) {
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
			stmt = conn.createStatement();
			rs = stmt.executeQuery("Select ename, sal, hiredate from emp"); // executeQuery - Select , 나머지 executeUpdate

			Random random = new Random();
			boolean boolVar = random.nextBoolean();
			//System.out.println(boolVar);
		

			if (boolVar) {
				rs = stmt.executeQuery("Select ename, format(sal,0) 월급 from emp");

				while (rs.next()) {
					//System.out.println(rs.getString("ename") + " 직원의 월급은 " + rs.getString("format(sal,0)") + "원입니다.");
					System.out.println(rs.getString("ename") + " 직원의 월급은 " + rs.getString("월급") + "원입니다.");
					
				}
			} else {
				rs = stmt.executeQuery("Select ename, DATE_FORMAT(hiredate, '%Y년 %m월 %d일') from emp order by hiredate");
				while (rs.next()) {
					System.out.println(rs.getString("ename") + " 직원은 "+ rs.getString(2)+  "일에 입사하였습니다.");
				}
			}
			
//			while (rs.next()) {
//				System.out.println(rs.getString("ename") + "," + rs.getDate("hiredate") + "," + rs.getInt("sal"));
//			}

			//System.out.println("MYSQL 연결 성공");
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
