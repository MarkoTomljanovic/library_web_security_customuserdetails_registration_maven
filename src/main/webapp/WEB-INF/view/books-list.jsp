<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<!DOCTYPE html>
<html>
<head>
<title>Library management</title>
</head>

<body>

	<h2>Books Management System</h2>
	
	<a href="${pageContext.request.contextPath}/loans/list">Library Management</a>

	<input type="button" value="Add Book"
		onclick="window.location.href='addBookForm'; return false;"
		class="add-button" />

	<table>
		<tr>
			<th>Title</th>
			<th>Author's Last Name</th>
			<th>Author's First Name</th>
			<th>Publisher</th>
			<th>Publishing Year</th>
		</tr>
		
		<c:forEach var="books" items="${books}">
		
			<c:url var="updateLink" value="/books/updateBookForm">
				<c:param name="bookId" value="${books.id}" />
			</c:url>
			
			<c:url var="deletebook" value="/books/deleteBook">
				<c:param name="bookId" value="${books.id}" />
			</c:url>



			<tr>
				<td>${books.title}</td>
				<td>${books.authorLastName}</td>
				<td>${books.authorFirstName}</td>
				<td>${books.publisher}</td>
				<td>${books.publishingYear}</td>

				<td>
					<a href="${updateLink}">Update</a>
					| 
					<c:if test="${books.members != NULL}">		
							Delete	
					</c:if>
					<c:if test="${books.members == NULL}">		
							<a href="${deletebook}"
								onclick="if (!(confirm('Are you shure you want to delete this book?'))) return false">Delete</a>	
					</c:if>
					
										
				</td>
			</tr>

		</c:forEach>

		
	</table>
</body>

</html>