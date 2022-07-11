<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	const xhttp = new XMLHttpRequest() ; //  비동기 요청 객체
	
	/* 
	응답이 왔을 때 자동 호출 
	{flag : true} _ JSON 형식
	*/
	xhttp.onload = function(){
		if(xhttp.readyState==4){ // 요청이 정상적으로 전달되었는지 확인 : 4
			if(xhttp.status==200){ // 응답 결과가 200(정상) 인지 _ 500:논리적인 오휴 / 404:경로 탐색 불가 오류 / 400 : 잘못된 서버 요구값 전달
				alert(xhttp.responseText); // JSON 형식
				let res = JSON.parse(xhttp.responseText);
				let text = "";
				
				if(res.flag){
					text="사용 가능한 아이디" ;
				} else {
					text="사용 불가능한 아이디" ;
				}
				
				document.getElementById("res").innerHTML = text ;
				
			}else {
				alert("응답 Code Error !! : " + xhttp.status) ;
			}
		}else {
			alert("요청 Code Error !! : " + xhttp.readState) ;
		}
	}
	
	const idDistinctCheck =()=> {
		const idVal = document.getElementById("id").value;
		alert(idVal) ;
		// 서버에 보낼 요청 설정 : open(전송방식, 서버페이지 경로, true/false)
		xhttp.open("get", "/member/idcheck?id="+idVal); // Controller에서 @RequestMapping("/idcheck") 와 Mapping 됨
		xhttp.send(); // 요청 전송 (페이지는 이동하지 않는다. -> 비동기)
	}

/*
	function createXMLHttpRequest() {
		if(window.ActiveXObject){ // Microsoft 일 경우
			xhr = new ActiveXObject("Microsoft.XMLHTTP") ;
		// alert("MS");
		} else {
			xhr = new XMLHttpRequest();
		}
	}
	
	function startRequest(){
		// xhr : 통신의 주체(XMLHttpRequest 객체) 
		createXMLHttpRequest();
		xhr.onreadystatechange
	}
*/
</script>
</head>
<body>

	<h3>회원 가입</h3>
	<form action="${pageContext.request.contextPath }/member/join" method="POST">
		id : <input type="text" name="id" id="id"> <span id="res"></span> <input type="button" value="중복체크" onclick="idDistinctCheck()"> <br>
		
		password : <input type="password" name="pwd"><br>
		name : <input type="text" name="name"><br>
		email : <input type="email" name="email"><br>
		<input type="submit" value="가입">
	</form>


</body>
</html>