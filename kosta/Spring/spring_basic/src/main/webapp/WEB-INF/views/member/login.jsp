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
<form action="/member/ㅣlogin" method="POST">
	id : <input type="text" name="id"><br>
	pwd : <input type="password" name="pwd"><br>
	<input type="submit" value="로그인"><br>
</form>
<a href="${pageContext.request.contextPath}/member/join">회원가입</a>
</body>
</html>