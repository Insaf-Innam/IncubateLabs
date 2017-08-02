<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AngularJS Task Manager</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
<script type="text/javascript" src="./js/app.js"></script>
</head>

<body ng-app="HotelManagement" ng-controller="HotelController">
	<h1 align="center">Hotels In Sri Lanka</h1>
	<div align="center">
		<a href="rest/hotels/search" style="color: red;">Search Hotels</a>
	</div>
	<form ng-submit="submitHotel()">
		<table align="center">
			<tr>
				<th colspan="2">Add Hotel</th>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type="text" ng-model="hotelForm.name" /></td>
			</tr>
			<tr>
				<td>No</td>
				<td><input type="text" ng-model="hotelForm.no" /></td>
			</tr>
			<tr>
				<td>Street</td>
				<td><input type="text" ng-model="hotelForm.street" /></td>
			</tr>
			<tr>
				<td>City</td>
				<td><input type="text" ng-model="hotelForm.city" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit"
					class="blue-button" /></td>
			</tr>
		</table>
	</form>

	<table align="center" border="2px">
		<tr>
			<th>Hotel Name</th>
			<th>No</th>
			<th>Street</th>
			<th>City</th>

		</tr>

		<tr ng-repeat="hotel in hotels">

			<td>{{ hotel.name }}</td>
			<td>{{ hotel.no }}</td>
			<td>{{ hotel.street }}</td>
			<td>{{ hotel.city }}</td>

		</tr>

	</table>

</body>
</html>