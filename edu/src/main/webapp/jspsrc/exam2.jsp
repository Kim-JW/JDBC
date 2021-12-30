<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%! int member_v = 0; %>
	<%
		int local_v = 0;
		member_v += 10;
		local_v +=10;
	%>
	<h1>JSP의 멤버 변수와 지역 변수</h1>
<hr>
<ul>
	<li> 멤버 변수 : <%= member_v %></li>
	<li> 지역 변수 : <%= local_v %></li>
</ul>
	
</body>
</html>