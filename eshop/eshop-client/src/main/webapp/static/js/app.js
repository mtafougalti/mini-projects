var app = angular.module("eshop", ["ngRoute"]);

app.controller("ClientController", function($scope, $http) {
	$scope.greeting = "Category Test";
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