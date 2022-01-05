package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.MemberVO;

@WebServlet("/member")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 추출 전에 encoding 해줘야함.
		request.setCharacterEncoding("utf-8");
		String m_name = checkNull(request.getParameter("name"));
	 	String m_phoneNum = checkNull(request.getParameter("phoneNumber"));
		String m_id = checkNull(request.getParameter("id"));
		String m_passwd = checkNull(request.getParameter("passwd"));
		
		MemberVO mv = new MemberVO();
		
		mv.setName(m_name);
		mv.setPhoneNum(m_phoneNum);
		mv.setId(m_id);
		mv.setPasswd(m_passwd);
		
		request.setAttribute("memberInfo", mv);
		request.getRequestDispatcher("/jspsrc/memberViewEL.jsp").forward(request, response);
	}
	
	public String checkNull(String str) {
		if (str == null) {
			return "없음";
		} else {
			return str;
		}
	}

}
