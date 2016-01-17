<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/mytaglib" prefix="MyrotiukIvan"%>
<%@page import="com.java.myrotiuk.resources.PathManager" %>

<%@include file="./I18nForIndexLoginSingup.jsp"%>

<center>
	<form action='${PathManager.COURSES}' method="post">
		<input type="hidden" name="action" value="dologin"/>
		<fmt:message key="button.login" var="buttonLogin"/>
		<input type="submit" value="${buttonLogin}" style="height:50px; width:200px; "/>
	</form>
	<br/>
	<form action='${PathManager.COURSES}' method="post">
		<input type="hidden" name="action" value="dosingup"/>
		<fmt:message key="button.singup" var="buttonSingup"/>
		<input type="submit" value="${buttonSingup}" style="height:50px; width:200px; "/>
	</form>
	<br/><br/>
	${nullPageMessage}
</center>

<jsp:useBean id="date" class="java.util.Date" scope="page"/>

<MyrotiukIvan:fontTagHandler color="gold">
	<MyrotiukIvan:multipleText>
		Ivan Myrotiuk's Corporation
	</MyrotiukIvan:multipleText>
</MyrotiukIvan:fontTagHandler>

<MyrotiukIvan:fontTagHandler size="5" color="goldenrod">
${date}
</MyrotiukIvan:fontTagHandler>
<MyrotiukIvan:fontTagHandler color="red">
All Rights Reserved
</MyrotiukIvan:fontTagHandler>


</body>
</html>