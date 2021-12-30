package base;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/move")
public class MoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// action 이라는 이름으로 전달되는 쿼리 문자열 추출
		String webname = request.getParameter("action");
		
		// 각 action에 따른 redirect 웹사이트 주소 삽입
		if(webname!= null) {
			String website = "";
			if(webname.equals("naver")) {
				website = "http://naver.com";
			} else if(webname.equals("daum")) {
				website = "http://daum.net";
			} else if(webname.equals("google")) {
				website = "http://google.com";
			}
			// redirect 전달
			response.sendRedirect(website);
		}
		// web 값이 null 일경우
		else {
			// html 글자 출력
			response.setContentType("text/html; charset = UTF-8");
			PrintWriter out = response.getWriter();
			
			out.print("<h2>전달된 쿼리 문자열이 없어서 MoveServlet이 직접 응답합니당..</h2>");
			out.close();
		}
	}

}
