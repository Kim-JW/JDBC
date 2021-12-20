package mysql.level1;
import java.sql.Connection;
import java.sql.DriverManager;

/*
 * URL : Uniform Resource Locator
 * --> HTTP URL
 * 
 * 
 * 
 * 
 */

public class ConnectDB {
	public static void main(String args[]) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/sqldb?characterEncoding=UTF-8&serverTimezone=UTC";
			String user = "root";
			String passwd = "1234";
			Connection conn = DriverManager.getConnection(url, user, passwd);
			conn.close();
			System.out.println("MYSQL ���� ����");
		} catch (Exception e) {
			System.out.println("MYSQL ���� ����");
			System.out.print("���� : " + e.getMessage());
		}
	}
}
