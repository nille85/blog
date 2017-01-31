(function () {
  'use strict';

   
  angular.module('blog').controller('LoginCtrl', LoginCtrl);

  LoginCtrl.$inject = [];
  function LoginCtrl() {
    var vm = this;
    
    vm.login = login;  


    /*
     * PUBLIC METHODS
     */
    function login() {
      alert("logging in");
    }


  }

})();