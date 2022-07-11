<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>로그인</h3>
	<form action="${pageContext.request.contextPath }/member/login" method="POST">
		id : <input type="text" name="id"><br>
		password : <input type="password" name="pwd"><br>
		<input type="submit" value="로그인">
	</form>
	<a href ="/member/join">회원가입 하기</a>
</body>
</html>