<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>employeesList</title>
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
	<!-- employeesList.jsp parameter: list -->
	<h1>사원 목록</h1>
	<div>
		<a href="${pageContext.request.contextPath}/" class="btn btn-primary">홈으로</a>
	</div>
	<!-- 테이블 행 개수 선택 폼 -->
	<form method="get" action="${pageContext.request.contextPath}/employees/getEmployeesList">
		<select name="limit">
			<option value="10">10</option>
			<option value="20">20</option>
			<option value="30">30</option>
			<option value="40">40</option>
			<option value="50">50</option>
		</select>
		<label for="limit">개씩 보기</label>
		<button type="submit" class="btn btn-info">사원 목록</button>
	</form>
	<!-- 사원 목록 테이블 -->
	<table class="table">
		<thead>
			<tr>
				<th>사원 번호</th>
				<th>사원 생일</th>
				<th>사원 이름</th>
				<th>사원 성</th>
				<th>사원 성별</th>
				<th>입사 날짜</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="employees" items="${list }">
				<tr>
					<td>${employees.empNo }</td>
					<td>${employees.birthDate }</td>
					<td>${employees.firstName }</td>
					<td>${employees.lastName }</td>
					<td>${employees.gender }</td>
					<td>${employees.hireDate }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>