<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Login Page</title>


</head>

<body>

	<h3>Login Page</h3>

	<form:form
		action="${pageContext.request.contextPath}/authenticateTheUser"
		method="POST">

		<c:if test="${param.error != null }">

			<i>Wrong username and/or password!</i>

		</c:if>
		<c:if test="${param.logout != null }">

			<i>Successfully logged out</i>

		</c:if>

		<p>
			User name: <input type="text" name="username" />
		</p>
		<p>
			Password: <input type="password" name="password" />
		</p>
		<input type="submit" value="login" />


	</form:form>
	




</body>

</html>