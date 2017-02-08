(function () {
    'use strict';
 
    angular
        .module('blog')
        .factory('StorageDecorator', StorageDecorator);
 
    StorageDecorator.$inject = ['$delegate', '$sessionStorage', '$filter', '$q', '$log'];
    function StorageDecorator($delegate, $sessionStorage, $filter, $q, $log) {
 
        var service = {};
 
        service.findAll = findAll;
        service.findById = findById;
        service.add = add;
        service.update = update;
        service.remove = remove;
       
        return service;
        
    

        function findAll() {
           
            var deferred = $q.defer();
            var copy = angular.copy(getEntities());
            deferred.resolve(copy);
            return deferred.promise;
        }

    
        function findById(id) {
            var deferred = $q.defer();
            var filtered = $filter('filter')(getEntities(), { id: id });
            var entity = filtered.length ? filtered[0] : null;
            deferred.resolve(entity); 
            return deferred.promise;
        }

        function add(entity){
            var deferred = $q.defer();
            var entities = getEntities();

            entity.id = getId(entities);
            if($delegate.processAdd){
               entity = $delegate.processAdd(entity);
            }
            entities.push(entity);
            deferred.resolve(entity);
            return deferred.promise;
        }



        function getId(array){
            $log.debug(array);

            var length = array.length;

            $log.debug(length);
            if(length != 0){
                return Number(array[length - 1].id) + 1;
            }
           
            return 1;
            
        }
      
        function remove(entity){

            var index;
            
            //breaks when predicate returns true
            getEntities().some(function(c,i) {
                index = i;
                return c.id == entity.id
            });
            $log.debug("found entity", index);
            getEntities().splice(index,1);
          

            var deferred = $q.defer();
            deferred.resolve(true);
            return deferred.promise;
            
        }

        function update(entity){
           var index;
            
            //breaks when predicate returns true
            getEntities().some(function(c,i) {
                index = i;
                return c.id == entity.id
            });

          
            getEntities().splice(index,1,entity);
            var deferred = $q.defer();
            deferred.resolve(entity);
            return deferred.promise;
            
            
        }

        
      
        

 
        // private functions
 
        function getEntities() {
            return $delegate.getEntities();
        }
 
        
    }


    angular.module("blog")
        .config(["$provide", function ($provide) {
            $provide.decorator("CategoryService", StorageDecorator);
            $provide.decorator("PostService", StorageDecorator);
    }]);


})();