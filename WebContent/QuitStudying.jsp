<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 <c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : 'en'}" scope="session"/>
 <fmt:setLocale value="${language}"/>
 <fmt:setBundle basename="com.java.myrotiuk.i18n.text"/>
<%@page import="com.java.myrotiuk.resources.PathManager"%>

<c:import url="./header.jsp">
	<c:param name="titele" value="Quit studying"/>
</c:import>

<c:import url="./additionForStudent.jsp"/>
<hr/><br/>

<form action="${PathManager.COURSES}" method="post">
	<input type="hidden" name="action" value="quitStudying"/>
	<table id = "t01">
		<caption><font style="font-size: large;"><fmt:message key="label.courses.to.quit"/></font></caption>
		<tr>
			<th><fmt:message key="label.choose"/></th>
			<th><fmt:message key="label.course.name"/></th>
			<th><fmt:message key="label.teacher.fn"/></th>
			<th><fmt:message key="label.teacher.ln"/></th>
			<th><fmt:message key="label.teacher.email"/></th>
			<th><fmt:message key="label.registered"/></th>
		</tr>
		
		<c:forEach var="register" items="${registers}">
		
			<tr>
				<td><input id = "myCheckBox" type="checkbox" name = "courseToQuit" value="${register.course.id}"/></td>
				<td>${register.course.name}</td>
				<td>${register.course.teacher.firstName}</td>
				<td>${register.course.teacher.lastName}</td>
				<td>${register.course.teacher.email}</td>
				<td>${register.registeredAtDateTime}</td>
			</tr>
		
		</c:forEach>
		
	</table>
	<c:if test="${not empty registers}">
	<br/>
		<center>
		<fmt:message key="button.quit.studying"  var="buttonQuitStudying"/>
		<input type="submit" value="${buttonQuitStudying}" style="height:55px; width:210px"/>
		</center>
	</c:if>
</form>

<center>
<br/>
${quitStudyingMessage}
</center>

</body>
</html>