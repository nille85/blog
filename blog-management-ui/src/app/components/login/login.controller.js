(function () {
  'use strict';

   
  angular.module('blog').controller('LoginCtrl', LoginCtrl);

  LoginCtrl.$inject = ['AuthenticationService','$log'];
  function LoginCtrl(AuthenticationService, $log) {
    var vm = this;
    
    vm.login = login;  


    /*
     * PUBLIC METHODS
     */
    function login() {

      $log.debug("credentials:", vm.credentials);

    }


  }

})();