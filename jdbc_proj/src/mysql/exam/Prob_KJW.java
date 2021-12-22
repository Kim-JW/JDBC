package mysql.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Prob_KJW {
	
	static String url = "jdbc:mysql://localhost:3306/sqldb?characterEncoding=UTF-8&serverTimezone=UTC";
	static String user = "root";
	static String passwd = "1234";

	public static void main(String[] args) {
		
		printEmp("A");
		printEmp("Q");
		printEmp("T");
		
	}
	
	public static void printEmp(String pn) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException cnfe) {
			System.out.println("[오류발생] " + cnfe.getMessage());
			return;
		} 
		
		String p = "%" + pn + "%";
		
		try (Connection conn = DriverManager.getConnection(url, user, passwd);
				PreparedStatement pstmt = conn.prepareStatement("select ename, city\n"
						+ "from emp\n"
						+ "join dept\n"
						+ "using (deptno)\n"
						+ "join locations\n"
						+ "using (loc_code)\n"
						+ "where ename like ?");){
			pstmt.setString(1, p);
			ResultSet rs = pstmt.executeQuery();
			
			
			if(rs.next()) {
				System.out.println("** 이름에 " + pn + " 문자가 들어간 직원들의 리스트 **");
				do {
					System.out.println(rs.getString(1) + "(" + rs.getString(2)+ ")");
				} while(rs.next());
			} else {
				System.out.println("~~ 이름에 " + pn + " 문자가 들어간 직원들은 없음 ~~");
			}
			
							
		} catch (SQLException se) {
			System.out.println("[오류발생] "+ se.getMessage());
		}
		
	}

}
