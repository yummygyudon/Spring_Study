<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function del =()=? {
		location.href="/board/del/${b.num}";
	}
</script>
</head>
<body>


<h3>${b.writer } 님의 글</h3>

<c:if test="${sessionScope.loginid != b.writer }">
	<c:set var="mode">readonly</c:set>	
</c:if>
<form action="${pageContext.request.contextPath }/board/detail" method="POST">
	<table border="1">
		
		<tr>
			<th>글 번호</th> <td> <input type="text" name="num" value="${b.num}" readonly> </td>		
		</tr>
		<tr>
			<th>작성자</th> <td> <input type="text" name="writer" value="${b.writer}" readonly> </td>		
		</tr>
		<tr>
			<th>제목</th> <td> <input type="text" name="title" value="${b.title }" ${mode }> </td>		
		</tr>
		<tr>
			<th>작성일</th> <td> <input type="date" name="w_date" value="${b.w_date }" readonly > </td>		
		</tr>
		<tr>
			<th>내용</th> <td> <textarea rows="10" cols="45" name="content" ${mode }>${b.content }</textarea> </td>		
		</tr>
	<c:if test="${sessionScope.loginid == b.writer }">
		<tr>
			<td colspan="2"><input type="submit" value="수정"><input type="button" value="삭제" onclick="del()"></td>
		</tr>	
	</c:if>
	
	</table>
</form>


</body>
</html>