<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Management Login</title>
</head>
<body>
	<form action="manage" method="post">
		<table style="width: 50%; margin-left: auto; margin-right: auto;">
			<tr>
				<td>UserId</td>
				<td><input type="text" name="uid"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="pwd"></td>
			</tr>
			<tr>
				<td></td><td><input type="submit" value="Login"></td>
			</tr>
		</table>
	</form>
</body>
</html>