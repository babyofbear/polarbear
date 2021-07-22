<%@page import="co.yedam.UserDAO"%>
<%@page import="co.yedam.UserVO"%>
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

	request.setCharacterEncoding("utf-8");//한글입력 가능처리.	

	String uid = request.getParameter("user_id");
	String upw = request.getParameter("user_pw");
	String unm = request.getParameter("user_nm");
	String ugn = request.getParameter("user_gen");
	String uhb = request.getParameter("user_hobby");
	String ubd = request.getParameter("user_birth");


	UserVO vo = new UserVO();
	vo.setUserID(uid);
	vo.setUserPw(upw);
	vo.setUserName(unm);
	vo.setUserGen(ugn);
	vo.setUserHobby(uhb);
	vo.setUserBirth(ubd);
	
	UserDAO dao = new UserDAO();
	dao.insertUser(vo);
	
	out.print("<script>alert('입력성공')</script>");
	
%>

</body>
</html>