<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>${sessionScope.loginid } 's Info</h3>
	<form action="/member/edit" method="POST">
		ID : ${m.id}<br>
		new Password : <input type="password" name="pwd" value="${m.pwd }"><br>
		Name : ${m.name } <br>
		new Email : <input type="email" name="email" value="${m.email }"><br>
		<input type="hidden" name="id" value="${m.id }">
		<input type="submit" value="수정">
	</form>
</body>
</html>