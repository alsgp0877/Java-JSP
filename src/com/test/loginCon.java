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
			//memberId는 다른뜻 없고 그냥 memberId라는 이름에 해당하는 쿠키의 값이 있는지
			//확인하고 없으면 안가져옴 쿠기는 저마다 다른 이름을 가지고 있을 수 있음 
			if(c.getName().equals("memberId")) {
				cookie=c;
			}
		}
		if(cookie==null) {
			//만들고싶은 쿠키 이름을 짓고 사용자가 보내준 아이디값을 쿠기 값으로 정해서  데이터를 넘겨주는건가?..
			//이건 우리가 너희정보로 만든 쿠기데이터야?..
			System.out.println("cookie is null");
			cookie=new Cookie("memberId",mID);
		}
		
		//우리가 만든 쿠키데이터를 사용자에게 보내주고
		response.addCookie(cookie);
		cookie.setMaxAge(60*60);
		
		response.sendRedirect("loginOk.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
