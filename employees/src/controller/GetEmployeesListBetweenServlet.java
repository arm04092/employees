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

@WebServlet("/employees/getEmployeesListBetween")
public class GetEmployeesListBetweenServlet extends HttpServlet {
	private EmployeesDao employeesDao;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 단위 테스트
		System.out.println("/employees/getEmployeesListBetween URL 요청");
		System.out.println("GetEmployeesListBetweenServlet doPost() param begin: " + request.getParameter("begin"));
		System.out.println("GetEmployeesListBetweenServlet doPost() param end: " +  request.getParameter("end"));
		// parameter 저장
		int begin = Integer.parseInt(request.getParameter("begin"));
		int end = Integer.parseInt(request.getParameter("end"));
		// model 객체 생성
		employeesDao = new EmployeesDao();
		
		// View로 넘길 데이터 저장
		List<Employees> list = employeesDao.selectEmployeesListBetween(begin, end);
		// 인자로 넘길 데이터 request에 저장하고 View로 forward
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/views/employees/employeesListBetween.jsp").forward(request, response);
	}

}
