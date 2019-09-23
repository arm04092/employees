<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
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
	<h1>Index</h1>
	<h2>테이블 정보</h2>
	<table class="table">
		<thead>
			<tr>
				<th>테이블 이름</th>
				<th>전체 행의 수</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>employees</td>
				<td>${employeesRowCount }</td>
			</tr>
			<tr>
				<td>departments</td>
				<td>${departmentsRowCount }</td>
			</tr>
			<tr>
				<td>dept_emp</td>
				<td>${deptManagerRowCount }</td>
			</tr>
			<tr>
				<td>dept_manager</td>
				<td>${deptEmpRowCount }</td>
			</tr>
			<tr>
				<td>salaries</td>
				<td>${salariesRowCount }</td>
			</tr>
			<tr>
				<td>titles</td>
				<td>${titlesRowCount }</td>
			</tr>
		</tbody>
	</table>
	<!-- WEB APP 네비게이션 -->
	<ul>
		<li><a href="${pageContext.request.contextPath }/departments/getDepartmentsList">부서 목록</a></li>	
		<li><a href="${pageContext.request.contextPath }/employees/getEmployeesList?limit=10">사원 목록</a></li>
		<li>
			사원 목록 first_name
			<a href="${pageContext.request.contextPath }/employees/getEmployeesListOrderBy?order=asc">오름차순(limit 50)</a>
			<a href="${pageContext.request.contextPath }/employees/getEmployeesListOrderBy?order=desc">내림차순(limit 50)</a>
		</li>
	</ul>
</div>
</body>
</html>