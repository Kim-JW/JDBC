package mysql.level1;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

/*
 * [java.io 패키지]
 * File (class)- 정보 처리
 * 입출력 3가지: 
 * 파일(file), 
 * 네트워크(Socket),
 * 표준(System.out.println.. , 표준입력 - Scanner), <System.in, System.out, System.err> - static 멤버
 * 
 * 실제 데이터를 처리하고 주고받는 객체는 동일하다 = Stream
 * -> (입력용, 출력용) , (바이트, 문자) 로 나뉘어진다.
 * 
 * -입출력은 운영체제에 굉장히 의존적.
 * 
 * InputStream, OutputStream
 * Reader, Writer <-문자 스트림(내부적 코드 변환)
 * 
 */

public class InsertImage {
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
				Scanner scan = new Scanner(System.in);
				PreparedStatement pstmt = conn.prepareStatement("INSERT INTO imgtest (filename, filecontent) VALUES (?, ?)")){
			
			// 파일 존재하는 위치 : 절대패스, 상대패스(현재 디렉토리 기준으로 하는 경로)
			// 절대 경로 c:/Temp/cat1.png or c:\\Temp\\cat1.png
			// 상대 경로 ../../Temp/cat1.png, ..은 부모 디렉토리 뜻함.
			System.out.print("저장할 이미지 파일명을 절대 패스로 입력하세요 : ");
			String name = scan.nextLine();
			File imgFile = new File(name);
			if (imgFile.exists()) {
				// c:/temp/filename.png 에서 filename.png 뽑아내는 메서드 getName()
				int pointIndex = imgFile.getName().indexOf('.');
				String imgName = imgFile.getName().substring(0, pointIndex);
				System.out.println(imgFile.getName().substring(0, pointIndex));
				FileInputStream fin = new FileInputStream(imgFile); 
				pstmt.setString(1, imgName); 
				pstmt.setBinaryStream(2, fin, (int)imgFile.length());
				pstmt.executeUpdate(); 
				System.out.println("이미지 삽입 성공");
			} else {
				System.out.println("[오류] 이미지가 존재하지 않음");
			}
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}
