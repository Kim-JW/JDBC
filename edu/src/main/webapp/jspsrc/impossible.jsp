<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import= "java.util.Calendar" %>
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
	Calendar cal = Calendar.getInstance();
	cal.setTime(now);
	cal.add(Calendar.MINUTE,30);
	String today = sf.format(cal.getTime());
	%>
	<h1>더 이상 응모 할 수 없어요.. <%= today %> 브라우저를 재가동한 후에는 가능하답니다.</h1>
</body>
</html>