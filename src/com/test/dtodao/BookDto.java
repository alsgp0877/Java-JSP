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

//회사에서는 vo 형태로 많이 쓰고 있다.
//dto : data transfer object
//DBMS의 종류에 따라 타입이 다를수 있다. oracle의 number 타입이 java의 int와 다른것 처럼
//DBMS에 있는 데이터를 자바로 만들어주는 중간 매개체
//여기는 말그대로 DBMS에 있는 정보를 받아오는 곳이기 때문에 어떠한 형태로 JSON 형태로 JAVA 객체형태로든 받아올수있다.
//DBMS는 어떻게 VO를 인식하고 연결점 처럼 사용할수 있을까?
public class BookDto{
	
	int bookId;
	String bookName;
	String bookLoc;
	public BookDto(int bookId, String bookName, String bookLoc) {
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookLoc = bookLoc;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookLoc() {
		return bookLoc;
	}
	public void setBookLoc(String bookLoc) {
		this.bookLoc = bookLoc;
	}
	
	
	
}


