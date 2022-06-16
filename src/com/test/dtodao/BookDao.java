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

//DAO : data access object
//자바에서 데이터베이스에 관한 기능만 따로 모듈화한것 때낸것
public class BookDao{
	
	//------
	//spring에서는 xml 파일에 디비정보를 설정해두고 bean에 등록해서 
	//가져와서 사용하는 방식을 쓰는것 같다(?)
	String driver="oracle.jdbc.driver.OracleDriver";
	String url ="jdbc:oracle:thin:@localhost:1521:xe";
	String id="system";
	String pw="1111";
	
	public BookDao() {
		try {
			Class.forName(driver);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	//------
	
	//------
	//그리고 여기도 spring에서? 인가 아무튼 이 문장이 짧고 간결하게 사용될수있게 하는
	//라이브러리가 있는것 같다. 
	//여기서도 객체 담는 부분이랑 쿼리를 또 나눠서 xml 파일로 때어넨다.
	public ArrayList<BookDto> select(){
		ArrayList<BookDto> list = new ArrayList<BookDto>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		
		try {
			con=DriverManager.getConnection(url,id,pw);
			String sql = "SELECT * FROM book";
			pstmt=con.prepareStatement(sql);
			//JDBC실행순서  5.query전송
			res= pstmt.executeQuery(sql);
			
			while(res.next()) {
				int bookId = res.getInt("book_id");
				String bookName = res.getString("book_name");
				String bookLoc = res.getString("book_loc");

				BookDto bookDto = new BookDto(bookId,bookName,bookLoc);
				list.add(bookDto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(res!=null)res.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}

		return list;
	}
	
}


