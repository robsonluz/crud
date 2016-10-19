var app = angular.module('app', ['ngResource', 'ngRoute', 'fxpicklist']);

//Interceptor de autenticação
app.factory('authInterceptorService', ['$q', function ($q){
    return {
        responseError: function (rejection) {
            if (rejection.status === 401) {
                location.href = "/#login";
            }
            return $q.reject(rejection);
        }
    };
}]);
app.config(['$httpProvider', function($httpProvider) {
    $httpProvider.interceptors.push('authInterceptorService');
}]);

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

