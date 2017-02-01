/**
 * 
 */

function loginController($scope,loginFactory,$location){
	
	$scope.btnLogin = function(){
		console.log(restHome);
		loginFactory.performLogin($scope.inUsername,$scope.inPassword).then(function(success){
			if(success.status == "200"){
				console.log("Login now");
				$location.url("/userhome");
			}else if(success.status == "400" || success.status == "404"){
				console.log("Requested resource not found");
			}else if(success.status == "403"){
				console.log("Sorry but you are not authorized to access this resource");
				$scope.message = "You are not authorized to access this resource";
			}else{
				console.log("Not sure what exactly happened");
			}
		},function(err){
			console.log(err);
			if(err.status == "401"){
				$scope.message = "Invalid Username/Password";
			}else if(err.status == "403"){
				$scope.message = "You are not authorized to access resource";
			}
		});
	}
}