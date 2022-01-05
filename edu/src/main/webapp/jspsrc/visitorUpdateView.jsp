<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> 방명록 수정</h1>
	<hr>
	<form method = "post" action = "/edu/visitordb2">
		<input type = "hidden" name = "id" value = "${updatevo.id }">
		이름 : <input type = "text" value = "${updatevo.name }" required name="gname">
		<br>
		남기고자 하는 의견 : <br>
		<textarea rows="10" cols="35" name = "gmemo"> ${updatevo.memo }</textarea>
		<br>
		<input type = "submit" value = "수정">
		<input type = "reset" value = "재작성">
		 </form>
<hr>
<a href="/edu/htmlexam/visitorMain.html"> 방명록 홈 화면으로 가기</a>
</body>
</html>