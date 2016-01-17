<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 <c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : 'en'}" scope="session"/>
 <fmt:setLocale value="${language}"/>
 <fmt:setBundle basename="com.java.myrotiuk.i18n.text"/>

<c:import url="./header.jsp">
	<c:param name="titele" value="Student courses"/>
</c:import>

<center>
	<c:import url="./additionForStudent.jsp"/>
</center>
<hr><br>

<table id = "t01">
<caption><font style="font-size: large;"><fmt:message key="label.yours.courses"/></font></caption>
	<tr>
		<th><fmt:message key="label.number"/></th>
		<th><fmt:message key="label.course.name"/></th>
		<th><fmt:message key="label.teacher.fn"/></th>
		<th><fmt:message key="label.teacher.ln"/></th>
		<th><fmt:message key="label.email"/></th>
		<th><fmt:message key="label.registered"/></th>
	</tr>
	
	<c:forEach var="register" items="${registers}">
		<c:set var="number" value="${number+1}"></c:set>
		<tr>
			<td>${number}</td>
			<td>${register.course.name}</td>
			<td>${register.course.teacher.firstName}</td>
			<td>${register.course.teacher.lastName}</td>
			<td>${register.course.teacher.email}</td>
			<td>${register.registeredAtDateTime}</td>
		</tr>
	</c:forEach>
</table>


<center>
${studentCoursesMessage}
</center>
</body>
</html>