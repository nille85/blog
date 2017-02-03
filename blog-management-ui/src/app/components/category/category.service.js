(function () {
    'use strict';
 
    angular
        .module('blog')
        .factory('CategoryService', CategoryService);
 
    CategoryService.$inject = ['$sessionStorage', '$filter', '$q'];
    function CategoryService($sessionStorage, $filter, $q) {
 
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

        function add(post){
            getCategories().push(post);
        }
      
        function remove(post){
            var index = 0;
            var found = false;
            getCategories().forEach(function(p){
                if(p.id === post.id){
                    found = true;
                }
                index++;
            });
            if(found){
                getCategories().splice(index,1);
            }
            
        }

        function update(post){
            var index = 0;
            var found = false;
            getCategories().forEach(function(p){
                if(p.id === post.id){
                    found = true;
                }
                index++;
            });

            if(found){
                getCategories().splice(index,1,post);
            }
            
        }

 
        // private functions
 
        function getCategories() {
    
            return $sessionStorage.categories;
        }
 
        
    }
})();