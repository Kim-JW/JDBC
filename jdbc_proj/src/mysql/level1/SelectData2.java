package mysql.level1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SelectData2 {
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
		try (Connection conn = DriverManager.getConnection(url, user, passwd);
				PreparedStatement pstmt = conn.prepareStatement("select score from student where name = ?");
				Scanner scan = new Scanner(System.in);){
		    System.out.print("학생 이름을 입력하세요 : ");
		    String name = scan.nextLine();
		    pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();
			// select된 결과가 없을 때는? ResultSet 객체가 return 되기는 한다. 그렇기 때문에 next()를 한번이라도 수행해야 들어있는지 없는지 알 수 있다. 비어 있을때는 false 를 return 한다.
			// 로그인 패스워드 처리에서 쓰일 수도 있음.
			
			if(rs.next()) 
				System.out.println(name + "학생의 점수 : " + rs.getInt("score"));
			else 			
				System.out.println(name + "학생에 대한 데이터가 없습니다.");
			 System.out.println("수행 종료...");
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
	}
}
