package controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SalariesDao;

@WebServlet("/salaries/getSalariesStatistics")
public class GetSalariesStatistics extends HttpServlet {
	private SalariesDao salariesDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// model 객체 생성
		salariesDao = new SalariesDao();
		// 출력할 데이터 map에 저장하여 request에 추가
		Map<String, Long> map = salariesDao.selectSalariesStatistics();
		request.setAttribute("map", map);
		// View로 forward
		request.getRequestDispatcher("/WEB-INF/views/salaries/salariesStatistics.jsp").forward(request, response);
		
	}

}
