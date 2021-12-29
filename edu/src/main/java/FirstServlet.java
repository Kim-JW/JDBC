

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// @WebServlet(asyncSupported = true, urlPatterns = { "/first" })

@WebServlet("/first")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// request 안에 Client의 정보들을 담아서 받아서 처리.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Client 객체 생성 전에 설정 해주어야함.
		response.setContentType("text/html; charset=UTF-8"); // document type 절대 오타 내면 안됨
		
		PrintWriter out = response.getWriter(); // 요청 객체를 받아와서 그것을 가지고 수행해야 한다.
		out.print("<h1>FirstServlet 수행 완료</h1>");
		out.print("<hr>");
		out.print("<h2>요청 방식:" + request.getMethod() + "</h2>");
		out.print("<h2>반가워요.... " + request.getParameter("name") + "님!!<h2>"); // url?name = "input";
		
		out.close();
		System.out.println("서블릿에서의 표준 출력은 어디로 나갈까요?");
		
	}

}
