<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	out.println("JDBC Template : Hello");
%>
<br>
<c:forEach var="dto" items="${users }">
	${dto.id } / ${dto.name }<br>
</c:forEach>
</body>
</html>