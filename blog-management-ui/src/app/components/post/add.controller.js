(function () {
  'use strict';

   
  angular.module('blog').controller('AddPostCtrl', AddPostCtrl);

  AddPostCtrl.$inject = ['CategoryService','PostService', '$log', '$filter', '$route'];
  function AddPostCtrl(CategoryService, PostService, $log, $filter, $route) {
    var vm = this;
   
    vm.add = add;
    vm.publish = publish;
    vm.addAnotherPost = addAnotherPost;
   
   	loadCategories();

    function loadCategories(){
      CategoryService.findAll()
                    .then(function(categories){
                      vm.categories = categories;
                     
                    });
    }

    function add(){
      var post = angular.copy(vm.post);
      post.text =  $filter('markdown')(post.text);
      $log.debug(post);
      PostService.add(post)
        .then(function(p){
            vm.added = true;
        });
    }

    function addAnotherPost(){
       $route.reload();
    }

 


    function publish(){
       $log.debug("publishing ...");
    }


  }

})();