package base;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/greeting")
public class GreetingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();

		LocalDate currentDate = LocalDate.now();
		DayOfWeek dow = currentDate.getDayOfWeek();

		String day = DayTransForm(dow);

		if (request.getParameter("guestname") == null) {
			out.print("<h2> 손님! 반가워요.. " + "오늘은 " + dow.getDisplayName(TextStyle.SHORT, Locale.KOREAN) + "요일 입니다!!<h2>");
		} else {
			out.print("<h2>"+ request.getParameter("guestname") + "님 반가워요..! 오늘은 " + dow.getDisplayName(TextStyle.SHORT, Locale.KOREAN) + "요일 입니다!!<h2>");
		}
		
		//dow.getDisplayName(TextStyle.SHORT, Locale.KOREAN);

	}

	public String DayTransForm(DayOfWeek day) {
		String ret = "";

		String today = day.toString();

		switch (today) {

		case "MONDAY":
			ret = "월";
			break;
		case "TUESDAY":
			ret = "화";
			break;
		case "WEDNSDAY":
			ret = "수";
			break;
		case "THURSSDAY":
			ret = "목";
			break;
		case "FRIDAY":
			ret = "금";
			break;
		case "SATURDAY":
			ret = "토";
			break;
		case "SUNDAY":
			ret = "일";
			break;
		}

		return ret;
	}

}
