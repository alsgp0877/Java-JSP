<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage ="true" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	</head>
	<body>
		<%
			Cookie[] cookies = request.getCookies();
			for(Cookie c : cookies){
				out.print("name:" +c.getName()+"<br>");
				out.print("value:"+c.getValue()+"<br>");
<<<<<<< HEAD
				out.print("===========================");
			}
		%>

=======
				out.print("----------------------<br>");
			}
		%>


		
	
>>>>>>> 4c557254815183aec98b3324753373f6b82ed1a4
	</body>
</html>