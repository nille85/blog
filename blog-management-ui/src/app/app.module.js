 (function () {
 	'use strict';
  	angular.module("blog", ['ngRoute', 'ngStorage','angular-jwt'])
  		   .config(routeProviderConfig)
  		   .run(authenticationRun)
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
	      .when('/posts/:postId', {
	        templateUrl: 'app/components/post/add.html',
	        protected: true
	      })
	      .when('/categories', {
	        templateUrl: 'app/components/category/overview.html',
	        protected: true
	      })
	      .when('/categories/:categoryId', {
	        templateUrl: 'app/components/category/add.html',
	        protected: true
	      })
	      .otherwise({
	        redirectTo: '/'
	      });
	  }


	  authenticationRun.$inject = ['$rootScope', '$log', '$localStorage', '$location'];
	  function authenticationRun($rootScope, $log, $localStorage, $location) {
	    $rootScope.$on("$routeChangeSuccess", function (event, nextRoute, currentRoute) {
	      $rootScope.protected = false;
	      if (nextRoute) {
	        var protectedRoute = nextRoute.$$route.protected;
	        $rootScope.protected = protectedRoute;
	        console.log("Next route is:" + nextRoute.$$route.protected);
	        if(protectedRoute){
	        	$log.debug(nextRoute.$$route);
	        	//check JWT
	        	if(!$localStorage.token){
	        		$location.path( "/" );
	        	}


	        }
	        
	      }
	    });
	  }


	  /**
	  *
		This is only used while prototyping
	  */
	  storageRun.$inject = ['$sessionStorage'];
	  function storageRun($sessionStorage) {
	    $sessionStorage.credentials = buildCredentials();
	    $sessionStorage.categories = buildCategories();
	    $sessionStorage.posts = buildPosts();

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

 