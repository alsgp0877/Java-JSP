package com.test.dtodao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//dto 실제 DB에서 사용하고 있는 데이터를 자바가 쓸수 있게 해줌
//dao 자바에서 사용함 
@WebServlet("/bs")
public class BookServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		BookDao bookDao = new BookDao();
		ArrayList<BookDto> list = bookDao.select();
		for(int i=0;i<list.size();i++) {
			BookDto dto = list.get(i);
			int bookId = dto.getBookId();
			String bookName = dto.getBookName();
			String bookLoc = dto.getBookLoc();
			
			out.print("bookId :" + bookId + ",");
			out.print("bookName :" + bookName  + ",");
			out.print("bookLoc : " + bookLoc + "<br>");
			
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
