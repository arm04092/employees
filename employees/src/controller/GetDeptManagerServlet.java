package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DeptManagerDao;
import vo.DeptManager;

@WebServlet("/departments/getDeptManagerList")
public class GetDeptManagerServlet extends HttpServlet {
	// Controller 에 사용할 모델
	private DeptManagerDao deptManagerDao = new DeptManagerDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<DeptManager> list = deptManagerDao.getDeptManagerList();
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/views/departments/deptManagerList.jsp").forward(request, response);
	}

}
