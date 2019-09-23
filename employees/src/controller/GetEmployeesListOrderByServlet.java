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

@WebServlet("/employees/getEmployeesListOrderBy")
public class GetEmployeesListOrderByServlet extends HttpServlet {
	// Controller에서 사용할 Model
	private EmployeesDao employeesDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 단위 테스트
		System.out.println("/employees/getEmployeesListOrderBy URL 요청");
		String order = request.getParameter("order");
		System.out.println("GetEmployeesListOrderByServlet doGet param request: " + order);
		// Model 객체 생성
		employeesDao = new EmployeesDao();
		// 정렬한 employees list 메소드로 받아서 저장
		List<Employees> list = employeesDao.selectEmployeesListOrderBy(order);
		
		// View에서 출력할 list를 request에 추가
		request.setAttribute("list", list);
		// View에서 출력할 order request에 추가
		if(order.equals("asc")) {
			request.setAttribute("order", "오름차순");	
		} else if(order.equals("desc")) {
			request.setAttribute("order", "내림차순");
		}
		// View로 forward
		request.getRequestDispatcher("/WEB-INF/views/employees/employeesListOrderBy.jsp").forward(request, response);
		
	}

}
