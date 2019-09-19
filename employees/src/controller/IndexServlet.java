package controller;

import java.io.IOException;
import model.EmployeesDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private EmployeesDao employeesDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/index URL 요청");
		// model 호출
		this.employeesDao = new EmployeesDao();
		int employeesRowCount = employeesDao.selectEmployeesCount();
		// int 타입 autoboxing -> Integer : Map에는 Reference 타입이 들어가야 하기 때문
		request.setAttribute("employeesRowCount", employeesRowCount);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
		dispatcher.forward(request, response);
	}

}
