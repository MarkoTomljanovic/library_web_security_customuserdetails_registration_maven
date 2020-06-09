<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<title>Library management</title>
</head>

<body>

	<h2>Library Management System</h2>
	
	Welcome: <security:authentication property="principal.username" />
	<br>
	You are logged in as: <security:authentication property="principal.authorities" />
	<br>

	<security:authorize access="hasRole('MANAGER')">

		<a href="${pageContext.request.contextPath}/books/booksList">Books
			Management</a>
		<a href="${pageContext.request.contextPath}/members/membersList">Members
			Management</a>

	</security:authorize>


	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">

		<input type="submit" value="Logout" />
	</form:form>

	<br>
	<br>

	<table>
		<tr>
			<th>Last Name</th>
			<th>First Name</th>
			<th>Address</th>
			<th>Phone Number</th>
			<th>Email</th>
		</tr>

		<c:forEach var="memb" items="${members}">


			<c:url var="loansLink" value="/loans/membersLoans">
				<c:param name="memberId" value="${memb.id}" />
			</c:url>

			<tr>
				<td>${memb.lastName}</td>
				<td>${memb.firstName}</td>
				<td>${memb.address}</td>
				<td>${memb.phoneNum}</td>
				<td>${memb.email}</td>

				<td>| <a href="${loansLink}">Loans</a>

				</td>
			</tr>

		</c:forEach>
	</table>
</body>

</html>