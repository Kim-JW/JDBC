<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String name = request.getParameter("study");
	String send_url = null;
	RequestDispatcher rd = null;
	%>
	<%
	if (name == null){
	%>
		<h2> study 라는 이름으로 전달된 쿼리가 존재하지 않습니다.</h2>
	<% 	
	} else {
		switch(name){
		case "javascript":
			send_url = "http://www.w3schools.com/js/default.asp";
			break;
		case "dom":
			send_url = "http://www.w3schools.com/js/js_htmldom.asp";
			break;
		case "ajax":
			send_url = "http://www.w3schools.com/xml/ajax_intro.asp";
			break;
		case "json":
			send_url = "http://www.w3schools.com/js/js_json_intro.asp";
			break;
		case "jsp":
			%>
			<jsp:forward page="/jspsrc/exam6.jsp?dan=7"/>
			<%
			break;
		case "html":
			%>
			<jsp:forward page="/htmlexam/first.html"/>
			<%
			break;
		}
		response.sendRedirect(send_url);
	%>
	
	<%
	}
	%>
</body>
</html>