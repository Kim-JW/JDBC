package base;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/basket")
public class BasketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String method = request.getMethod();
		
		String pid = request.getParameter("pid");
		out.print("<h1> 선택한 상품 : " + pid + "<h1>");
		
		pid = request.getParameter("pid").substring(1);
		
		int pNum = Integer.parseInt(pid);
		String num = String.valueOf(pNum);
		String fname = "<img src=http://localhost:8080/edu/ramen_imgs/" + num + ".jpg >";
		
		if(method.equals("POST"))
			request.setCharacterEncoding("utf-8");
		
		out.print(fname);
		
		out.print("</ul><hr>");
		out.print("<h2><a href= '/edu/htmlexam/productlog.html'>실행 선택 화면</a><h2>");
		request.getHeader("referer");
		
		out.close();	
		
	}

}
