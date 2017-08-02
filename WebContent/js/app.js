var app = angular.module("HotelManagement", []);

// Controller Part
app.controller("HotelController", function($scope, $http) {

	$scope.hotels = [];
	$scope.hotelForm = {
		name : "",
		no : "",
		street : "",
		city : ""
	};

	$scope.searchs = "";

	// Now load the data from server
	_refreshHotelData();

	// HTTP POST/PUT methods for add/edit country
	// with the help of id, we are going to find out whether it
	// is put or post operation

	$scope.submitHotel = function() {
		$http({
			method : "POST",
			url : 'rest/hotels',
			data : angular.toJson($scope.hotelForm),
			headers : {
				'Content-Type' : 'application/json'
			}
		}).then(_success, _error);
	};

	/* Private Methods */
	// HTTP GET- get all countries collection
	function _refreshHotelData() {
		$http({
			method : 'GET',
			url : 'http://localhost:8080/TaskManagerApp/rest/hotels'
		}).then(function successCallback(response) {
			$scope.hotels = response.data;
		}, function errorCallback(response) {
			console.log(response.statusText);
		});
	}

	function getHotelsByCity() {
		var s = "abc";
		alert("comes here")
		$http({
			method : 'GET',
			url : 'rest/hotels/search/' + s,
		}).then(function successCallback(response) {
			$scope.hotels = response.data;
		}, function errorCallback(response) {
			console.log(response.statusText);
		});
	}

	function _success(response) {
		_refreshHotelData();
		_clearFormData()
	}

	function _error(response) {
		console.log(response.statusText);
	}

	// Clear the form
	function _clearFormData() {
		$scope.hotelForm.name = "";
		$scope.hotelForm.no = 0;
		$scope.hotelForm.street = "";
		$scope.hotelForm.city = "";

	}
	;
});
