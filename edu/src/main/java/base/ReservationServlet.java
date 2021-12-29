package base;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReservationServlet
 */
@WebServlet("/reservation")
public class ReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String place = request.getParameter("selection");
		String[] options = request.getParameterValues("option");
		String date = request.getParameter("date_of_reservation");
		// LocalDate date = LocalDate.parse(request.getParameter("date"));
		
		SimpleDateFormat indate = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat output = new SimpleDateFormat("yyyy년 MM월 dd일");
		
		Date d = null;
		try {
			d = indate.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String outputDate = output.format(d);
		
		out.print("<h1>"+ name + "님의 예약 내용</h1><br><hr>");
		out.print("<li>휴양림 : " + place + "</li>");
		
		out.print("<li>추가 요청 사항 : ");
		
		for(String str : options) {
			out.print(str + ", ");
		}
		
		out.print("<br><li>예약날짜 : " + outputDate + "</li><br>");
	}

}
