<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	</head>
	<body>
		<%!
			String adminId;
			String adminPw;
			
			String imgDir;
			String testServerIp;
		%>
		<%
			adminId=config.getInitParameter("adminId");
			adminPw=config.getInitParameter("adminPw");
		%>
		<p>adminId : <%=adminId %></p>
		<p>adminPw : <%=adminPw %></p>
		
		<%
			imgDir=application.getInitParameter("imgDir");
			testServerIp=application.getInitParameter("testServerIp");
		%>
		<p>imgDir : <%=imgDir %></p>
		<p>testServerIp : <%=testServerIp %></p>
	
	</body>
</html>