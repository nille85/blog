(function () {
  'use strict';

   
  angular.module('blog').controller('OverviewPostCtrl', OverviewPostCtrl);

  OverviewPostCtrl.$inject = ['PostRepository', 'PostService', '$log'];
  function OverviewPostCtrl(PostRepository, PostService, $log) {
    var vm = this;
   
    vm.pageNumber = 1;
    vm.itemsPerPage = 3;
    
    getCount();
    

    vm.remove = remove;
    vm.loadPosts = loadPosts;
   
    vm.loadPostById = loadPostById;



    function remove(post){
      $log.debug("removing post", post);
      PostRepository.remove(post)
        .then(function(success){
         
          loadPosts(vm.pageNumber, vm.itemsPerPage)
           .then(function(posts){
              vm.posts = posts;
           });
        });
    }

    function getCount(){
      PostRepository.getTotalCount()
              .then(function(count){
                vm.count = count;
              });
    }


    function loadPostById(postId){
      PostService.load(postId, function(loaded){
          $log.debug(loaded);
          alert(loaded.id);
      });
    }



    function loadPosts(pageNumber,itemsPerPage){
       return PostRepository.findByPage(pageNumber,itemsPerPage)
                    .then(function(posts){
                        return posts;
                    });
    }

 
  }

})();