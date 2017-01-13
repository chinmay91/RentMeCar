/**
 * 
 */

app.factory('loginFactory', function($http, $q) {
	var login = restHome + "home";
	return {
		performLogin : function(username, password) {
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
				deferred.reject(status);
			});
			return deferred.promise;
		}
	};
});