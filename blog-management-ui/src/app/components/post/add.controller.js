(function () {
  'use strict';

   
  angular.module('blog').controller('AddPostCtrl', AddPostCtrl);

  AddPostCtrl.$inject = ['CategoryService'];
  function AddPostCtrl(CategoryService) {
    var vm = this;
   
   	loadCategories();

    function loadCategories(){
      CategoryService.findAll()
                    .then(function(categories){
                      vm.categories = categories;
                     
                    });
    }


  }

})();