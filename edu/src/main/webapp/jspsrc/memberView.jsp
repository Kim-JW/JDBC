<%@page import="vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> 회원 정보</h1>
<hr>
	<%
		MemberVO mv = (MemberVO)request.getAttribute("memberInfo");
	%>
	<ul>
		<li>회원 이름 : <%= mv.getName() %> </li>
		<li>회원 계정 : <%= mv.getId() %> </li>
		<li>회원 암호 : <%= mv.getPasswd() %> </li>
		<li>회원 전화번호 : <%= mv.getPhoneNum() %> </li>
	</ul>
	
</body>
</html>