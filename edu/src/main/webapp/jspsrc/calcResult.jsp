<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>연산 요청 결과</h1>
	<hr>
	<p >결과 : <span style="color:red"><%= request.getAttribute("result") %> </span></p>
	<a href="<%= request.getHeader("referer") %>"> 입력화면</a>
</body>
</html>