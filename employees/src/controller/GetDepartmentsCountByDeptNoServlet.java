package controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DeptEmpDao;

@WebServlet("/departments/getDepartmentsCountByDeptNo")
public class GetDepartmentsCountByDeptNoServlet extends HttpServlet {
	private DeptEmpDao deptEmpDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// model 객체 생성
		deptEmpDao = new DeptEmpDao();
		// 출력할 데이터 저장
		List<Map<String, Object>> list = deptEmpDao.selectDepartmentsCountByDeptNo();
		// request에 데이터 저장, View로 forward
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/views/departments/departmentsCountByDeptNo.jsp").forward(request, response);
	}

}
