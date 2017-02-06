(function () {
  'use strict';

   
  angular.module('blog').controller('OverviewCategoryCtrl', OverviewCategoryCtrl);

  OverviewCategoryCtrl.$inject = ['CategoryService', '$log', '$location'];
  function OverviewCategoryCtrl(CategoryService, $log, $location) {
    var vm = this;
   
    loadCategories();

    vm.add = add;
    vm.remove = remove;
   
    function add(category){
      var copy = angular.copy(category);

      $log.debug("category:",category);
      CategoryService.add(copy)
        .then(function(c){
          $log.debug("category added:" + c);

        });

    }


    function remove(category){
      CategoryService.remove(category)
        .then(function(found){
          $log.debug(found);
          loadCategories();
        });
    }



    function loadCategories(){
      CategoryService.findAll()
                    .then(function(categories){
                      vm.categories = categories;
                      $log.debug(categories);
                    });
    }

    

  }

})();