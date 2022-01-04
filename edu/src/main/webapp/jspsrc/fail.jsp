<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.time.LocalTime" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<img src="images/fail.jpg">
	<%
	Date now = new Date();
	%>
	<%
	LocalTime lt = LocalTime.now();
	%>
	<%
	SimpleDateFormat sf = new SimpleDateFormat("HH시 mm분");
	String ltf = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH시 mm분"));
	String today = sf.format(now);
	%>
	<h1><%=ltf %> 에 실패 ~~ 아쉽 아쉽</h1>
	
	<a href="/edu/htmlexam/lottoForm2.html" >로또 응모</a>
</body>
</html>