(function () {
    'use strict';
 
    angular
        .module('blog')
        .factory('PostService', PostService);
 
    PostService.$inject = ['$sessionStorage', '$filter', '$q'];
    function PostService($sessionStorage, $filter, $q) {
 
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
            deferred.resolve(getPosts());
            return deferred.promise;
        }
        
        
 
        function findById(id) {
            var deferred = $q.defer();
            var filtered = $filter('filter')(getPosts(), { id: id });
            var post = filtered.length ? filtered[0] : null;
            deferred.resolve(post);
            return deferred.promise;
        }

        function add(post){
            getPosts().push(post);
        }
      
        function remove(post){
            var index = 0;
            var found = false;
            getPosts().forEach(function(p){
                if(p.id === post.id){
                    found = true;
                }
                index++;
            });
            if(found){
                getPosts().splice(index,1);
            }
            
        }

        function update(post){
            var index = 0;
            var found = false;
            getPosts().forEach(function(p){
                if(p.id === post.id){
                    found = true;
                }
                index++;
            });

            if(found){
                getPosts().splice(index,1,post);
            }
            
        }

 
        // private functions
 
        function getPosts() {
    
            return $sessionStorage.posts;
        }
 
        
    }
})();