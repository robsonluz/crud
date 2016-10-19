
/**
 * Configuração das Rotas de Livros
 */
app.config(['$routeProvider', function($routerProvider){
	$routerProvider
		
		.when('/login', {
			templateUrl: 'login.html',
			controller: 'LoginController'
		})
	;
}]);



//LivroController
app.controller('LoginController', function($scope, $http, $httpParamSerializer, $location) {
	
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
			$location.path('/');
		}).error(function(response){
			//Login inválido
			$scope.message = "Login e/ou senha inválidos!";
		});		
	}
});







