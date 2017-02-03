(function () {
  'use strict';

   
  angular.module('blog').controller('OverviewPostCtrl', OverviewPostCtrl);

  OverviewPostCtrl.$inject = ['PostService', '$log'];
  function OverviewPostCtrl(PostService, $log) {
    var vm = this;
   
    loadPosts();


    function loadPosts(){
      vm.posts = PostService.findAll()
                    .then(function(posts){
                      vm.posts = posts;
                    });
    }

    

  }

})();