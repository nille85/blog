(function () {
  'use strict';

   
  angular.module('blog').controller('EditPostCtrl', EditPostCtrl);

  EditPostCtrl.$inject = ['CategoryService','PostService', '$log', '$filter', '$routeParams'];
  function EditPostCtrl(CategoryService, PostService, $log, $filter, $routeParams) {
    var vm = this;
   
    vm.update = update;
    vm.publish = publish;

    loadPost($routeParams.postId);
   
   	loadCategories();

    function loadCategories(){
      CategoryService.findAll()
                    .then(function(categories){
                      vm.categories = categories;
                     
                    });
    }

    function loadPost(postId){
      PostService.findById(postId)
        .then(function(post){
          vm.post = post;
        });
    }

    function update(){
     
    }

 


    function publish(){
       $log.debug("publishing ...");
    }


  }

})();