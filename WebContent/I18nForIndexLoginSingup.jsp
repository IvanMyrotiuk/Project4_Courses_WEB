<%@page contentType="text/html" pageEncoding="UTF-8"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : 'en'}" scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="com.java.myrotiuk.i18n.text"/>  
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="${language}">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${param.titele}</title>
</head>
<body>

<table style="width: 100%">

	<tr><td  align="right">
	<form action="${not empty currentPage ? currentPage : index.jsp}">
	<input type="hidden" name="currentPage" value="${not empty param.currentPage ? param.currentPage : currentPage }"/>
		<h3><fmt:message key="label.language"/>:
		<select name="language" onchange="submit()" style="width: 290px; height: 50px; font-size:12pt;">
			<option value="ru" ${language == 'ru' ? 'selected':'' }><fmt:message key="label.language.russian"/></option>
			<option value="en" ${language == 'en' ? 'selected':''}><fmt:message key="label.language.english"/></option>
		</select></h3>
	</form>
	<td/></tr>
</table>
<hr/><br/>

