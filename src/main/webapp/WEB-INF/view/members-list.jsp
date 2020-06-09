<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<!DOCTYPE html>
<html>
<head>
<title>Library management</title>
</head>

<body>

	<h2>Members Management System</h2>
	
	<a href="${pageContext.request.contextPath}/loans/list">Library Management</a>

	<input type="button" value="Add Member"
		onclick="window.location.href='addMemberForm'; return false;"
		class="add-button" />

	<table>
		<tr>
			<th>Last Name</th>
			<th>First Name</th>
			<th>Address</th>
			<th>Phone Number</th>
			<th>Email</th>
		</tr>

		<c:forEach var="memb" items="${members}">
 

			<c:url var="deleteLink" value="/members/delete">
				<c:param name="memberId" value="${memb.id}" />
			</c:url>
			
			<c:url var="updateLink" value="/members/updateMemberForm">
				<c:param name="memberId" value="${memb.id}" />
			</c:url>
			


			<tr>
				<td>${memb.lastName}</td>
				<td>${memb.firstName}</td>
				<td>${memb.address}</td>
				<td>${memb.phoneNum}</td>
				<td>${memb.email}</td>

				<td>
					<a href="${updateLink}">Update</a>
					| 
					<c:if test="${fn:length(memb.books) > 0}">		
							Delete	
					</c:if>
					
					<c:if test="${fn:length(memb.books) == 0}">		
							<a href="${deleteLink}"
								onclick="if (!(confirm('Are you shure you want to delete this customer?'))) return false">Delete</a>	
					</c:if>
				
				</td>
			</tr>

		</c:forEach>
	</table>
</body>

</html>