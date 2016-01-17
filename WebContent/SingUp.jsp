<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="com.java.myrotiuk.resources.PathManager"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    

<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : 'en'}" scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="com.java.myrotiuk.i18n.text"/>

<c:import url="./I18nForIndexLoginSingup.jsp">
	<c:param name="titele" value="SingUp"/>
</c:import>

<center>
	<form action='${PathManager.COURSES}' method="post">
		<input type="hidden" name="action" value="singup"/>
		<fieldset>
			<legend><fmt:message key="label.singup"/>:</legend>
			<fmt:message key="label.first.name"/>:<br/>
			<input type="text" name="userFirstName" value="${userFirstName}"><br/>
			<fmt:message key="label.last.name"/>:<br/>
			<input type="text" name="userLastName" value="${userLastName}"><br/>
			<fmt:message key="label.address"/>:<br/>
			<input type="text" name="userAddress" value="${userAddress}"><br/>
			<fmt:message key="label.phone.number"/>:<br/>
			<input type="text" name="userPhone" value="${userPhone}"><br/>
			<fmt:message key="label.user.email.address"/>:<br/>
			<input type="text" name="userEmail" value="${userEmail}"/><br/>
			<fmt:message key="label.user.password"/>:<br/>
			<input type="password" name="userPassword" value="${userPassword}"><br/>
			<fmt:message key="label.user.check.password"/>:<br/>
			<input type="password" name="userCheckPassword" value="${userCheckPassword}"><br/>
		</fieldset><br/>
		<fmt:message key="button.singup" var="buttonSingUp"/>
		<input type="submit" value="${buttonSingUp}" style="height:50px; width:200px;"/>
	</form>
	<br/><br/><br/>
	${userSingUpMessage}
</center>

</body>
</html>