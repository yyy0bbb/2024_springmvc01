<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 방 명 록 </title>
<style type="text/css">
	a { text-decoration: none;}
	table{width: 600px; border-collapse:collapse; text-align: center;}
	table,th,td{border: 1px solid black; padding: 3px}
	div{width: 600px; margin:auto; text-align: center;}
</style>

</head>
<body>
	<div>
		<h2>방 명 록 2 : 내 용 화 면</h2>
		<hr>
		<p>[<a href="/gb2_list">목록으로 이동]</a></p>
		<form method="post" >
			<table>
				<tr align="center">
					<td bgcolor="#99ccff">작성자</td>
					<td>${gb2VO.gb2_name }</td>
				</tr>
				<tr align="center">
					<td bgcolor="#99ccff">제  목</td>
					<td>${gb2VO.gb2_subject }</td>
				</tr>
				<tr align="center">
					<td bgcolor="#99ccff">email</td>
					<td>${gb2VO.gb2_email }</td>
				</tr>
				<tr align="center">
					<td bgcolor="#99ccff">첨부파일</td>
					<c:choose>
						<c:when test="${empty gb2VO.gb2_f_name }">
							<td><b>첨부 파일 없음</b></td>
						</c:when>
						<c:otherwise>
						  <td>
						  	<a href="/guestbook2_down?f_name=${gb2VO.gb2_f_name }">
						  		<img src="resources/upload/${gb2VO.gb2_f_name}" style="width: 200px">
						  	</a>
						  </td>
						</c:otherwise>
					</c:choose>
				</tr>
				<tr align="left">
					<td colspan="2">
						<pre style="padding-left: 15px">${gb2VO.gb2_content }</pre> 
					</td>
				</tr>
				<tfoot>
					<tr align="center">
						<td colspan="2">
							<input type="hidden" name="gb2_idx" value="${gb2VO.gb2_idx }">
							<input type="button" value="수정" onclick="update_go(this.form)">
							<input type="button" value="삭제" onclick="delete_go(this.form)">
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
	<script type="text/javascript">
		function update_go(f) {
			f.action="/gb2_update";
			f.submit();
		}
		function delete_go(f) {
			f.action="/gb2_delete";
			f.submit();
		}
	</script>
</body>
</html>















