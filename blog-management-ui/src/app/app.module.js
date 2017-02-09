 (function () {
 	'use strict';
  	angular.module("blog", ['ngRoute', 'ngStorage','angular-jwt','xeditable',
  		'ngSanitize','markdown','ui.bootstrap'])
  		   .config(routeProviderConfig)
  		   .run(principalRun)
  		   .run(authenticationRun)
  		   .run(editableRun)
  		   .run(storageRun);
	

  	routeProviderConfig.$inject = ['$routeProvider'];
	  function routeProviderConfig($routeProvider) {
	    $routeProvider
	      .when('/', {
	        templateUrl: 'app/components/login/login.html',
	        protected: false
	      })
	      .when('/posts', {
	        templateUrl: 'app/components/post/overview.html',
	        protected: true
	      })
	      .when('/posts/edit/:postId', {
	        templateUrl: 'app/components/post/edit.html',
	        protected: true
	      })
	      .when('/posts/add', {
	        templateUrl: 'app/components/post/add.html',
	        protected: true
	      })
	      .when('/categories', {
	        templateUrl: 'app/components/category/overview.html',
	        protected: true
	      })
	      .when('/categories/:categoryId', {
	        templateUrl: 'app/components/category/save.html',
	        protected: true
	      })
	      .otherwise({
	        redirectTo: '/'
	      });
	  }


	  authenticationRun.$inject = ['$rootScope', '$log', 'Principal', '$location'];
	  function authenticationRun($rootScope, $log, Principal, $location) {
	    $rootScope.$on("$routeChangeSuccess", function (event, nextRoute, currentRoute) {
	      $rootScope.protected = false;
	      if (nextRoute) {
	        var protectedRoute = nextRoute.$$route.protected;
	        $rootScope.protected = protectedRoute;
	        console.log("Next route is:" + nextRoute.$$route.protected);
	        if(protectedRoute){
	        	//check JWT
	        	if(!Principal.exists()){
	        		$location.path( "/" );
	        	}
	        
	        }else{
		        if(Principal.exists()){
		        	$location.path("/posts");
		        }
	        }

	        
	      }
	    });
	  }

	  principalRun.$inject = ['$localStorage','Principal'];
	  function principalRun($localStorage, Principal){
	  	if($localStorage.token){
	  		Principal.create($localStorage.token);
	  	}
	  }


	  editableRun.$inject = ['editableOptions'];
	  function editableRun(editableOptions) {
		  editableOptions.theme = 'bs3'; // bootstrap3 theme. Can be also 'bs2', 'default'
	  };


	  /**
	  *
		This is only used while prototyping
	  */
	  storageRun.$inject = ['$sessionStorage'];
	  function storageRun($sessionStorage) {
	  	if(!$sessionStorage.credentials){
	    	$sessionStorage.credentials = buildCredentials();
		}/*
		if(!$sessionStorage.categories){
	    	$sessionStorage.categories = buildCategories();
		}
		if(!$sessionStorage.posts){
	    	$sessionStorage.posts = buildPosts();
		}*/

	  }


	  function buildCredentials(){
	  	var credential = {email:"tester@test.be",password: "test"};
	    var credentials = [];
	    credentials.push(credential);
	    return credentials;
	  }

	  function buildCategories(){
	  	var categories = [createCategory('1','MongoDB'),
	  					  createCategory('2','Web Security'),
	  					  createCategory('3','Java' )
	  					 ];
	  	return categories;

	  	function createCategory(id, description){
	  		return {id : id, description : description};
	  	}
	  }

	  function buildPosts(){
	  		var posts = [
	  						createPost('1','Bootstrap is awesome','Published', new Date(2017, 1, 2)),
	  						createPost('2','MongoDB rules','Draft', new Date(2017, 1, 3))
	  					];


	        function createPost(id, title, status, createdDate){
	        	return {id : id, title: title, status : status, createdDate : createdDate.getTime()};
	        }
	        return posts;

	  }


	



})();

 