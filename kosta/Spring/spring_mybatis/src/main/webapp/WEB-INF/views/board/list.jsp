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
<h3>글목록</h3>
<a href="${pageContext.request.contextPath }/board/write">글 작성</a><br>

<c:if test="${empty list }">
	작성된 글이 없습니다.
</c:if>
<c:if test="${not empty list }">
	<table border="1">
		<tr>
			<th>글 번호</th>
			<th>제목</th>
			<th>작성자</th>
		</tr>
		<c:forEach var="b" items="${list }">
		<tr>
			<td>${b.num }</td>
			<!-- /board/detail?num=${b.num } -> Controller에서 @Param 으로 사용할 수 있음 -->
			<td><a href="${pageContext.request.contextPath }/board/detail/${b.num }">${b.title }</a></td>
			<td>${b.writer }</td>
		</tr>
		</c:forEach>
	</table>
</c:if>
<a href="${pageContext.request.contextPath }/member/menu">메뉴로 돌아가기</a><br>
</body>
</html>