<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>member info</h3>
${m.id } / ${m.pwd } / ${m.name } /${m.email } / <a href="${pageContext.request.contextPath }/member/login">로그인</a>
</body>
</html>