package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletEx
 */
@WebServlet("/loginConSession")
public class loginConSession extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");//함수자체가 char를 인코딩하겠다이기 때문에 charset 넣을필요없음
		response.setContentType("text/html;charset=UTF-8");
		
		
		PrintWriter out = response.getWriter();
		String mID =  request.getParameter("mID");
		String mPW =  request.getParameter("mPW");
		out.print("mID:" + mID);
		out.print("mPW:" + mPW);
		
		HttpSession session = request.getSession();
		session.setAttribute("memberId", mID);
		
		response.sendRedirect("loginOkSession.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
