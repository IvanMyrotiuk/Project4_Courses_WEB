<%@page import="com.java.myrotiuk.resources.PathManager" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 <c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : 'en'}" scope="session"/>
 <fmt:setLocale value="${language}"/>
 <fmt:setBundle basename="com.java.myrotiuk.i18n.text"/>
 
<center>
<table style="width:70%">
	<tr>
		<td align="right">
			<form action="${PathManager.COURSES}" method="post">
				<input type="hidden" name="action" value="catalogOfCourses"/>
				<fmt:message key="button.catalog.of.courses" var="buttonCatalogOfCourses"/>
				<input type="submit" value="${buttonCatalogOfCourses}" style="height:55px; width:210px" />
			</form>
		</td>
		<td align="right">
			<form action="${PathManager.COURSES}" method="post">
				<input type="hidden" name="action" value="teacherCourses"/>
				<fmt:message key="button.teaching" var="buttonTeaching"/>
				<input type="submit" value="${buttonTeaching}" style="height:55px; width:210px" />
			</form>
		</td>
		<td align="right">
			<form action="${PathManager.COURSES}" method="post">
				<input type="hidden" name="action" value="doAssignGrades"/>
				<fmt:message key="button.assign.grades" var="buttonAssignGrades"/>
				<input type="submit" value="${buttonAssignGrades}" style="height:55px; width:210px" />
			</form>
		</td>
	</tr>
	<tr>
		<td colspan="2%" align="right">
			<form action="${PathManager.COURSES}" method="post">
				<input type="hidden" name="action" value="teacherRegisters"/>
				<fmt:message key="button.register" var="buttonRegister"/>
				<input type="submit" value="${buttonRegister}" style="height:55px; width:210px"/>
			</form>
		</td>
		<td></td><td></td>
	</tr>
</table>
</center>