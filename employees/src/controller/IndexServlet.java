package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DepartmentsDao;
import model.DeptEmpDao;
import model.DeptManagerDao;
import model.EmployeesDao;
import model.SalariesDao;
import model.TitlesDao;

// "/", "/index" 두 가지 url 요청 받음
@WebServlet({"/", "/index"})
public class IndexServlet extends HttpServlet {
	// index에 사용할 MODEL 선언
	private EmployeesDao employeesDao;
	private DepartmentsDao departmentsDao;
	private DeptManagerDao deptManagerDao;
	private DeptEmpDao deptEmpDao;
	private SalariesDao salariesDao;
	private TitlesDao titlesDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/index URL 요청");
		// model 객체 생성
		employeesDao = new EmployeesDao();
		departmentsDao = new DepartmentsDao();
		deptManagerDao = new DeptManagerDao();
		deptEmpDao = new DeptEmpDao();
		salariesDao = new SalariesDao();
		titlesDao = new TitlesDao();
		
		int employeesRowCount = employeesDao.selectEmployeesCount();
		int departmentsRowCount = departmentsDao.selectDepartmentsCount();
		int deptManagerRowCount = deptManagerDao.selectDeptManagerCount();
		int deptEmpRowCount = deptEmpDao.selectDeptEmpCount();
		int salariesRowCount = salariesDao.selectSalariesCount();
		int titlesRowCount = titlesDao.selectTitlesCount();
		
		// int 타입 autoboxing -> Integer : Map에는 Reference 타입이 들어가야 하기 때문에 boxing 필요
		request.setAttribute("employeesRowCount", employeesRowCount);
		request.setAttribute("departmentsRowCount", departmentsRowCount);
		request.setAttribute("deptManagerRowCount", deptManagerRowCount);
		request.setAttribute("deptEmpRowCount", deptEmpRowCount);
		request.setAttribute("salariesRowCount", salariesRowCount);
		request.setAttribute("titlesRowCount", titlesRowCount);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
		dispatcher.forward(request, response);
	}

}
