package base;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/lotto2")
public class LottoServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int winNum = (int)(Math.random()*6+1);
		int inNum = Integer.parseInt(request.getParameter("number"));
		
		int local_v = 0;
		
		HttpSession session = request.getSession(); 
		
		if(session.getAttribute("num_cnt") == null) {
			session.setAttribute("num_cnt", new int[1]);
		}
		
		int[] c = (int[])session.getAttribute("num_cnt");
		
		RequestDispatcher rd;
		
		if(c[0] > 3) {
			rd = request.getRequestDispatcher("/jspsrc/impossible.jsp");
		} else {
			if (winNum == inNum) {
				rd = request.getRequestDispatcher("/jspsrc/success.jsp");
				c[0] = 4;
			} else {
				c[0] +=1;
				//session.setAttribute("cnt", c[0]);
				rd =request.getRequestDispatcher("/jspsrc/fail.jsp");
			}
		}
		
		
		System.out.println("cnt = " + c[0]);
		
		System.out.printf("전달된 값: %d, 추출된 값 : %d\n",inNum,winNum);		
			
		rd.forward(request, response);		
	}

}
