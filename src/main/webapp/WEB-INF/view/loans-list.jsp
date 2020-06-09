<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<!DOCTYPE html>
<html>
<head>
<title>Library management</title>
</head>

<body>

	<h2>Book Loans For: ${memberLoans.firstName} ${memberLoans.lastName}</h2>
	<a href="${pageContext.request.contextPath}">Loans's list</a>
	<br><br>
	<h3>Loaned books:</h3>
	
	<table>
		<tr>
			<th>Title</th>
			<th>Author's Last Name</th>
			<th>Author's First Name</th>
		</tr>

		<c:forEach var="books" items="${memberLoans.books}">
  
			<c:url var="returnBook" value="/loans/returnBook">
				<c:param name="bookId" value="${books.id}" />
			</c:url>

			<tr>
				<td>${books.title}</td>
				<td>${books.authorLastName}</td>
				<td>${books.authorFirstName}</td>
 
				<td>
					|
					<a href="${returnBook}">Return book</a>				
				</td>
			</tr>
		</c:forEach>
	</table>
	
	<h3>Book available to loan:</h3>
	 
	<table>
		<tr>
			<th>Title</th>
			<th>Author's Last Name</th>
			<th>Author's First Name</th>
		</tr>

		<c:forEach var="books" items="${booksnomembers}">
  
			<c:url var="loanBook" value="/loans/loanBook">
				<c:param name="bookId" value="${books.id}" />
				<c:param name="memberId" value="${memberLoans.id}" />
			</c:url>

			<tr>
				<td>${books.title}</td>
				<td>${books.authorLastName}</td>
				<td>${books.authorFirstName}</td>
 				<td>
					|
					<a href="${loanBook}">Loan book</a>				
				</td>

			</tr>
		</c:forEach>
	</table>
	
	
</body>

</html>