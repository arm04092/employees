package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/logout URL 요청");
		HttpSession session = request.getSession();
		// 세션 비우기
		session.invalidate();
		// 로그인 페이지 재요청
		response.sendRedirect(request.getContextPath()+"/login");
	}
}
