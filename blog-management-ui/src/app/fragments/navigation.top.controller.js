(function () {
  'use strict';

   
  angular.module('blog').controller('NavigationTopCtrl', NavigationTopCtrl);

  NavigationTopCtrl.$inject = ['$log'];
  function NavigationTopCtrl($log) {
    var vm = this;
   
    vm.logOff = logOff;


    function logOff(){
      alert("logging off");
    }

    

  }

})();