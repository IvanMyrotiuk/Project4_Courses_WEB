<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 <c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : 'en'}" scope="session"/>
 <fmt:setLocale value="${language}"/>
 <fmt:setBundle basename="com.java.myrotiuk.i18n.text"/>
<%@page import="com.java.myrotiuk.resources.PathManager"%>

<c:import url="./header.jsp">
	<c:param name="titele" value="Enrol"/>
</c:import>

<center>
<c:import url="./additionForStudent.jsp"/>
</center>
<hr/><br/>

<form action="${PathManager.COURSES}" method="post">
<input type="hidden" name="action" value="enrol"/>
	<table id="t01">
	<caption><font style="font-size: large;"><fmt:message key="label.catalog.of.courses.to.enrol"/></font></caption>
		<tr>
			<th><fmt:message key="label.enrol"/></th>
			<th><fmt:message key="label.name"/></th>
			<th><fmt:message key="label.places"/></th>
			<th><fmt:message key="label.teacher.fn"/></th>
			<th><fmt:message key="label.teacher.ln"/></th>
			<th><fmt:message key="label.email"/></th>
			<th><fmt:message key="label.experience"/></th>
		</tr>
	
		<c:forEach var="course" items="${coursesToEnrol}">
			
			<tr>
				<td><input id="myCheckBox" type="checkbox" name="courseToEnrol" value="${course.id}" /></td>
				<td>${course.name}</td>
				<td>${course.places}</td>
				<td>${course.teacher.firstName}</td>
				<td>${course.teacher.lastName}</td>
				<td>${course.teacher.email}</td>
				<td>${course.teacher.experienceYears}</td>
			</tr>
		
		</c:forEach>
	</table>
	
	<br/>
	<c:if test="${not empty coursesToEnrol}">
		<center>
		<fmt:message key="button.enrol" var="buttonEnrol"/>
		<input type="submit" value="${buttonEnrol}" style="height:55px; width:210px"/>
		</center>
	</c:if>
</form>

<center>
${enrolMessage}
</center>
</body>
</html>