<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 <c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : 'en'}" scope="session"/>
 <fmt:setLocale value="${language}"/>
 <fmt:setBundle basename="com.java.myrotiuk.i18n.text"/>

<c:import url="./header.jsp">
	<c:param name="titele" value="Graduated Courses"/>
</c:import>

<c:import url="./additionForStudent.jsp"/>
<hr/><br/>

<table id = "t01">
  	<tr>
    	<th><fmt:message key="label.number"/></th>
		<th><fmt:message key="label.teacher.fn"/></th>
		<th><fmt:message key="label.teacher.ln"/></th>
		<th><fmt:message key="label.teacher.email"/></th>
		<th><fmt:message key="label.registered"/></th>
    	<th><fmt:message key="label.graduated"/></th>
    	<th><fmt:message key="label.grade"/></th>
    	<th><fmt:message key="label.testimonial"/></th>
		<th><fmt:message key="label.course.name"/></th>
  	</tr>
  
  <c:forEach var="graduatedCourse" items="${graduatedCourses}">
  <c:set var="number" value="${number+1}"/>
  
  <tr>
    <td>${number}</td>
    <td>${graduatedCourse.course.teacher.firstName}</td>
    <td>${graduatedCourse.course.teacher.lastName}</td>
    <td>${graduatedCourse.course.teacher.email}</td>
    <td>${graduatedCourse.registeredAtDateTime}</td>
    <td>${graduatedCourse.graduatedAtDateTime}</td>
    <td>${graduatedCourse.mark}</td>
    <td>${graduatedCourse.testimonial}</td>
    <td>${graduatedCourse.course.name}</td>
  </tr>

  </c:forEach>
</table>

<center>
${graduatedCoursesMessage}
</center>

</body>
</html>