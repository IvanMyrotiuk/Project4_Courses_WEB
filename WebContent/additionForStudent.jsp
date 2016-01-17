<%@page import="com.java.myrotiuk.resources.PathManager" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : 'en'}" scope="session"/>
 <fmt:setLocale value="${language}"/>
 <fmt:setBundle basename="com.java.myrotiuk.i18n.text"/>
<center>
<table style="width:70%;" >
	<tr>
		<td>
			<form action="${PathManager.COURSES}" method="post">
				<input type="hidden" name="action" value="catalogOfCourses"/>
				<fmt:message key="button.catalog.of.courses"  var="buttonCatalogOfCourses"/>
				<input type="submit" value="${buttonCatalogOfCourses }" style="height:55px; width:210px"/>
			</form>
		</td>
		<td>
			<form action="${PathManager.COURSES}" method="post">
				<input type="hidden" name="action" value="doenrol"/>
				<fmt:message key="button.enrol"  var="buttonEnrol"/>
				<input type="submit" value="${buttonEnrol }" style="height:55px; width:210px"/>
			</form>
		</td>
		<td>
			<form action="${PathManager.COURSES}" method="post">
				<input type="hidden" name="action" value="studentCourses"/>
				<fmt:message key="button.my.courses"  var="buttonMyCourses"/>
				<input type="submit" value="${buttonMyCourses }" style="height:55px; width:210px"/>
			</form>
		</td>
	</tr>
	<tr>
		<td colspan="2%" align="left">
			<form action="${PathManager.COURSES}" method="post">
				<input type="hidden" name="action" value="doQuitStudying"/>
				<fmt:message key="button.quit.studying"  var="buttonQuitStudying"/>
				<input type="submit" value="${buttonQuitStudying }" style="height:55px; width:210px"/>
			</form>
		</td>
		<td align="left">
			<form action="${PathManager.COURSES}" method="post">
				<input type="hidden" name="action" value="graduatedCourses"/>
				<fmt:message key="button.graduated.courses"  var="buttonGraduatedCourses"/>
				<input type="submit" value="${buttonGraduatedCourses}" style="height:55px; width:210px"/>
			</form>
		</td>
	</tr>
</table>
</center>