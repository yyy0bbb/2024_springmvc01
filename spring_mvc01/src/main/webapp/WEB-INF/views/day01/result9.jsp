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
	<h2> 결과보기 </h2>
	<h2> ${s1} ${op} ${s2} = ${result} </h2>
	<h2> cPage : ${cPage} </h2>
	<h2>
		<c:forEach var="k" items="${hobby}">
		  <li>${k }</li>
		</c:forEach>
	</h2>
</body>
</html>