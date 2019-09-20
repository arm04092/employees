package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DepartmentsDao;
import vo.Departments;
// Controller
@WebServlet("/departments/getDepartmentsList")
public class GetDepartmentsListServlet extends HttpServlet {
	// Controller에서 사용할 model 추가
	private DepartmentsDao departmentsDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// model 객체 생성
		departmentsDao = new DepartmentsDao();
		// forward할때 인자로 전달할 list 저장 
		List<Departments> list = departmentsDao.selectDepartmentsList();
		// request에 list 저장
		request.setAttribute("list", list);
		// view로 forward
		request.getRequestDispatcher("/WEB-INF/views/departments/departmentsList.jsp").forward(request, response);
		
	}

}
