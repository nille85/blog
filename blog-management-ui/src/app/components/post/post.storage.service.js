(function () {
    'use strict';
 
    angular
        .module('blog')
        .factory('PostService', PostService);
 
    PostService.$inject = ['$sessionStorage', '$filter', '$q'];
    function PostService($sessionStorage, $filter, $q) {
 
        var service = {};
 
        service.getEntities = getEntities;
        service.processAdd = processAdd;
       
        return service;
        

        function processAdd(post){
            
            post.status = 'Draft';
            post.createdDate = new Date();
            return post;
        }
 
        function getEntities() {
            if(!$sessionStorage.posts){
                $sessionStorage.posts = [];
            }
            return $sessionStorage.posts; 
        }
 
        
    }
})();