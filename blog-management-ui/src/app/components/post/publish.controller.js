(function () {
  'use strict';

   
  angular.module('blog').controller('PublishPostCtrl', PublishPostCtrl);

  PublishPostCtrl.$inject = ['PostService', '$log'];
  function PublishPostCtrl(PostService, $log) {
    var vm = this;
   
    vm.postService = PostService;

    vm.publish = publish;
    


    function publish(){
      PostService.publish(vm.post , function(p){
            vm.published = true;
      });
    }
 
  }

})();