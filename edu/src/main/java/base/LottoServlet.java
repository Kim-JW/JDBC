package base;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lotto1")
public class LottoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int winNum = (int)(Math.random()*6+1);
		int inNum = Integer.parseInt(request.getParameter("number"));
		
		RequestDispatcher rd;
		
		if (winNum == inNum) {
			rd = request.getRequestDispatcher("/htmlexam/success.html");
		} else {
			rd =request.getRequestDispatcher("/htmlexam/fail.html");
		}
		
		System.out.printf("전달된 값: %d, 추출된 값 : %d\n",inNum,winNum);		
			
		rd.forward(request, response);		
	}

}
