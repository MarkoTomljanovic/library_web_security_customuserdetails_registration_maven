<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Admin page</title>
</head>
<body>

	<h2>Welcome to admin page</h2>

	Welcome:
	<security:authentication property="principal.username" />
	<br> You are logged in as:
	<security:authentication property="principal.authorities" />
		<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">

		<input type="submit" value="Logout" />
	</form:form>
	
	<br><br>

	<a href="${pageContext.request.contextPath}/register/showRegistrationForm">Register	new user</a>
	<a href="${pageContext.request.contextPath}/admin/showUsers">Show users</a>

</body>

</html>