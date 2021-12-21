package mysql.homework2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertDataLab {

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

			System.out.println("데이터베이스에 접속했습니다.");
			stmt.executeUpdate("insert into meeting (name, title, meetingdate) values ('둘리', '자바 공부', now())");
			stmt.executeUpdate("insert into meeting (name, title, meetingdate)  values ('또치', '영화 보기', '2021-12-25 12:00')");
			stmt.executeUpdate("insert into meeting (name, title, meetingdate) values ('도우너', 'PC방', '2022-01-01')");
			System.out.println("meeting 테이블에 데이터 삽입 완료");						
		} catch (SQLException se1) {
			System.out.println(se1.getMessage());
		}
	}

}
