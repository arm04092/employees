<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>employeesCountByGender</title>
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
	<h1>성별 사원 수</h1>
	<!-- 홈 버튼 -->
	<div>
		<a href="${pageContext.request.contextPath}/" class="btn btn-primary">홈으로</a>
	</div>
	<!-- 성별 사원 테이블 -->
	<table class="table">
		<thead>
			<tr>
				<th>성별</th>
				<th>사원 수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="emp" items="${list}">
				<tr>
					<td>${emp.gender}</td>
					<td>${emp.count}명</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>