(function () {
    'use strict';
 
    angular
        .module('blog')
        .factory('PostRepository', PostRepository);
 
    PostRepository.$inject = ['$sessionStorage', '$filter', '$q'];
    function PostRepository($sessionStorage, $filter, $q) {
 
        var service = {};
 
        service.getEntities = getEntities;
        service.processAdd = processAdd;
        service.publish = publish;
       
        return service;
        

        function processAdd(post){
            
            post.status = 'Draft';
            post.createdDate = new Date();
            return post;
        }

        function publish(post){
            post.status = 'Published';
            var index;
            getEntities().some(function(c,i) {
                index = i;
                return c.id == post.id
            });

          
            getEntities().splice(index,1,post);
            var deferred = $q.defer();
            deferred.resolve(post);
            return deferred.promise;

        }
 
        function getEntities() {
            if(!$sessionStorage.posts){
                $sessionStorage.posts = [];
            }
            return $sessionStorage.posts; 
        }
 
        
    }
})();