<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.java.myrotiuk.resources.PathManager" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 <c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : 'en'}" scope="session"/>
 <fmt:setLocale value="${language}"/>
 <fmt:setBundle basename="com.java.myrotiuk.i18n.text"/>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${param.titele}</title>

 <style>
 
 			input#myCheckBox{
 				display:inline-block;
   				width:19px;
    			height:19px;
   				margin:-1px 4px 0 0;
   				vertical-align:middle;
    			background:url(check_radio_sheet.png) left top no-repeat;
    			cursor:pointer;
 			}
 			
 			
            table#t01{
                margin: auto; 
                width:90%
                border: 1px solid black;
 				border-collapse: collapse;
            }

            table#t01 th {
                border: 1px solid black;
                border-collapse: collapse;
                padding: 7px;
            }
            
            table#t01 th#t02 {
                border: 1px solid black;
                border-collapse: collapse;
                padding: 7px;
            }

 			table#t01 td {
                border: 1px solid black;
                border-collapse: collapse;
                padding: 7px;
            }

            table#t01 tr:nth-child(even) {
                background-color: #eee;
            }
            table#t01 tr:nth-child(odd) {
                background-color:#fff;
            }

            table#t01 th{
                background-color: #33FF66;
                color: black;
            }
        </style>

</head>
<body>

<table style="width: 100%">
	<tr>
		<th align="left">
		<fmt:message key="label.name"/>: ${empty student ? teacher.firstName : student.firstName} ${empty student ? teacher.lastName : student.lastName} 
		</th>
		<th>
		<fmt:message key="label.email.address"/>: ${empty student ? teacher.email : student.email}
		</th>
		
		<th align="right">
			<form action="${not empty param.currentPage ?  param.currentPage : not empty currentPage ? currentPage : not empty command ? PathManager.COURSES : './index'}" method="post">
				
				<input type="hidden" name="action" value="${command}"/><!-- command that has to be executed again when changed language-->
				
				<input type="hidden" name="currentPage" value="${not empty param.currentPage ? param.currentPage : currentPage}"/>
				
				<h3><fmt:message key="label.language"/>:
				<select name="language" onchange="submit()" style="width: 200px; height: 50px; font-size:12pt;">
					<option value="en" ${language == 'en' ? 'selected' : ''}><fmt:message key="label.language.english"/></option>
					<option value="ru" ${language == 'ru' ? 'selected' : ''}><fmt:message key="label.language.russian"/></option>
				</select></h3>
			</form>
		</th>
		
		<th align="right">
			<form action="${PathManager.COURSES}" method="post">
				<input type="hidden" name="action" value="logout"/>
				<fmt:message key="button.logout" var="buttonLogOut"/>
				<input type="submit" value="${buttonLogOut}"style="height:50px; width:200px;"/>
			</form>
		</th>
	</tr>
</table>






<hr/>

