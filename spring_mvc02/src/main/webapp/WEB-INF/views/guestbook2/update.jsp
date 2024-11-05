<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 방 명 록 2 </title>
<link rel="stylesheet" href="resources/css/summernote-lite.css">
<style type="text/css">
	a { text-decoration: none;}
	table{width: 600px; border-collapse:collapse; text-align: center;}
	table,th,td{border: 1px solid black; padding: 3px}
	div{width: 600px; margin:auto; text-align: center;}
	
	/* summernote toolbar 수정  */
	.note-btn-group{width: auto;}
	.note-toolbar{width: auto;}
</style>
<script type="text/javascript">
	 <c:if test="${pwdchk == 'fail'}">
	 	alert("비밀번호 틀림");
	 </c:if>
</script>
</head>
<body>
	<div>
		<h2>방 명 록 2 : 수 정 화 면</h2>
		<hr>
		<p>[<a href="/gb2_list">목록으로 이동]</a></p>
		<form method="post" enctype="multipart/form-data" action="/gb2_update_ok" >
			<table>
				<tr align="center">
					<td bgcolor="#99ccff">작성자</td>
					<td><input type="text" name="gb2_name" size ="20" value="${gb2VO.gb2_name }"></td>
				</tr>
				<tr align="center">
					<td bgcolor="#99ccff">제  목</td>
					<td><input type="text" name="gb2_subject" size ="20" value="${gb2VO.gb2_subject }"></td>
				</tr>
				<tr align="center">
					<td bgcolor="#99ccff">email</td>
					<td><input type="text" name="gb2_email" size ="20" value="${gb2VO.gb2_email }"></td>
				</tr>
				<tr align="center">
					<td bgcolor="#99ccff">첨부파일</td>
					<c:choose>
						<c:when test="${empty gb2VO.gb2_f_name }">
							<td>
								<input type="file" name="gb2_file_name"><b>이전 파일 없음</b>
								<input type="hidden" name="old_f_name" value="">
							</td>
						</c:when>
						<c:otherwise>
							<td>
								<input type="file" name="gb2_file_name"><b>이전 파일 (${gb2VO.gb2_f_name}) </b>
								<input type="hidden" name="old_f_name" value="${gb2VO.gb2_f_name}">
							</td>
						
						</c:otherwise>
					</c:choose>
				</tr>
				
				<tr align="center">
					<td bgcolor="#99ccff">비밀번호</td>
					<td><input type="password" name="gb2_pw" size ="20"></td>
				</tr>
				<tr align="center">
					<td colspan="2">
						<textarea rows="10" cols="60" name="gb2_content" id="gb2_content">${gb2VO.gb2_content } </textarea>
					</td>
				</tr>
				<input type="hidden" name="gb2_idx" value="${gb2VO.gb2_idx }">
				<tfoot>
					<tr align="center">
						<td colspan="2">
							<input type="submit" value="수정완료">
							<input type="reset" value="취소">
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js" crossorigin="anonymous"></script>
	<script src="resources/js/summernote-lite.js" ></script>
	<script src="resources/js/lang/summernote-ko-KR.js" ></script>
	<script type="text/javascript">
		$(function() {
			$("#gb2_content").summernote({
				lang : 'ko-KR',
				height : 300,
				focus : true,
				placeholder : "최대 3000자까지 쓸 수 있습니다.",
				callbacks : {
					onImageUpload : function(files, editor) {
						for (let i = 0; i < files.length; i++) {
							sendImage(files[i], editor);
						}
					}
				}
			});
		});
		
		function sendImage(file, editor) {
			// FormData 객체를 전송할 때 , jQuery가 설정
		  let frm = new FormData();
		  frm.append("s_file", file);
		  $.ajax({
			  url : "/saveImg",
			  data : frm,
			  method : "post",
			  contentType : false,
			  processData : false,
			  cache : false,
			  dataType : "json",
			  success : function(data) {
				 const path = data.path;
				 const fname = data.fname ;
				 console.log(path, fname);
				 $("#gb2_content").summernote("editor.insertImage", path+"/"+fname);
			  },
			  error : function() {
				alert("읽기실패");
			}
		  });
		}
	</script>
</body>
</html>



