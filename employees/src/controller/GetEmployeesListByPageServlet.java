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

@WebServlet("/employees/getEmployeesListByPage")
public class GetEmployeesListByPageServlet extends HttpServlet {
	private EmployeesDao employeesDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/employees/getEmployeesListByPage URL 요청");
		// model 객체 생성
		employeesDao = new EmployeesDao();
		// 페이징 코드
		int currentPage = 1;
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		// 출력할 행 개수
		int rowPerPage = 10;
		// 마지막 페이지
		int lastPage = 0;
		lastPage = employeesDao.selectLastPage(rowPerPage);
		System.out.println("GetEmployeesListByPage.doGet() rowPerPage: " + rowPerPage);
		System.out.println("GetEmployeesListByPage.doGet() lastPage: " + lastPage);
		// 전달할 리스트 생성하고 값 저장
		List<Employees> list = employeesDao.selectEmployeesListByPage(currentPage, rowPerPage);
		// View로 전달할 데이터들 request에 저장
		request.setAttribute("list", list);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("lastPage", lastPage);
		//View로 forward
		request.getRequestDispatcher("/WEB-INF/views/employees/employeesListByPage.jsp").forward(request, response);
	}

}
