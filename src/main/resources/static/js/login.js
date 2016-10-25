var app = angular.module('app', []);



//LivroController
app.controller('LoginController', function($scope, $http, $httpParamSerializer) {
	
	$scope.entrar = function() {
		$http({
			  url: '/login',
			  method: 'POST',
			  data: $httpParamSerializer({
					email: $scope.email,
					senha: $scope.senha
			  }),
			  headers: {
			    'Content-Type': 'application/x-www-form-urlencoded'
			  }
		}).success(function(response) {  
			//Login com sucesso
			location.href="/app/index.html";
		}).error(function(response){
			//Login inválido
			$scope.message = "Login e/ou senha inválidos!";
		});		
	}
});







