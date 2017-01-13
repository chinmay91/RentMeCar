/**
 * 
 */

var app = angular.module('rentACar',['ngRoute']).config(
		[ '$routeProvider', function($routeProvider) {
			$routeProvider.when('/home', {
				templateUrl : 'pages/home.html',
				controller : homeController
			}).when('/login', {
				templateUrl : 'pages/login.html',
				controller : loginController
			}).otherwise({
				redirectTo : '/login'
			});
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