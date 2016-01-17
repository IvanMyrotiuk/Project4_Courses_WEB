<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="com.java.myrotiuk.resources.PathManager"%> 

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var = "language" value="${not empty param.language ? param.language : not empty language ? language : 'en'}" scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="com.java.myrotiuk.i18n.text"/>

<c:import url="./I18nForIndexLoginSingup.jsp">
	<c:param name="titele" value="Login"/>
</c:import>

<center>
	<form action='${PathManager.COURSES}'  method="post">
		<input type="hidden" name="action" value="login"/>
		<fieldset>
			<legend><fmt:message key="label.login"/>:</legend>
			<fmt:message key="label.user.email.address"/>:<br/>
			<input type="text" name="userEmail" value="${userEmail}"/><br/>
			<fmt:message key="label.user.password"/>:<br/>
			<input type="password" name="userPassword" value="${userPassword}"><br/>
		</fieldset>
		<br/>
		<fmt:message key="button.login" var="buttonLogin"/>
		<input type="submit" value="${buttonLogin}" style="height:50px; width:200px;"/>
	</form>
	<br/><br/><br/>
	${loginMessage}
</center>

</body>
</html>