(function () {
    'use strict';
 
    angular
        .module('blog')
        .factory('CategoryRepository', CategoryRepository);
 
    CategoryRepository.$inject = ['$sessionStorage','$log'];
    function CategoryRepository($sessionStorage, $log) {
 
        var service = {};
 

        service.getEntities = getEntities;
        return service;
        
 
        function getEntities() {
            if(!$sessionStorage.categories){
                $log.debug("is empty");
                $sessionStorage.categories = [];
            }
            return $sessionStorage.categories; 
        }
 
        
    }
})();