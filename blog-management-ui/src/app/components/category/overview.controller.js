(function () {
  'use strict';

   
  angular.module('blog').controller('OverviewCategoryCtrl', OverviewCategoryCtrl);

  OverviewCategoryCtrl.$inject = ['CategoryRepository', '$log', '$location'];
  function OverviewCategoryCtrl(CategoryRepository, $log, $location) {
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
      if(id){
         angular.extend(category, {id: id});
          CategoryRepository.update(category)
            .then(function(category){
              $log.debug("success");
              $log.debug("category", category);
            });
      }else{
        CategoryRepository.add(category)
        .then(function(c){
          $log.debug("category added:", c);
          vm.inserted.id = c.id;
        });
      }
   
    }


    function remove(category){
      CategoryRepository.remove(category)
        .then(function(found){
          $log.debug(found);
          loadCategories();
        });
    }



    function loadCategories(){
      CategoryRepository.findAll()
                    .then(function(categories){
                      vm.categories = categories;
                      $log.debug(categories);
                    });
    }


    

  }

})();