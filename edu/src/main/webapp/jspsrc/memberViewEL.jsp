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
	<ul>
		<li>회원 이름 : ${requestScope.memberInfo.name}</li>
		<li>회원 계정 : ${requestScope.memberInfo.id}</li>
		<li>회원 암호 : ${requestScope.memberInfo.passwd} </li>
		<li>회원 전화번호 : ${requestScope.memberInfo.phoneNum} </li>
	</ul>
	
</body>
</html>