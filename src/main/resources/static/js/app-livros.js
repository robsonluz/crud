
/**
 * Configuração das Rotas de Livros
 */
app.config(['$routeProvider', function($routerProvider){
	$routerProvider
		
		.when('/livros', {
			templateUrl: 'livros-list.html',
			controller: 'LivroController',
			method: 'list'
		})
		
		.when('/livros/new', {
			templateUrl: 'livros-form.html',
			controller: 'LivroController',
			method: 'create'
		})
		
		.when('/livros/:id', {
			templateUrl: 'livros-show.html',
			controller: 'LivroController',
			method: 'show'
		})		
		
		.when('/livros/:id/edit', {
			templateUrl: 'livros-form.html',
			controller: 'LivroController',
			method: 'show'
		})		
	;
}]);



//LivroController
app.controller('LivroController', function($scope, $routeParams, $route, $location, LivroService) {
	
	$scope.busca = "";

	//Lista
	$scope.list = function() {
		$scope.livros = LivroService.query();	
	}
	//Novo
	$scope.create = function() {
		$scope.livro = {
				capitulos: []
		};
	}
	
	//Visualização
	$scope.show = function() {
		$scope.livro = LivroService.get({"id": $routeParams.id});
	}	
	
	//Salva
	$scope.save = function() {
		LivroService.save($scope.livro, function(livro){
			if(livro) {
				//Redireciona para a tela de visualizacao
				$location.path('/livros/' + livro.id);
			}
		});
	}
	
	$scope.remove = function() {
		if(confirm('Confirma a Exclusão?')) {
		    	LivroService.remove($scope.livro, function(){
		    		$location.path('/livros');
		    	});
		}
    }	
	
	//Manutenção dos Capitulos
	$scope.novoCapitulo = function() {
		var capitulo = {};//cria um novo capitulo
		$scope.capitulo = capitulo;
		$scope.livro.capitulos.push(capitulo);//adiciona na lista
		$('#capitulosModal').modal();
	}
	$scope.editarCapitulo = function(capitulo) {
		$scope.capitulo = capitulo;
		$('#capitulosModal').modal();
	}
	$scope.removerCapitulo = function(capitulo) {
		$scope.livro.capitulos.splice(capitulo, 1);
	}
	
	//Chama o método definido na rota
	if($route.current.method){ 
		$scope[$route.current.method]();
	}
});







