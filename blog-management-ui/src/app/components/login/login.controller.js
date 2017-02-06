(function () {
  'use strict';

   
  angular.module('blog').controller('LoginCtrl', LoginCtrl);

  LoginCtrl.$inject = ['UserService','Principal','$log','$location'];
  function LoginCtrl(UserService, Principal, $log, $location) {
    var vm = this;
    
    vm.login = login;

    /*
     * PUBLIC METHODS
     */
    function login() {
      vm.error = null;
      $log.debug("credentials:", vm.credentials);
      UserService.getByCredentials(vm.credentials)
        .then(function(user){
          $log.debug("user: ",user);
          //create JWT, at the moment this is a mock
          var signedJWT = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJPbmxpbmUgSldUIEJ1aWxkZXIiLCJpYXQiOjE0ODYwMzgzNTMsImV4cCI6MTUxNzU3NDM1MywiYXVkIjoid3d3LmV4YW1wbGUuY29tIiwic3ViIjoidGVzdGVyQHRlc3QuYmUiLCJHaXZlbk5hbWUiOiJKb2hubnkiLCJTdXJuYW1lIjoiUm9ja2V0IiwiRW1haWwiOiJqcm9ja2V0QGV4YW1wbGUuY29tIiwiUm9sZSI6WyJNYW5hZ2VyIiwiUHJvamVjdCBBZG1pbmlzdHJhdG9yIl19.uVD8JIYbRh0VlrsLyKnAG22LrHd0R3bJk9KCx2RVveM";
          Principal.create(signedJWT);
          $location.path( "/posts" );
        })
        .catch(function(error){
          $log.debug("error: ",error );
          vm.error = error;
        });

    }


  }

})();