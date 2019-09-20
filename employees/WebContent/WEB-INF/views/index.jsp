<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
</head>
<body>
	<h1>Index</h1>
	<!-- WEB APP 네비게이션 -->
	<ul>
		<li><a href="${pageContext.request.contextPath }/departments/getDepartmentsList">부서 목록</a></li>	
		<li><a href="${pageContext.request.contextPath }/employees/getEmployeesList?limit=10">사원 목록</a></li>
	</ul>
	employees table total row count : <%=request.getAttribute("employeesRowCount") %>
</body>
</html>