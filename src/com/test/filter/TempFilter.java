package com.test.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TempFilter implements Filter {
	
	@Override
	public void init(FilterConfig arg0) throws ServletException{
		System.out.println("----filter----");
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		System.out.println("---filter dofilter()---");
		
		arg0.setCharacterEncoding("UTF-8");
		
		arg2.doFilter(arg0, arg1);
		
		
	}
	
	@Override
	public void destroy(){
		System.out.println("----filter destroy----");
	}
	
	
	

}
