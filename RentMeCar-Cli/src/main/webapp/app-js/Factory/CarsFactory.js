/**
 * 
 */

app.factory('carsFactory', function($http, $q) {
	var carUrl = "http://localhost:8080/RentMeCar/rest/admin/v1/cars"
	return {
		getCars : function(username, password) {
			var deferred = $q.defer();
			$http({
				method : 'GET',
				url : login,
				headers : {
					'Content-Type' : 'application/json',
					'Accept' : 'application/json',
					'Authorization' : 'Basic ' + window.btoa(unescape(encodeURIComponent(username + ':' + password)))
				},
				data : {
					'username' : username,
					'password' : password
				}
			}).then(function(data, status, headers, config) {
				deferred.resolve(data);
			}, function(data, status, headers, config) {
				deferred.reject(data);
			});
			return deferred.promise;
		}
	};
});

// CORS: http://restlet.com/blog/2015/12/15/understanding-and-using-cors/