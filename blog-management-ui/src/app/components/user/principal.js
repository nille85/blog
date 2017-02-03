(function () {
    'use strict';

     angular
        .module('blog').service('Principal', Principal);
 
    Principal.$inject = ['$sessionStorage', 'jwtHelper'];

    function Principal($sessionStorage, jwtHelper) {


        
        var principal = null;

        var
        clear = function() {
         principal = null;
        },

        create = function(jwt) {
          principal = jwtHelper.decodeToken(jwt);
          
        },
        get = function(){
            return principal;
        },

        isAuthorized = function(){

          return principal !== null;
        };

        return {
          isAuthorized: isAuthorized,
          create: create,
          clear: clear,
          get : get
        };
      };



})();