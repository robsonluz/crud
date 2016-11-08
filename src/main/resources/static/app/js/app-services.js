//NoticiaService
app.factory('NoticiaService', function($resource) {
	return $resource('/api/noticias/:id', {}, {
		aprovar: {
			method: 'POST',
			url: '/api/noticias/:id/aprovar',
			params: { id: '@id' }
		},
		upload: {
			method: 'POST', 
			url: '/api/noticias/upload',
			headers: {
            	"Content-Type": "multipart/form-data;"
			}			
		}
	});
});

//CategoriaService
app.factory('CategoriaService', function($resource) {
	return $resource('/api/categorias/:id', {}, {});
});

//CategoriaService
app.factory('TagService', function($resource) {
	return $resource('/api/tags/:id', {}, {});
});

//LivroService
app.factory('LivroService', function($resource) {
	return $resource('/api/livros/:id', {}, {});
});
