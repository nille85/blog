(function () {
  'use strict';

   
  angular.module('blog').controller('PublishPostCtrl', PublishPostCtrl);

  PublishPostCtrl.$inject = ['PostService', '$log'];
  function PublishPostCtrl(PostService, $log) {
    var vm = this;
   
    vm.post;

    vm.publish = publish;
    
    PostService.registerObserverCallback(reload);

    function publish(){
      PostService.publish(vm.post , function(p){
            vm.published = true;
      });
    }

    function reload(){
      vm.post = PostService.get();
    }




 
  }

})();