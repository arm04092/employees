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
	<h3>테이블 정보</h3>
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
				<td>${deptEmpRowCount }</td>
			</tr>
			<tr>
				<td>dept_manager</td>
				<td>${deptManagerRowCount }</td>
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
	<h3>목록</h3>
	<div class="list-group">
		<!-- 사원 목록 -->
		<a href="${pageContext.request.contextPath }/employees/getEmployeesList?limit=10" class="list-group-item list-group-item-action">사원 목록(limit 10)</a>
		<!-- 사원 번호 검색 폼 -->
		<div class="list-group-item list-group-horizontal">
		<form method="post" action="${pageContext.request.contextPath }/employees/getEmployeesListBetween">
			<label for="between">사원 번호</label>
			<input type="number" name="begin">
			<label for="between">~</label>
			<input type="number" name="end">
			<button type="submit" class="btn btn-outline-dark">사원 목록</button>
			<label for="between">(범위: ${minEmpNo}~${maxEmpNo})</label>
		</form>
		</div>
		<div class="list-group-item list-group-flush">
			사원 목록 first_name
			<a href="${pageContext.request.contextPath }/employees/getEmployeesListOrderBy?order=asc" class="list-group-item list-group-item-action">오름차순(limit 50)</a>
			<a href="${pageContext.request.contextPath }/employees/getEmployeesListOrderBy?order=desc" class="list-group-item list-group-item-action">내림차순(limit 50)</a>
		</div>
		<a href="${pageContext.request.contextPath }/employees/getEmployeesCountByGender" class="list-group-item list-group-item-action">성별 사원 수</a>
		<a href="${pageContext.request.contextPath }/departments/getDepartmentsCountByDeptNo" class="list-group-item list-group-item-action">현재 부서별 사원 수</a>
		<!-- 부서 목록 -->
		<a href="${pageContext.request.contextPath }/departments/getDepartmentsList" class="list-group-item list-group-item-action">부서 목록</a>
		<!-- 업무 목록 -->	
		<a href="${pageContext.request.contextPath }/titles/getTitlesList" class="list-group-item list-group-item-action">업무 목록</a>
		<!-- 연봉 통계 -->
		<a href="${pageContext.request.contextPath }/salaries/getSalariesStatistics" class="list-group-item list-group-item-action">연봉 통계</a>
	</div>
</div>
</body>
</html>