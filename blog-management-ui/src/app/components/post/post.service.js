(function () {
    'use strict';
 
    angular
        .module('blog')
        .factory('PostService', PostService);
 
    PostService.$inject = ['PostRepository', '$log'];
    function PostService(PostRepository, $log) {
 
        var post;

        var service = this;

        service.publish = publish;
        service.load = load;
        service.get = get;

        var observerCallbacks = [];
        service.registerObserverCallback = function(callback){
            observerCallbacks.push(callback);
        };

       
        return service;
        

        function load(postId){
             PostRepository.findById(postId)
                .then(function(p){
                    post = p;
                    notifyObservers();
                 
            });
        }

        function notifyObservers(){
            angular.forEach(observerCallbacks, function(callback){
                $log.debug("notify observer:",callback);
              callback();
            });
          }

        function get(){
            return post;
        }

        function publish(){
            post.status = 'Published';
            PostRepository.update(post)
                .then(function(updatedPost){
                    $log.debug("published, coming from repository",updatedPost);
                    notifyObservers();
                    return updatedPost;
            });

        }



      
     
      
        
    }
})();