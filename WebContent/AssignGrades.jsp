<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 <c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : 'en'}" scope="session"/>
 <fmt:setLocale value="${language}"/>
 <fmt:setBundle basename="com.java.myrotiuk.i18n.text"/>
<%@page import="com.java.myrotiuk.resources.PathManager" %>

<c:import url="./header.jsp">
	<c:param name="titele" value="Assign Grades"/>
</c:import>

<c:import url="./additionForTeacher.jsp"/>
<hr/><br/>

<c:if test="${not empty teacherCourses}">
<form action="${PathManager.COURSES}" method="post">
<input type="hidden" name="action" value="doAssignGradesForParticularCourse"/>
	<select name="courseToAssignGrades" onchange="submit()" style="width: 290px; height: 50px; font-size:12pt;">
		<option><fmt:message key="label.choose.course.assign.grades"/></option> 
		<c:forEach var="teacherCourse" items="${teacherCourses}">
			<option value="${teacherCourse.id}">${teacherCourse.name}</option>
		</c:forEach>
	</select>
</form>
</c:if>

<form action="${PathManager.COURSES}" method="post">
<input type="hidden" name="action" value="assignGradesForParticularCourse">
	<table id = "t01">
		<caption><font style="font-size: x-large;">${nameOfCourse}</font></caption>
		
		<c:if test="${not empty registers}">
		<caption><font style="font-size: large;"><fmt:message key="label.assign.grades"/></font></caption>
		<tr>
			<th></th>
			<th><fmt:message key="label.student.fn"/></th>
			<th><fmt:message key="label.student.ln"/></th>
			<th><fmt:message key="label.student.email"/></th>
			<th><fmt:message key="label.registered"/></th>
    		<th><fmt:message key="label.grade"/></th>
    		<th><fmt:message key="label.testimonial"/></th>
		</tr>
		</c:if>

<!-- 	<c:if test="${not empty registers}">
	<jsp:useBean id="itemsRegisters" class="java.util.HashMap" scope="request"/>
	</c:if> -->
	
	<c:forEach var="register" items="${registers}">
	
		<c:set var = "number" value="${number + 1}" scope = "request"/>
		<!--<c:set target="${itemsRegisters}" property="${number}" value="${register}"/>
		 <c:set var="registerItemNumber" value="registerItem${number}"/>
		<c:set var = "registerItemNumber" value="${register}"  scope = "request"/> -->
		
		<input type="hidden" name="registerId${number}" value="${register.id}" />
		<tr>
			<td>${number}</td>
			<td>${register.student.firstName}</td>
			<td>${register.student.lastName}</td>
			<td>${register.student.email}</td>
			<td>${register.registeredAtDateTime}</td>
			<td><input type="text" name = "mark${number}" value="${register.mark}"/></td>
			<td><textarea name="testimonial${number}" cols="40" rows="3" ></textarea></td>
		</tr>
		
	</c:forEach>
	
	</table>
	
	<input type="hidden" name="countRegisters"  value="${number}"/>
	<!-- for doAssignGradesForParticularCourseCommand for displaying students/registers that was failed to assign mark/grade we will execute again that command -->
	<input type="hidden" name="courseToAssignGrades"  value="${courseToAssignGrades}"/>
	
	<c:if test="${not empty registers}">
	<br/>
		<center>
			<fmt:message key="button.assign.grades" var="buttonAssignGrades"/>
			<input type="submit" value = "${buttonAssignGrades}" style="height:55px; width:210px"/>
		</center>
	</c:if>
</form>


<center>
	${assignGradesMessage}
</center>

</body>
</html>