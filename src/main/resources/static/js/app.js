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

app.factory('CategoriaService', function($resource) {
	return $resource('/api/categorias/:id', {}, {});
});

//NoticiaController
app.controller('NoticiaController', function($scope, $routeParams, $route, $location, NoticiaService, CategoriaService) {
	//Lista
	$scope.list = function() {
		$scope.noticias = NoticiaService.query();	
	}
	//Novo
	$scope.create = function() {
		$scope.noticia = {};
		$scope.carregarDados();
	}
	
	//Visualização
	$scope.show = function() {
		$scope.carregarDados();
		$scope.noticia = NoticiaService.get({"id": $routeParams.id});
	}	
	
	//Carrega as categorias
	$scope.carregarDados = function() {
		$scope.categorias = CategoriaService.query();
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