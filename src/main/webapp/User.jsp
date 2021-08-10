<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User</title>
</head>
<body>
	<form method="POST" action='/EmployeeManagement/manage?action=save_user'>
        First Name : <input type="text" name="fname" value="<c:out value="${user.fname}" />" /><br />
        Last Name : <input type="text" name="lname" value="<c:out value="${user.lname}" />" /><br />
        Email : <input type="text" name="email" value="<c:out value="${user.email}" />" /><br />
        Phone : <input type="text" name="phone" value="<c:out value="${user.phone}" />" /><br />
        Role : <input type="text" name="role" value="<c:out value="${user.role}" />" /><br />
        UserId : <input type="text" name="userid" value="<c:out value="${user.userid}" />" /><br />
        Password : <input type="text" name="password" value="<c:out value="${user.password}" />" /><br />
        <input type="submit" value="Submit" />
        <input type="submit" value="Cancel" name="cancel"/>
    </form>
</body>
</html>