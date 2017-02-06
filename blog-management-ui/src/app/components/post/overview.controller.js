(function () {
  'use strict';

   
  angular.module('blog').controller('OverviewPostCtrl', OverviewPostCtrl);

  OverviewPostCtrl.$inject = ['PostService', '$log', '$location'];
  function OverviewPostCtrl(PostService, $log, $location) {
    var vm = this;
   
    loadPosts();

    vm.gotoAddPost = gotoAddPost;


    function loadPosts(){
       PostService.findAll()
                    .then(function(posts){
                      vm.posts = posts;
                    });
    }

    function gotoAddPost(){
      $location.path("/posts/add");
    }

    

  }

})();