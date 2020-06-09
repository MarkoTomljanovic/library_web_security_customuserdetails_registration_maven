<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
  <head>
    <title>Add new book</title>
  </head>
  <body>
    <h2>Add new Book</h2>
    
    <form:form action="saveBook" modelAttribute="book" method="POST">
   <form:hidden path="id"/>
      
      <table>
        <tr>
          <td><label>Title:</label></td>
          <td><form:input path="title"/></td>
          <td><form:errors path="title"/></td>
        </tr>
        <tr>
          <td><label>Author's Last name:</label></td>
          <td><form:input path="authorLastName"/></td>
          <td><form:errors path="authorLastName"/></td>
        </tr>
        <tr>
          <td><label>Author's First name::</label></td>
          <td><form:input path="authorFirstName"/></td>
          <td><form:errors path="authorFirstName"/></td>
        </tr>
        <tr>
          <td><label>Publisher:</label></td>
          <td><form:input path="publisher"/></td>
          <td><form:errors path="publisher"/></td>
        </tr>
        <tr>
          <td><label>Publishing Year:</label></td>
          <td><form:input path="publishingYear"/></td>
          <td><form:errors path="publishingYear"/></td>
        </tr>
        <tr>
			<td><label></label></td>
			<td><input type="submit" value="Save"/></td>
			<td><input type="button" value="Cancel"
					onclick="window.location.href='booksList'; return false;"/></td>
		</tr>
      </table>
    </form:form>
</html>