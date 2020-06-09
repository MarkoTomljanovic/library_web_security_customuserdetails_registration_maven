<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>


<head>

<title>Register New User Form</title>


</head>

<body>

	<form:form
		action="processRegistrationForm"
		modelAttribute="webUser" method="POST">
		
		<c:if test="${registrationError != null}">
			${registrationError}
		</c:if>

		<table>

			<tr>
				<td><label>Username: </label></td>
				<td><form:input path="userName" placeholder="username (*)" /></td>
				<td><form:errors path="userName"/></td>
			</tr>

			<tr>
				<td><label>Password: </label></td>
				<td><form:password path="password" placeholder="password (*)" /></td>
				<td><form:errors path="password"/></td>
			</tr>

			<tr>
				<td><label>Confirm password: </label></td>
				<td><form:password path="matchingPassword" placeholder="confirm password (*)" /></td>
				<td><form:errors path="matchingPassword"/></td>
			</tr>

			<tr>
				<td><label>First name: </label></td>
				<td><form:input path="firstName" placeholder="first name (*)" /></td>
				<td><form:errors path="firstName"/></td>
			</tr>

			<tr>
				<td><label>Last name: </label></td>
				<td><form:input path="lastName" placeholder="last name (*)" /></td>
				<td><form:errors path="lastName"/></td>
			</tr>

			<tr>
				<td><label>Email: </label></td>
				<td><form:input path="email" placeholder="email (*)" /></td>
				<td><form:errors path="email"/></td>
			</tr>

			<tr>
			<td><button type="submit">Register</button></td>
			</tr>
			
		</table>
	</form:form>




</body>
</html>