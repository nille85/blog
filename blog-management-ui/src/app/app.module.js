 (function () {
 	'use strict';
  	angular.module("blog", ['ngRoute', 'ngStorage','angular-jwt'])
  		   .config(routeProviderConfig)
  		   .run(authenticationRun)
  		   .run(storageRun);


  	routeProviderConfig.$inject = ['$routeProvider'];
	  function routeProviderConfig($routeProvider) {
	    $routeProvider
	      .when('/overview', {
	        templateUrl: 'overview.html',
	        protected: true
	      })
	      .when('/', {
	        templateUrl: 'app/components/login/login.html',
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
	    var credential = {email:"tester@test.be",password: "test"};
	    var credentials = [];
	    credentials.push(credential);
	    $sessionStorage.credentials = credentials;
	  }


	



})();

 