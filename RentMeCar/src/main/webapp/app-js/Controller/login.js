/**
 * 
 */

function loginController($scope,loginFactory){
	
	$scope.btnLogin = function(){
		console.log(restHome);
		loginFactory.performLogin($scope.inUsername,$scope.inPassword).then(function(success){
			if(success.status == "200"){
				console.log("Login now");
			}else if(success.status == "400" || success.status == "404"){
				console.log("Requested resource not found");
			}else if(success.status == "401"){
				console.log("Bad username password");
				$scope.message = "Invalid Username/Password";
			}else if(success.status == "403"){
				console.log("Sorry but you are not authorized to access this resource");
			}else{
				console.log("Not sure what exactly happened");
			}
		},function(err){
			console.log("failed");
		});
	}
}