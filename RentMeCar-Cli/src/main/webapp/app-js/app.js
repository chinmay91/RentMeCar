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



/**
	This part is dedicated to URL constants
*/

var domain = "http://localhost:8080/";
var appName = "RentMeCar/";
var appHome = domain + appName;
var version = "v1/";
var userType = "user/";
var restHome = appHome + "rest/" + userType + version;