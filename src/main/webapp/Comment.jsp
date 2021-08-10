<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Comments</title>
</head>
<body>
	<form method="POST" action='/EmployeeManagement/manage?action=save_comment'>
        Regulation Id: <input type="text" name="regulationid" value="<c:out value="${comment.regulationid}" />" /><br />
        Comments : <input type="text" name="details" value="<c:out value="${comment.details}" />" /><br />
        CommentId: <input type="text" name="commentid" value="<c:out value="${comment.commentid}" />" /><br />
        <input type="submit" value="Submit" />
    </form>
</body>
</html>