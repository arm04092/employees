<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
	<!-- 로그인 폼 -->
	<h1>로그인</h1>
	<form method="post" action="${pageContext.request.contextPath}/login">	
		<div>
			<label for="empNo">emp_no</label>
			<input type="text" name="empNo" value="10000">
		</div>
		<div>
			<label for="firstName">first_name</label>
			<input type="text" name="firstName" value="Lee">
		</div>
		<div>
			<label for="lastName">last_name</label>
			<input type="text" name="lastName" value="Wonjun">
		</div>
		<div>
			<button type="submit">로그인</button>
		</div>
	</form>	
</div>
</body>
</html>