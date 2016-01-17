<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 <c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : 'en'}" scope="session"/>
 <fmt:setLocale value="${language}"/>
 <fmt:setBundle basename="com.java.myrotiuk.i18n.text"/>

<c:import url="header.jsp">
	<c:param name="titele" value="Welcome teacher"/>
</c:import>

<center>
<br/><br/><br/><br/><br/><br/>
<fmt:message key="text.welcome"/> ${teacher.firstName} ${teacher.lastName} <fmt:message key="text.welcome.teacher"/> 
<br/><br/><br/>

<c:import url="./additionForTeacher.jsp"/>

</center>

</body>
</html>