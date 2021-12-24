package mysql.homework2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class CreateTableLab {

	public static void main(String[] args) {
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException cnfe) {
			System.out.println("해당 클래스를 찾을 수 없습니다." + cnfe.getMessage());
			return;
		}
		
		String url = "jdbc:mysql://localhost:3306/jdbcdb?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "root";
		String passwd = "1234";
		
		try(Connection conn = DriverManager.getConnection(url, user, passwd);
				Statement stmt = conn.createStatement();) {
			
			stmt.executeUpdate("create table meeting (id int primary key auto_increment, name varchar(18), title varchar(120), meetingdate datetime)");
			System.out.println("table 생성 완료.");
		} catch (SQLException se1) {
			System.out.println(se1.getMessage());
		}
		
	}

}
