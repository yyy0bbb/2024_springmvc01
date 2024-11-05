<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js" crossorigin="anonymous"></script>
</head>
<body>
	<h2>카카오 로그인 성공</h2>
	<div id="result"></div>


	<!-- 계정과 함께 로구아웃 https://kauth.kakao.com/oauth/logout  -->
	<a href="https://kauth.kakao.com/oauth/logout?client_id=b5f410ecff989a50c723ace71fc36755&logout_redirect_uri=http://localhost:8080/kakaologout">로그아웃</a>
	
	<script type="text/javascript">
	//$(document).ready(function() {});
	$(function() {
		$("#result").empty();
		$.ajax({
			url : "/kakaoUserInfo",
			method : "post",
			dataType : "json",
			success : function(data) {
				const name = data.properties.nickname;
				const img = data.properties.profile_image;
				const email = data.kakao_account.email;
				
				let str = "<li>닉네임 : "+ name + "</li>";
					 str = "<li>이메일 :"+ email +  " </li>";
					str += "<li>이미지 : <img src=${profileImage}> </li>";
				$('#result').append(str);
			},
			error : function() {
				alert("읽기 실패");
			}			
		});
	});
	
	</script>

</body>
</html>