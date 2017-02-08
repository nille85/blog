(function () {
    'use strict';
 
    angular
        .module('blog')
        .factory('CategoryService', CategoryService);
 
    CategoryService.$inject = ['$sessionStorage','$log'];
    function CategoryService($sessionStorage, $log) {
 
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