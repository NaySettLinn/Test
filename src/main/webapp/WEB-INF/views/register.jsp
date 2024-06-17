<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="doregister" method="post" modelAttribute="user">
	
		<table>
		<tr>
			<td>UserName</td>
			<td>
			<form:input path="name" />
			</td>
		</tr>
		
			<tr>
			<td>Email</td>
			<td>
			<form:input path="email"/>
			</td>
		</tr>
		
			<tr>
			<td>Password</td>
			<td>
			<form:password path="password"/>
			</td>
		</tr>
		
		<%-- <tr>
    <td>confirmPassword</td>
    <td>
        <form:input path="confirmPassword"/>
    </td>
</tr> --%>
	<tr>
		<td><input type="submit" value="Send"></td>
	</tr>
		</table>
	</form:form>
		
</body>

</html>