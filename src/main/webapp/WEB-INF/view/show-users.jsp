<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<title>Admin page - users</title>
</head>
<body>

	<h2>Registered users</h2>
	
	<table>
		<tr>
			<th>Username</th>
			<th>First Name</th>
			<th>Last name</th>
			<th>Email</th>
		</tr>

		<c:forEach var="users" items="${users}">


			<c:url var="deleteLink" value="/admin/deleteUser">
				<c:param name="userId" value="${users.id}" />
			</c:url>

			<tr>
				<td>${users.userName}</td>
				<td>${users.firstName}</td>
				<td>${users.lastName}</td>
				<td>${users.email}</td>

				<td>| <a href="${deleteLink}" onclick="if (!(confirm('Are you shure you want to delete this customer?'))) return false">Delete user</a>

				</td>
			</tr>

		</c:forEach>
	</table>
	
	<br>
	<a href="${pageContext.request.contextPath}/admin/page">Return to admin page</a>

</body>

</html>