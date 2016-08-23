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
		
		.when('/noticias/:id', {
			templateUrl: 'noticias-show.html',
			controller: 'NoticiaController',
			method: 'show'
		})		
		
		.when('/noticias/:id/edit', {
			templateUrl: 'noticias-form.html',
			controller: 'NoticiaController',
			method: 'show'
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
				//Redireciona para a tela de visualizacao
				$location.path('/noticias/' + noticia.id);
			}
		});
	}
	
	//Visualização
	$scope.show = function() {
		$scope.noticia = NoticiaService.get({"id": $routeParams.id});
	}	
	
	$scope.remove = function() {
		if(confirm('Confirma a Exclusão?')) {
	    	NoticiaService.remove($scope.noticia, function(){
	    		$location.path('/noticias');
	    	});
		}
    }	
	
	//Chama o método definido na rota
	if($route.current.method){ 
		$scope[$route.current.method]();
	}
});

