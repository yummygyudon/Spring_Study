<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>멤버 목록</h3>
	<ul>
		<c:forEach var="m" items="${list }">
			<li>${m.id} / ${m.pwd} / ${m.name} / ${m.email}</li> 
		</c:forEach>
	</ul>
</body>
</html>