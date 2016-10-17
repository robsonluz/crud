var app = angular.module('app', ['ngResource', 'ngRoute', 'fxpicklist']);

/**
 * Configuração das Rotas Principais
 */
app.config(['$routeProvider', function($routerProvider){
	$routerProvider
		
		.when('/', {
			templateUrl: 'home.html'
		})
		
	;
}]);

Array.prototype.remove = function(from, to) {
  var rest = this.slice((to || from) + 1 || this.length);
  this.length = from < 0 ? this.length + from : from;
  return this.push.apply(this, rest);
};