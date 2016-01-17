<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.java.myrotiuk.resources.PathManager" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome student</title>
</head>
<body>

<%@ include file="./header.jsp" %>

<center>
<br/><br/><br/><br/><br/><br/>
<fmt:message key="text.welcome"/> ${student.firstName} ${student.lastName} <fmt:message key="text.welcome.student"/>
<br/><br/><br/>

<jsp:include page="./additionForStudent.jsp"/>


</center>
</body>
</html>