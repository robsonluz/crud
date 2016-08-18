var app = angular.module('app', ['ngResource', 'ngRoute']);

/**
 * Configuração das Rotas (páginas do sistema)
 */
app.config(['$routeProvider', function($routerProvider){
	$routerProvider
		.when('/', {
			templateUrl: 'home.html'
		})
		
		.when('/noticias', {
			templateUrl: 'noticias-list.html',
			controller: 'NoticiaController',
			method: 'list'
		})
		
		.when('/noticias/new', {
			templateUrl: 'noticias-form.html',
			controller: 'NoticiaController',
			method: 'create'
		})
	;
}]);


//NoticiaService
app.factory('NoticiaService', function($resource) {
	return $resource('/api/noticias/:id', {}, {});
});

//NoticiaController
app.controller('NoticiaController', function($scope, $routeParams, $route, $location, NoticiaService) {
	//Lista
	$scope.list = function() {
		$scope.noticias = NoticiaService.query();	
	}
	//Novo
	$scope.create = function() {
		$scope.noticia = {};
	}	
	//Salva
	$scope.save = function() {
		NoticiaService.save($scope.noticia, function(noticia){
			if(noticia) {
				$location.path('/noticias');
			}
		});
	}
	
	//Chama o método definido na rota
	if($route.current.method){ 
		$scope[$route.current.method]();
	}
});

