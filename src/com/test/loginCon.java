package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletEx
 */
@WebServlet("/loginCon")
public class loginCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String mID =  request.getParameter("mID");
		String mPW =  request.getParameter("mPW");
		out.print("mID:" + mID);
		out.print("mPW:" + mPW);
		
		Cookie[] cookies = request.getCookies();
		Cookie cookie= null;
		for(Cookie c:cookies) {
			System.out.println(c.getName()+c.getValue());
			if(c.getName().equals("mID")) {
				cookie=c;
			}
		}
		if(cookie==null) {
			System.out.println("cookie is null");
			cookie=new Cookie("mID",mID);
		}
		
		response.addCookie(cookie);
		cookie.setMaxAge(60*60);
		
		response.sendRedirect("loginOk.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
