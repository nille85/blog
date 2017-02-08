(function () {
    'use strict';

     angular
        .module('blog').service('Principal', Principal);
 
    Principal.$inject = ['jwtHelper','$localStorage'];

    function Principal(jwtHelper,$localStorage) {

        
        var principal = null;

        var
        clear = function() {
         delete $localStorage.token;
         principal = null;
        },

        create = function(jwt) {
          $localStorage.token = jwt;
          principal = jwtHelper.decodeToken(jwt);
          
        },
        get = function(){
          return principal;
        },

        exists = function(){
           return principal !== null;
        };

        return {
          exists: exists,
          create: create,
          clear: clear,
          get : get
        };
      };



})();