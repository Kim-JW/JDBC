<%@page import="vo.ProductVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> 선택된 상품 정보는 다음과 같습니다.</h1>
	<hr>
	<h3>선택된 사과의 개수 : ${fruitInfo.apple_cnt}</h3>
	<h3>선택된 바나나의 개수 : ${fruitInfo.banana_cnt} </h3>
	<h3>선택된 한라봉의 개수 : ${fruitInfo.hanla_cnt} </h3>
	<hr>
	<a href="${header.referer}" style='
color: orange;
font-size: 2.0em;
font-weight: bold;
background: #efefef;
'> 상품 선택화면 </a>
</body>
</html>