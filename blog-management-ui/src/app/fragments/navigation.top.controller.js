(function () {
  'use strict';

   
  angular.module('blog').controller('NavigationTopCtrl', NavigationTopCtrl);

  NavigationTopCtrl.$inject = ['Principal', '$log'];
  function NavigationTopCtrl(Principal,$log) {
    var vm = this;
   
    vm.logOff = logOff;
    vm.principal = Principal;


    function logOff(){
      Principal.clear();
      alert("logging off");
    }

    

  }

})();