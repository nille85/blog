(function () {
    'use strict';
 
    angular
        .module('blog')
        .factory('CategoryService', CategoryService);
 
    CategoryService.$inject = ['$sessionStorage', '$filter', '$q','$log'];
    function CategoryService($sessionStorage, $filter, $q, $log) {
 
        var service = {};
 

        service.findAll = findAll;
        service.findById = findById;
        service.add = add;
        service.update = update;
        service.remove = remove;
       
        return service;
        
        //public functions
        function findAll() {
            var deferred = $q.defer();
            deferred.resolve(getCategories());
            return deferred.promise;
        }
        
        
 
        function findById(id) {
            var deferred = $q.defer();
            var filtered = $filter('filter')(getCategories(), { id: id });
            var post = filtered.length ? filtered[0] : null;
            deferred.resolve(post); 
            return deferred.promise;
        }

        function add(category){
            var deferred = $q.defer();
            category.id = Number(getCategories()[getCategories().length -1].id) + 1;
            getCategories().push(category);
            $log.debug(getCategories());
            deferred.resolve(category);
            return deferred.promise;
        }
      
        function remove(category){

            var index;
            
            //breaks when predicate returns true
            getCategories().some(function(c,i) {
                index = i;
                return c.id == category.id
            });
            $log.debug("found category", index);
            getCategories().splice(index,1);
          

            var deferred = $q.defer();
            deferred.resolve(true);
            return deferred.promise;
            
        }

        function update(category){
           var index;
            
            //breaks when predicate returns true
            getCategories().some(function(c,i) {
                index = i;
                return c.id == category.id
            });

          
            getCategories().splice(index,1,category);
            
            
        }

 
        // private functions
 
        function getCategories() {
    
            return $sessionStorage.categories;
        }
 
        
    }
})();