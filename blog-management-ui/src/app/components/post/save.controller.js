(function () {
  'use strict';

   
  angular.module('blog').controller('SavePostCtrl', SavePostCtrl);

  SavePostCtrl.$inject = ['CategoryRepository','PostRepository', '$log', '$filter', '$routeParams'];
  function SavePostCtrl(CategoryRepository, PostRepository, $log, $filter, $routeParams) {
    var vm = this;
   
    vm.save = save;

    loadPost();
   
   	loadCategories();

    function loadCategories(){
      CategoryRepository.findAll()
                    .then(function(categories){
                      vm.categories = categories;
                     
                    });
    }

    function loadPost(){
      var postId = $routeParams.postId;
      if(postId){
	      PostRepository.findById(postId)
	        .then(function(post){
	          vm.post = post;
	        });
	   }else{
	   	vm.post = {};
	   }
    }

    function save(){
      var post = angular.copy(vm.post);
      $log.debug("post id:", post);
      post.markdown = $filter('markdown')(post.text);
      $log.debug(post);
      var promise;
      if (!post.id){
     	  promise = add(post);
      }else{
     	  promise = update(post);
      }
      promise.then(function(p){
      	vm.saved = {status : "saved"};
      });
    }

    function add(post){
    	$log.debug("adding ...");
      return PostRepository.add(post)
        .then(function(p){
            return p;
      });
    }

     function update(post){
     	$log.debug("updating ...");
     	return PostRepository.update(post)
        .then(function(p){
            return p;
      });
     }





  }

})();
