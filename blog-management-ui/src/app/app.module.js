 (function () {
 	'use strict';
  	angular.module("blog", ['ngRoute'])
  		   .config(routeProviderConfig)
  		   .run(authenticationRun);


  	routeProviderConfig.$inject = ['$routeProvider'];
	  function routeProviderConfig($routeProvider) {
	    $routeProvider
	      .when('/', {
	        templateUrl: 'overview.html',
	        protected: true
	      })
	      .when('/login', {
	        templateUrl: 'login.html',
	        protected: false
	      })
	      .when('/posts/:postId', {
	        templateUrl: 'add_post.html',
	        protected: true
	      })
	      .otherwise({
	        redirectTo: '/'
	      });
	  }


	  authenticationRun.$inject = ['$rootScope'];
	  function authenticationRun($rootScope) {
	    $rootScope.$on("$routeChangeSuccess", function (event, nextRoute, currentRoute) {
	      $rootScope.protected = false;
	      if (nextRoute) {
	        var protectedRoute = nextRoute.$$route.protected;
	        $rootScope.protected = protectedRoute;
	        console.log(nextRoute.$$route.protected);
	      }
	    });
	  }



})();

 