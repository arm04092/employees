package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmployeesDao;
import vo.Employees;

@WebServlet("/employees/getEmployeesList")
public class GetEmployeesListServlet extends HttpServlet {
// 사원 목록 출력할 페이지 MODEL 추가
	private EmployeesDao employeesDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GetEmployeesListServlet.doGet() param limit: " + request.getParameter("limit"));
		// 목록 출력할 행의 개수를 저장하는 변수 생성
		int limit = 10;
		if(request.getParameter("limit") != null) {
			limit = Integer.parseInt(request.getParameter("limit"));
		}
		// model 객체 생성
		employeesDao = new EmployeesDao();
		// 사원 목록 리스트 리턴 값 저장
		List<Employees> list = employeesDao.selectEmployeesListByLimit(limit);
		// view로 넘길  request에 리스트 저장
		request.setAttribute("list", list);
		// view로 forward
		request.getRequestDispatcher("/WEB-INF/views/employees/employeesList.jsp").forward(request, response);
	}

}
