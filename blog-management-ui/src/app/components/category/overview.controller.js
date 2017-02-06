(function () {
  'use strict';

   
  angular.module('blog').controller('OverviewCategoryCtrl', OverviewCategoryCtrl);

  OverviewCategoryCtrl.$inject = ['CategoryService', '$log', '$location'];
  function OverviewCategoryCtrl(CategoryService, $log, $location) {
    var vm = this;


   
    loadCategories();

    vm.add = add;
    vm.save = save;
    vm.remove = remove;
    
   
   

    function add() {
      vm.inserted = {
        description: ''
      };
      vm.categories.push(vm.inserted);
    };

  
   

    function save(category, id){
    //$scope.user not updated yet
      if(id){
         angular.extend(category, {id: id});
          CategoryService.update(category)
            .then(function(category){
              $log.debug("success");
              $log.debug("category", category);
            });
      }else{
        CategoryService.add(category)
        .then(function(c){
          $log.debug("category added:", c);
          vm.inserted.id = c.id;
        });
      }
   
    }


    function remove(category){
      CategoryService.remove(category)
        .then(function(found){
          $log.debug(found);
          loadCategories();
        });
    }


     /*
    function add(category){
      var copy = angular.copy(category);

      $log.debug("category:",category);
      CategoryService.add(copy)
        .then(function(c){
          $log.debug("category added:" + c);

        });

    }*/

    
    /*
    function update(){
      CategoryService.update(vm.editCategory)
        .then(function(){
          vm.editCategory = null;
          loadCategories();
        });
    }*/



    function loadCategories(){
      CategoryService.findAll()
                    .then(function(categories){
                      vm.categories = categories;
                      $log.debug(categories);
                    });
    }


    

  }

})();