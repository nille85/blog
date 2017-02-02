(function () {
    'use strict';
 
    angular
        .module('blog')
        .factory('AuthenticationService', AuthenticationService);
 
    AuthenticationService.$inject = ['$sessionStorage', '$filter', '$q'];
    function AuthenticationService($sessionStorage, $filter, $q) {
 
        var service = {}; 
 
        service.GetByCredentials = GetByCredentials;
        
        return service;
              
        //public functions
        function GetByCredentials(credentials) {           
            var deferred = $q.defer();
            var filtered = $filter('filter')(getAllCredentials(), { username: credentials.username, password: credentials.password });    
            var creds = filtered.length ? filtered[0] : null;      
            if(creds === null){
                deferred.reject("401 unauthorized");
              
            }else{
                var user ={username:credentials.username, personId: 1 };
                deferred.resolve(user);
            }
            return deferred.promise;
        }
        
 
        // private functions
        function getAllCredentials() {
            return $sessionStorage.credentials;
        }
 
        
    }
})();