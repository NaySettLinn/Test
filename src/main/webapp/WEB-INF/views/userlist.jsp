<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
			<thead>
				<tr>
					<th>No.</th>
					<th>Name</th>
					<th>Email</th>
					<th>Actions</th>
				</tr>
			</thead>
				<c:forEach var="user" items="${userlist}"  varStatus="loop">
				<tr>
					<td>${loop.index +1}.</td>
					<td>${user.name}</td>
					<td>${user.email}</td>
					<td>
			 			<a href="editStudent/${user.id}" class="btn btn-success">Update</a>
						<a href="deleteStudent/${user.id}" onclick="return deleteConfirmation()" class="btn btn-danger">Delete</a>
					</td>
				</tr>
				</c:forEach>
		</table>
</body>
</html>