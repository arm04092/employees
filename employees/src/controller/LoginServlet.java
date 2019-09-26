package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.EmployeesDao;
import vo.Employees;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private EmployeesDao employeesDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// forward login.jsp
		System.out.println("LoginServlet.doGet(): /login URL 요청");
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LoginServlet doPost(): /login URL 요청");
		// 로그인 페이지에서 넘어옴
		// request 인자 가져와서 저장 후, 단위테스트
		int empNo = Integer.parseInt(request.getParameter("empNo"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		System.out.println("LoginServlet.doPost() param empNo" + empNo);
		System.out.println("LoginServlet.doPost() param firstName" + firstName);
		System.out.println("LoginServlet.doPost() param lastName" + lastName);
		// 인자로 넘길 Employees 타입 객체 생성
		Employees employees = new Employees();
		employees.setEmpNo(empNo);
		employees.setFirstName(firstName);
		employees.setLastName(lastName);
		
		// model 객체 생성
		employeesDao = new EmployeesDao();
		// session에 로그인 정보 저장
		int sessionEmpNo = employeesDao.login(employees);
		HttpSession session = request.getSession();
		if(sessionEmpNo != 0) {
			session.setAttribute("sessionEmpNo", sessionEmpNo);
		}
		// 로그인 정보 저장 후 인덱스 페이지 재요청
		response.sendRedirect(request.getContextPath()+"/");
	}

}
