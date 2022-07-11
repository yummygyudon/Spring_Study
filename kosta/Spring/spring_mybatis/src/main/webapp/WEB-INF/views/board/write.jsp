<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>글 쓰기</h3>

<form action="${pageContext.request.contextPath }/board/write" method="POST">
	<table border="1">
		<tr>
			<th>작성자</th> <td> <input type="text" name="writer" value="${sessionScope.loginid }" readonly> </td>		
		</tr>
		<tr>
			<th>제목</th> <td> <input type="text" name="title" > </td>		
		</tr>
		<tr>
			<th>내용</th> <td> <textarea rows="10" cols="45" name="content"></textarea> </td>		
		</tr>
		<tr>
			<td colspan="2"><input type="reset" value="초기화"> &nbsp; <input type="submit" value="저장"></td>		
		</tr>
	</table>
</form>
</body>
</html>