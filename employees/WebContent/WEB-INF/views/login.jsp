<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>
<div>
	<!-- 로그인 폼 -->
	<h1>로그인</h1>
	<form method="post" action="${pageContext.request.contextPath}/login">	
		<div>
			<label for="empNo">emp_no</label>
			<input type="text" name="empNo">
		</div>
		<div>
			<label for="firstName">first_name</label>
			<input type="text" name="firstName">
		</div>
		<div>
			<label for="lastName">last_name</label>
			<input type="text" name="lastName">
		</div>
		<div>
			<button type="submit">로그인</button>
		</div>
	</form>	
</div>
</body>
</html>