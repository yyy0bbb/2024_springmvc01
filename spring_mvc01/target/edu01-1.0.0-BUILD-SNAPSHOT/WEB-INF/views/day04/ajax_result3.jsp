<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
    span { width: 150px; color : red;}
    input{border: 1px solid red;}
	table{width: 80%; margin: 0 auto;}
	table, th, td { border: 1px solid lightgray; text-align: center;}
	h2{text-align: center;}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
	<h2>Ajax를 활용한 DB처리</h2>
	<h2>회원 정보 입력하기</h2>
	<form method="post" id="myForm">
		<table>
			<thead>
				<tr><th>아이디</th> <th>패스워드</th><th>이름</th><th>나이</th></tr>
			</thead>
			<tbody>
				<tr>
					<td>
						<input type="text" size="14" name="m_id" id="m_id"><br><span>중복여부</span>
					</td>
					<td><input type="password" size="10" name="m_pw"></td>
					<td><input type="text" size="14" name="m_name"></td>
					<td><input type="number" size="14" name="m_age"></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="4" align="center"><input type="button" value="가입하기" id="btn_join" disabled> </td>
				</tr>
			</tfoot>
		</table>
	</form>
	<br><br><br><br>
	<h2>회원 정보 보기</h2>
	<div>
		<table id="list">
			<thead>
				<tr><th>번호</th><th>아이디</th><th>패스워드</th><th>이름</th><th>나이</th><th>가입일</th><th>삭제</th></tr>
			</thead>
			<tbody id="tbody"></tbody>
		</table>
	</div>
	
	
	<script type="text/javascript">
		// ajax를 이용해서 DB정보 가져오기 (첫 접속, 삭제, 삽입) 
		function getList() {
			$.ajax({
				url : "/ajax_db_list",
				method : "post",
				dataType : "xml",
				success : function(data) {
					
				},
				error : function() {
					
				}
			});
		}
		getList();
	</script>
</body>
</html>
















