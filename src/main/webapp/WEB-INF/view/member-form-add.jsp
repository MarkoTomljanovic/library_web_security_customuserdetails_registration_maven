<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
  <head>
    <title>Add new member</title>
  </head>
  <body>
    <h2>Add new Member</h2>
    
    <form:form action="saveMember" modelAttribute="member" method="POST">
   <form:hidden path="id"/>
      
      <table>
        <tr>
          <td><label>First name:</label></td>
          <td><form:input path="firstName"/></td>
          <td><form:errors path="firstName"/></td>
        </tr>
        <tr>
          <td><label>Last name:</label></td>
          <td><form:input path="lastName"/></td>
          <td><form:errors path="lastName"/></td>
        </tr>
        <tr>
          <td><label>Address:</label></td>
          <td><form:input path="address"/></td>
          <td><form:errors path="address"/></td>
        </tr>
        <tr>
          <td><label>Phone number:</label></td>
          <td><form:input path="phoneNum"/></td>
          <td><form:errors path="phoneNum"/></td>
        </tr>
        <tr>
          <td><label>Email</label></td>
          <td><form:input path="email"/></td>
          <td><form:errors path="email"/></td>
        </tr>
        <tr>
			<td><label></label></td>
			<td><input type="submit" value="Save"/></td>
				<td><input type="button" value="Cancel"
					onclick="window.location.href='membersList'; return false;"/></td>		
		</tr>
      </table>
    </form:form>
</html>