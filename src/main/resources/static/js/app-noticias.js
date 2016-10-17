

/**
 * Configuração das Rotas de Notícias
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


//NoticiaController
app.controller('NoticiaController', function($scope, $routeParams, $route, $location, NoticiaService, CategoriaService, TagService) {
	
	$scope.busca = "";

	//Aprovar
	$scope.aprovar = function() {
		NoticiaService.aprovar($scope.noticia, function(noticia) {
			//Atualiza o objeto noticia na tela
			$scope.noticia = noticia;
		});	
	}
	
	//Busca
	$scope.buscar = function() {
		$scope.noticias = NoticiaService.query({texto:$scope.busca});	
	}
	
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
		$scope.tags = TagService.query();
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