package com.test.dtodao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

//DAO : data access object
//자바에서 데이터베이스에 관한 기능만 따로 모듈화한것 때낸것


public class BookDao{
	
	DataSource dataSource;
	
	//---spring에서는 DBMS 프로그램과 연결할때 필요한 정보,연결점을 XML 파일에 따로 관리하고 
	/*String driver="oracle.jdbc.driver.OracleDriver";
	String url ="jdbc:oracle:thin:@localhost:1521:xe";
	String id="system";
	String pw="1111";*/
		
	public BookDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/oracle11g");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	//---
	
	public ArrayList<BookDto> select(){
		ArrayList<BookDto> list = new ArrayList<BookDto>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		
		try {
			/*con=DriverManager.getConnection(url,id,pw);*/
			con=dataSource.getConnection();
			//쿼리문도 쿼리만 작성하는 XML 파일에 따로 관리한다. 
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
//이제 DBMS 정보 관련 XML과 쿼리만 있는 XML의 연결점 함수들이 있고 (IBatis에서 지원하나 selectList 같은거) 사용해서 쿼리를 실행하고 데이터를 받아온다. 


