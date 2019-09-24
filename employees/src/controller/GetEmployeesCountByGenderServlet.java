package controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmployeesDao;

@WebServlet("/employees/getEmployeesCountByGender")
public class GetEmployeesCountByGenderServlet extends HttpServlet {
	private EmployeesDao employeesDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/employees/getEmployeesCountByGender URL 요청");
		// model 객체 생성
		employeesDao = new EmployeesDao();
		// 출력할 데이터 저장
		List<Map<String, Object>> list = employeesDao.selectEmployeesCountGroupByGender();
		// request에 데이터 저장하고 View로 forward
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/views/employees/employeesCountByGender.jsp").forward(request, response);
	}

}
