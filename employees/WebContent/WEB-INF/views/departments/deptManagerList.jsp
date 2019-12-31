<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dept Manager List</title>
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
		<!-- deptManagerList.jsp parameter: list -->
		<h1>매니저 목록</h1>
		<!-- 홈 버튼 -->
		<div>
			<a href="${pageContext.request.contextPath}/" class="btn btn-primary">홈으로</a>
		</div>
		
		<!-- 매니저 목록 테이블 -->
		<table class="table">
			<thead>
				<tr>
					<td>부서 이름</td>
					<td>성</td>
					<td>이름</td>
					<td>시작일</td>
					<td>끝일 </td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="deptManager" items="${list}">
					<tr>
						<td>${deptManager.departments.deptName}</td>
						<td>${deptManager.employees.firstName}</td>
						<td>${deptManager.employees.lastName}</td>
						<td>${deptManager.fromDate}</td>
						<td>${deptManager.toDate}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>