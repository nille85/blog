(function () {
  'use strict';

   
  angular.module('blog').controller('AddPostCtrl', AddPostCtrl);

  AddPostCtrl.$inject = ['CategoryService','PostService', '$log', '$filter'];
  function AddPostCtrl(CategoryService, PostService, $log, $filter) {
    var vm = this;
   
    vm.add = add;
    vm.publish = publish;
   
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
            $log.debug(p);
        });
    }

 


    function publish(){
       $log.debug("publishing ...");
    }


  }

})();