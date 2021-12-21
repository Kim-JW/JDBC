package mysql.level1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertData2 {
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
				// 객체 생성시 정의된 명령만 수행 가능.
				// 코드 간략, 더욱 빠름.
				// 바이너리를 사용하려면 PreparedStatement 써야함. Statement는 불가.
				PreparedStatement pstmt = conn.prepareStatement("insert into student values (?, ?)"); // ? 동적 파라미터.
				Scanner scan = new Scanner(System.in);){
			while(true) {
				System.out.print("학생 이름을 입력하세요 : ");
				String name = scan.nextLine();
				System.out.print("학생 점수를 입력하세요 : ");
				int score = Integer.parseInt(scan.nextLine());
				pstmt.setString(1,  name);
				pstmt.setInt(2, score);
				pstmt.executeUpdate();
				System.out.println("student 테이블에 데이터 삽입 완료");
				System.out.print("계속 입력하겠습니까?(y/n)");
				String aws = scan.nextLine();
				if (aws.equalsIgnoreCase("y")) {
					continue;
				} 
				System.out.println("student 테이블 데이터 삽입 작업 종료");
				break;
			}
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		} 
	}
}
