package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/newBook")
public class ModifyBook extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String driver="oracle.jdbc.driver.OracleDriver";
		String url ="jdbc:oracle:thin:@localhost:1521:xe";
		String id="system";
		String pw="1111";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			//JDBC실행순서  1.OraclDriver로딩
			Class.forName(driver);//https://pjh3749.tistory.com/250 , Class가 static클래스구나..
			//JDBC실행순서  2.Java와 Oralce 연결
			con=DriverManager.getConnection(url,id,pw);
			//JDBC실행순서  3.query작성
			String sql = "UPDATE book SET book_loc = ? WHERE book_name=?";
			//JDBC실행순서  4.query전송객체
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, "00-00");
			pstmt.setString(2, "book2");
			//JDBC실행순서  5.query전송
			int result = pstmt.executeUpdate();
			
			if(result==1) {
				out.print("UPDATE success!!");
				
			}else {
				out.print("UPDATE fail!!");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(stmt!=null)stmt.close();
				if(con!=null)con.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
				
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
