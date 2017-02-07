(function () {
  'use strict';

   
  angular.module('blog').controller('NavigationLeftCtrl', NavigationLeftCtrl);

  NavigationLeftCtrl.$inject = ['Principal', '$log', '$location'];
  function NavigationLeftCtrl(Principal,$log, $location) {
    var vm = this;
   
    vm.principal = Principal;
   
    vm.getClass = getClass;

   

    function getClass(path){
   
      return ($location.path().substr(0, path.length) === path) ? 'active' : '';
    }


    
   

  }

})();