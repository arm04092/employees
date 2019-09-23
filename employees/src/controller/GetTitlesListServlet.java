package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TitlesDao;

@WebServlet("/titles/getTitlesList")
public class GetTitlesListServlet extends HttpServlet {
	// Controller에서 사용할 Model 선언
	private TitlesDao titlesDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/titles/getTitlesList URL 요청");
		// Model 객체 생성
		titlesDao = new TitlesDao();
		// View에서 출력할 list 저장
		List<String> list = titlesDao.selectTitlesList();
		// forward할 떄 넘길 request에 list 추가
		request.setAttribute("list", list);
		// View로 forward
		request.getRequestDispatcher("/WEB-INF/views/titles/titlesList.jsp").forward(request, response);
	}

}
