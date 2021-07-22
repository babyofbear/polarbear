<%@page import="co.yedam.UserVO"%>
<%@page import="java.util.List"%>
<%@page import="co.yedam.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>userList.jsp</title>
</head>
<body>
<%
	UserDAO dao = new UserDAO();
	List<UserVO> list = dao.getUsers();
	//id, name, birth
	out.println("<table border='1'>");
	out.println("<tr><td>ID</td><td>이름</td><td>생일</td></tr>");
	for(UserVO vo : list) {
		out.println("<tr><td>"+vo.getUserID() +"</td><td>"+vo.getUserName() +"</td><td><input type='date' value='"+vo.getUserBirth()+"'>"+"</td></tr>");
	}
	out.println("</table>");
%>

</body>
</html>