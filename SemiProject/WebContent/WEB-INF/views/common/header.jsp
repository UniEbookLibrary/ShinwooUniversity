<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	import="member.vo.Member,java.util.ArrayList" %>
<% Member loginUser=(Member)session.getAttribute("loginUser"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<% if(loginUser == null){ %>
	<%@ include file="../common/headerVisitor.jsp" %>
	<%} else if(loginUser.getMemberType().equals("MASTER")){ %>
	<%@ include file="../common/headerAdmin.jsp" %>
	<%} else if(loginUser.getMemberType().equals("user")){ %>
	<%@ include file="../common/headerUser.jsp" %>
	<%} %>
</body>
</html>