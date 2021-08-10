<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Management</title>
</head>
<body>
	<h1>Employee Management</h1>
	<ul>
		<li><a>Welcome ${user.fname} ${user.lname} : ${user.userid}</a></li>
			<c:if test = "${user.role == 'admin'}">
				<li><a href="/EmployeeManagement/manage?action=add_user">Add User</a></li>
				<li><a href="/EmployeeManagement/manage?action=add_regulation">Add Regulation</a></li>
			</c:if>
				<li><a href="/EmployeeManagement/manage?action=add_comment">Add Comment</a></li>
		<li><a href="/EmployeeManagement/manage?action=logout">Log Out</a></li>
	</ul>
	
	
	<c:if test = "${user.role == 'admin'}">
	
	<table border="1">
		<tr><td>Employees</td></tr>
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Phone</th>
			<th>Role</th>
			<th>UserId</th>
		</tr>
		<c:forEach items="${userList}" var="user">
			<tr>
				
				<td>${user.fname}</td>
				<td>${user.lname}</td>
				<td>${user.email}</td>
				<td>${user.phone}</td>
				<td>${user.role}</td>
				<td>${user.userid}</td>
				<td><a href="/EmployeeManagement/manage?action=delete_user&userid=<c:out value='${user.userid}' />">Delete</a></td>

			</tr>
		</c:forEach>
	</table>
	</c:if>
	<table border="1">
		<tr><td>Regulations</td></tr>
		<tr>
			<th>Id</th>
			<th>Details</th>
			<th>Created Date</th>
			<th>Department</th>
		</tr>
		<c:forEach items="${regulationList}" var="regulation">
			<tr>
				<td>${regulation.regulationid}</td>
				<td>${regulation.details}</td>
				<td><fmt:formatDate value="${regulation.createDate}" pattern="yyyy-MM-dd"/></td>
				<td>${regulation.department}</td>
				<c:if test = "${user.role == 'admin'}">
					<td><a href="/EmployeeManagement/manage?action=delete_regulation&regulationid=<c:out value='${regulation.regulationid}' />">Delete</a></td>
				</c:if>
			</tr>
		</c:forEach>
	</table>

	
	<table border="1"  class="center">
		<tr><td>Comments</td></tr>
		<tr>
			<th>Comment_Id</th>
			<th>Comment</th>
			<th>Regulation_Id</th>
			<th>User_Id</th>
			<th>Created Date</th>
		</tr>
		<c:forEach items="${commentList}" var="comment">
			<tr>
				<td>${comment.commentid}</td>
				<td>${comment.details}</td>
				<td>${comment.regulationid}</td>
				<td>${comment.userid}</td>
				<td><fmt:formatDate value="${comment.createDate}" pattern="yyyy-MM-dd"/></td>
				<c:if test = "${user.userid == comment.userid}">
				<td><a href="/EmployeeManagement/manage?action=delete_comment&commentid=<c:out value='${comment.commentid}' />">Delete</a></td>
				</c:if>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>