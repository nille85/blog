(function () {
    'use strict';

     angular
        .module('blog').service('AuthorizationService', AuthorizationService);
 
    AuthorizationService.$inject = ['$sessionStorage', 'jwtHelper'];

    function AuthorizationService($sessionStorage, jwtHelper) {


        
        var principal = null;

        var
        clearPrincipal = function() {
         principal = null;
        },

        setPrincipal = function(jwt) {
          principal = jwtHelper.decodeToken(jwt);
          
        },
        getPrincipal = function(){
            return principal;
        },

        isAuthorized = function(){

          return principal !== null;
        };

        return {
          isAuthorized: isAuthorized,
          setPrincipal: setPrincipal,
          clearPrincipal: clearPrincipal,
          getPrincipal : getPrincipal
        };
      };



})();