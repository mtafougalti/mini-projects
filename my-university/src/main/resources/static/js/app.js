var app = angular.module("my-university", ["ngRoute"]);

app.controller("StudentController", function($scope, $http) {
	$scope.greeting = "Hello From Angular JS";
	$scope.students = [];
	$scope.student = {};
	$http.get("/student/list").then(function(response) {
		$scope.students = response.data;
	});
	$scope.saveStudent=function(){
		$http.post("/student/add", $scope.student).then(function(response) {
			$scope.student={};
			$http.get("/student/list").then(function(response) {
				$scope.students = response.data;
			});
		});
	};
});

app.controller("ProductController", function($scope, $http) {
	$scope.greeting = "Category Test";
	$scope.products = [];
	$scope.categories = [];
	
	$http.get("/eshop-client/rest/product/listAll").then(function(response) {
		$scope.products = response.data;
	});
	
	$http.get("/eshop-client/rest/category/listAll").then(function(response) {
		$scope.categories = response.data;
	});
});