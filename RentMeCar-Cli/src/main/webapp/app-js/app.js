/**
 * 
 */

var app = angular.module('rentACar',['ui.router']).config(
		[ '$stateProvider','$urlRouterProvider', function($stateProvider,$urlRouterProvider) {
			$urlRouterProvider.otherwise("/login");
			$stateProvider
				.state('login',{
					url: "/login",
					templateUrl : "pages/login.html",
					controller : loginController
				})
				.state('userhome',{
					url:"/userhome",
					templateUrl: 'pages/users/home.html',
					controller: homeController
				})
				.state('cars',{
					url:"/viewcars",
					templateUrl : 'pages/admin/cars.html',
					controller: carsController
				})
			/*$routeProvider.when('/userhome', {
				templateUrl : 'pages/users/home.html',
				controller : homeController
			}).when('/login', {
				templateUrl : 'pages/login.html',
				controller : loginController
			}).otherwise({
				redirectTo : '/login'
			});*/
		} ]);


app.factory('AuthenticationService', AuthenticationService);

/**
	This part is dedicated to URL constants
*/

var domain = "http://localhost:8080/";
var appName = "RentMeCar/";
var appHome = domain + appName;
var version = "v1/";
var userType = "user/";
var restHome = appHome + "rest/" + userType + version;