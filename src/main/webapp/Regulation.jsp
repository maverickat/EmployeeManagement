<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Regulation</title>
</head>
<body>
<form method="POST" action='/EmployeeManagement/manage?action=save_regulation'>
        Details : <input type="text" name="details" value="<c:out value="${regulation.details}" />" /><br />
        Department : <input type="text" name="department" value="<c:out value="${regulation.department}" />" /><br />
        RegulationId: <input type="text" name="regulationid" value="<c:out value="${regulation.regulationid}" />" /><br />
        <input type="submit" value="Submit" />
    </form>
</body>
</html>