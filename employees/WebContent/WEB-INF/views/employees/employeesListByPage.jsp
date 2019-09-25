<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>employeesListByPage</title>
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
	<!-- parameter: list, currentPage, lastPage -->
	<h1>사원 목록</h1>
	<!-- 홈 버튼 -->
	<div>
		<a href="${pageContext.request.contextPath}/" class="btn btn-primary">홈으로</a>
	</div>
	<!-- 테이블 행 개수 선택 폼 -->
	<div>rowPerPage</div>
	<form method="get" action="${pageContext.request.contextPath}/employees/getEmployeesListByPage" class="form-group">
		<div class="row">
			<div class="input-group mb-3 col-sm-3">
				<div class="input-group-prepend">
					<label class="input-group-text" for="rowPerPage">사원 목록</label>
				</div>
				<select class="form-control" name="rowPerPage">
					<option value="10">10개씩</option>
					<option value="20">20개씩</option>
					<option value="30">30개씩</option>
					<option value="40">40개씩</option>
					<option value="50">50개씩</option>
				</select>
				<div class="input-group-append">
      				<button type="submit" class="btn btn-outline-dark">보기</button>
   				</div>
			</div>
		</div>
	</form>
	<!-- 사원 테이블 -->
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
			<c:forEach var="emp" items="${list}">
				<tr>
					<td>${emp.empNo}</td>
					<td>${emp.birthDate}</td>
					<td>${emp.firstName}</td>
					<td>${emp.lastName}</td>
					<td>${emp.gender}</td>
					<td>${emp.hireDate}</td>
				</tr>
			</c:forEach>	
		</tbody>
	</table>
	<!-- 페이징 버튼 -->
	<div>
		<ul class="pagination">
			<c:if test="${currentPage>1}">
				<li class="page-item"><a class="page-link" href="${pageContext.request.contextPath }/employees/getEmployeesListByPage?currentPage=${currentPage-1}">이전</a></li>
			</c:if>
			<c:if test="${currentPage<lastPage}">
				<li class="page-item"><a class="page-link" href="${pageContext.request.contextPath }/employees/getEmployeesListByPage?currentPage=${currentPage+1}">다음</a></li>
			</c:if>
		</ul>
	</div>
</div>
</body>
</html>