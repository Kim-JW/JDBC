package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cal")
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		String oper = request.getParameter("oper");
		int result = 0;
		String msg = "나눗셈 연산시 두 번째 숫자는 0일 수 없습니다!!";

		if (num2 == 0 && oper.equals("/")) {
			request.setAttribute("result", msg);
			request.getRequestDispatcher("/jspsrc/errorResult.jsp").forward(request, response);
		} else {
			result = cal(num1, num2, oper);
			request.setAttribute("result", result);
			request.getRequestDispatcher("/jspsrc/calcResult.jsp").forward(request, response);
		}

	}

	public int cal(int num1, int num2, String oper) {
		int ret = 0;
		
		if (oper.equals("+")) {
			ret = num1 + num2;
		} else if (oper.equals("*")) {
			ret = num1 * num2;
		} else if (oper.equals("-")) {
			ret = num1 - num2;
		} else {
			ret = num1 / num2;
		}
		return ret;

	}

}
