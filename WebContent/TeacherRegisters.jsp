<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 <c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : 'en'}" scope="session"/>
 <fmt:setLocale value="${language}"/>
 <fmt:setBundle basename="com.java.myrotiuk.i18n.text"/>

<c:import url="./header.jsp">
	<c:param name="titele" value="Teacher Registers"/>
</c:import>

<c:import url="./additionForTeacher.jsp"/>
<hr/><br/>

<table id = "t01">
<caption><font style="font-size: large;"><fmt:message key="label.register"/></font></caption>
  <tr>
    	<th><fmt:message key="label.number"/></th>
		<th><fmt:message key="label.student.fn"/></th>
		<th><fmt:message key="label.student.ln"/></th>
		<th><fmt:message key="label.student.email"/></th>
		<th><fmt:message key="label.registered"/></th>
    	<th><fmt:message key="label.graduated"/></th>
    	<th><fmt:message key="label.grade"/></th>
    	<th><fmt:message key="label.testimonial"/></th>
		<th><fmt:message key="label.course.name"/></th>
  </tr>
  
  <c:forEach var="teacherRegister" items="${teacherRegisters}">
  <c:set var="number" value="${number+1}"/>
  
  <tr>
    <td>${number}</td>
    <td>${teacherRegister.student.firstName}</td>
    <td>${teacherRegister.student.lastName}</td>
    <td>${teacherRegister.student.email}</td>
    <td>${teacherRegister.registeredAtDateTime}</td>
    <td>${teacherRegister.graduatedAtDateTime}</td>
    <td>${teacherRegister.mark}</td>
    <td>${teacherRegister.testimonial}</td>
    <td>${teacherRegister.course.name}</td>
  </tr>

  </c:forEach>
</table>

<center>
${teacherRegistersMessage}
</center>
</body>
</html>