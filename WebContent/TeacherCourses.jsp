<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 <c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : 'en'}" scope="session"/>
 <fmt:setLocale value="${language}"/>
 <fmt:setBundle basename="com.java.myrotiuk.i18n.text"/>
<%@page import="com.java.myrotiuk.resources.PathManager" %>

<c:import url="./header.jsp">
	<c:param name="titele" value="Teacher Courses"/>
</c:import>

<center>
<c:import url="./additionForTeacher.jsp"/>
<hr/><br/>
</center>

<table id = "t01">
	<caption><font style="font-size: large;"><fmt:message key="label.teaching.courses"/></font></caption>
	<tr>
		<th><fmt:message key="label.number"/></th>
		<th><fmt:message key="label.name"/></th>
		<th><fmt:message key="label.places"/></th>
		<th><fmt:message key="label.registration"/></th>
	</tr>
	<c:forEach var="course" items="${teacherCourses}">
		
 		<c:choose>
			<c:when test="${course.active == 1}">
				<c:set var="activeCourse" value="Open" scope="page"/>
			</c:when>
			<c:when test="${course.active == 0}">
				<c:set var="activeCourse" value="Open" scope="page"/>
			</c:when>
		</c:choose>
		<c:set var="number" value="${number + 1}"/> 
		
		<tr>
 			<td>${number}</td> 
			<td>${course.name}</td>
			<td>${course.places}</td>
			<td>${activeCourse}</td> 
		</tr>
	</c:forEach>
</table>

<br/>
<center>
${teacherCoursesMessage}
</center>

<center>
<form action="${PathManager.COURSES}" method="post">
<input type="hidden" name="action" value="addCourse"/>
	<fieldset>
		<legend><fmt:message key="label.add.course"/>:</legend>
		
		<table>
			<tr>
				<th><fmt:message key="label.name.of.course"/>:</th>
				<th><fmt:message key="label.places"/>:</th>
			</tr>
			<tr>
				<td><input type="text" name="courseName" value="${courseName}" style="height:33px;width:320px;font-size:14pt;"/></td>
				<td><input type="text" name="coursePlaces" value="${coursePlaces}" style="height:33px;width:320px;font-size:14pt;"/></td>
			</tr>
		</table>
		
	</fieldset>
	<br/>
	<fmt:message key="button.add.course" var="buttonAddCourse"/>
	<input type="submit" value="${buttonAddCourse}" style="height:55px; width:210px"/>
</form>
<br/>
${addCourseMessage}
</center>

</body>
</html>