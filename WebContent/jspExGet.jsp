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
			String connectedIp;
			String connectedUser;
			
			String imgDir;
			String testServerIp;
		%>
		<%
		connectedIp=(String)application.getAttribute("connectedIp");
		connectedUser=(String)application.getAttribute("connectedUser");
		%>
		<p>connectedIp : <%=connectedIp %></p>
		<p>connectedUser : <%=connectedUser %></p>
		
	
	</body>
</html>