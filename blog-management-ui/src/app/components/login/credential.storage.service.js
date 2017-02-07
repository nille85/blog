(function () {
    'use strict';
 
    angular
        .module('blog')
        .factory('UserService', UserService);
 
    UserService.$inject = ['$sessionStorage', '$filter', '$q'];
    function UserService($sessionStorage, $filter, $q) {
 
        var service = {}; 
 
        service.getByCredentials = getByCredentials;
        
        return service;
              
        //public functions
        function getByCredentials(credentials) {           
            var deferred = $q.defer();
            var filtered = $filter('filter')(getAllCredentials(), { email: credentials.email, password: credentials.password });    
            var creds = filtered.length ? filtered[0] : null;      
            if(creds === null){
                deferred.reject("401 unauthorized");
              
            }else{
                var user ={username:credentials.email, personId: 1 };
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