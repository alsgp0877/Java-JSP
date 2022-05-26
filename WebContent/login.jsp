<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Cookie[] cookies = request.getCookies();
		System.out.println("cookies:"+cookies);
		
		//서블릿으로 부터 받은 쿠키 데이터가 있으면 로그인 그냥 해도됨
		//쿠키이름이라는것은 결국 서버에서 주는 키값같은건가?..
		//근데 왜 loginOk로 준 데이터가 login에서도 쓰이는지..
		if(cookies != null){
			for(Cookie c : cookies){
				if(c.getName().equals("memberId")){
					response.sendRedirect("loginOk.jsp");
				}
			}
		}
	%>
	<form action="loginCon" method="post">
		ID:<input type="text" name="mID"><br>
		PW:<input type="text" name="mPW"><br>
		<input type="submit" value="login">
	</form>
</body>
</html>