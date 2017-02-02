(function () {
  'use strict';

   
  angular.module('blog').controller('OverviewCtrl', OverviewCtrl);

  OverviewCtrl.$inject = ['jwtHelper', '$localStorage', '$log'];
  function OverviewCtrl(jwtHelper, $localStorage, $log) {
    var vm = this;
   
   	doSomething();


    function doSomething(){
    	var user = jwtHelper.decodeToken($localStorage.token);
    	$log.debug("user:", user);
    }

  }

})();