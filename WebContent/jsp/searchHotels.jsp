<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AngularJS Task Manager</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
<script type="text/javascript" src="app.js"></script>
</head>

<body ng-app="HotelManagement" ng-controller="HotelController">
<br /><br /><br />
	<form ng-submit="getHotelsByCity()">

		<table align="center">
			<tr>
				<td><a href="http://localhost:8080/TaskManagerApp/index.jsp" style="color: red;">Add
						More Hotel</a></td>
			</tr>

			<tr>
				<td><h4>Seach By City</h4></td>
			</tr>

			<tr>
				<td><input type="text" ng-model="searchs"
					placeholder="Enter city name"></td>
			</tr>

			<tr>
				<td><input type="submit" value="search" class="blue-button" /></td>
			</tr>

		</table>

	</form>






</body>
</html>