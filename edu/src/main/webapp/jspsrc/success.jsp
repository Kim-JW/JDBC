<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	Date now = new Date();
	%>
	<%
	SimpleDateFormat sf = new SimpleDateFormat("HH시 mm분");

	String today = sf.format(now);
	%>
	<h1><%= today%> 에 당첨 ~~ 추카추카추카</h1>
	<img src="images/success.jpg">
</body>
</html>