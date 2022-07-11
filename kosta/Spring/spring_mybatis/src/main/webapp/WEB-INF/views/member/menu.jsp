<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>${sessionScope.loginid }님, 환영합니다.</h3>
	<a href="/member/myinfo">내 정보 확인</a>
	<a href="/member/list">회원 목록</a>
	<a href="/member/logout">로그아웃</a>
	<a href="/member/out">탈퇴</a>
	<a href="/board/list">게시판 글 목록</a>
</body>
</html>