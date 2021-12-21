package mysql.level1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TableCreate {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException cnfe) {
			System.out.println("해당 클래스를 찾을 수 없습니다." + cnfe.getMessage());
			return;
		} 
		Connection conn = null;
		Statement stmt = null;
		try {
			// ?이후에 mysql 8 부터 파라미터 같이 넘겨주어야함.
			String url = "jdbc:mysql://localhost:3306/jdbcdb?characterEncoding=UTF-8&serverTimezone=UTC";
			String user = "root";
			String passwd = "1234";
			
			// DB서버 접속
			conn = DriverManager.getConnection(url, user, passwd);	
			System.out.println("데이터베이스에 접속했습니다.");
			
			stmt = conn.createStatement(); // 팩토리 메서드
			// Insert는 1, delete 삭제된 행의 개수, update 수정된 행의 갯수, ddl 은 테이블이기 때문에 0
			// return 값 많이 사용 안함.
			stmt.executeUpdate("create table student (name varchar(10), score int)"); // return 값이 숫자. 주어진 sql명령에 의해 변해진 행의 개수. 여기서는 0
			System.out.println("student 테이블 생성");						
		} catch (SQLException se1) {
			System.out.println(se1.getMessage());
		} finally {
			try {
				if(stmt!= null)
				// close 는 반드시 예외 처리 해주는게 좋음.
				// nullPointException 확실하게 코드 짜기.(견고하게)
				// 문제 발생시 처리 가능하도록 
					stmt.close();
				if(conn != null)
					conn.close();
			} catch (SQLException se2) { // Exception e 이면 모든 에러 메시지를 처리하겠다라는 의미이기 때문에 런타임 오류가 안남. SQLException 해야 오류처리 확실.
				System.out.println(se2.getMessage());
			}
		}
	}
}
