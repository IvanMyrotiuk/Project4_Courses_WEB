<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 <c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : 'en'}" scope="session"/>
 <fmt:setLocale value="${language}"/>
 <fmt:setBundle basename="com.java.myrotiuk.i18n.text"/>

<c:import url="./header.jsp">
	<c:param name="titele" value="Catalog of courses"/>
</c:import>
<center>
<c:set var="additionStudentOrTeacher" value='${not empty student ? "./additionForStudent.jsp" : "./additionForTeacher.jsp" }'></c:set>
<c:import url="${additionStudentOrTeacher}"/>
<hr/><br/>
</center>

<table id ="t01">
<caption ><font style="font-size: large;"><fmt:message key="label.catalog.of.courses"/></font></caption>
	<tr><th colspan="7" align="center"><fmt:message key="label.catalog.of.courses"/></th></tr>
	<tr>
		<th><fmt:message key="label.name"/></th>
		<th><fmt:message key="label.places"/></th>
		<th><fmt:message key="label.teacher.fn"/></th>
		<th><fmt:message key="label.teacher.ln"/></th>
		<th><fmt:message key="label.email"/></th>
		<th><fmt:message key="label.experience"/></th>
		<th><fmt:message key="label.registration"/></th>
	</tr>
		
		<c:forEach var="course" items="${courses}">
		
			<c:choose>
				<c:when test="${course.active == 0}">
					<c:set var="activeCourse" value="Close" scope="page"/>
				</c:when>
				<c:when test="${course.active == 1}">
					<c:set var="activeCourse" value="Open" scope="page"/>
				</c:when>
			</c:choose>

			<tr>
				<td>${course.name}</td>
				<td>${course.places}</td>
				<td>${course.teacher.firstName}</td>
				<td>${course.teacher.lastName}</td>
				<td>${course.teacher.email}</td>
				<td>${course.teacher.experienceYears}</td>
				<td>${activeCourse}</td>
			</tr>
		</c:forEach>
</table>


<br/><br/><br/>

<center>
${catalogCoursesMessage}

</center>
</body>
</html>