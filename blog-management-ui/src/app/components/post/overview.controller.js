(function () {
  'use strict';

   
  angular.module('blog').controller('OverviewPostCtrl', OverviewPostCtrl);

  OverviewPostCtrl.$inject = ['PostService', '$log', '$location','$scope'];
  function OverviewPostCtrl(PostService, $log, $location, $scope) {
    var vm = this;
   
    vm.pageNumber = 1;
    vm.itemsPerPage = 3;
    
    getCount();
    

    vm.gotoAddPost = gotoAddPost;
    vm.remove = remove;
    vm.loadPosts = loadPosts;

    

    /*
    $scope.$watch(
        function(scope) {
            return(vm.pageNumber);
        },
        function handleChange( newPageNumber, oldPageNumber ) {
            loadPosts(newPageNumber,vm.itemsPerPage)
              .then(function(posts){
                vm.posts = posts;
              });
        }
    );*/

    


    function remove(post){
      PostService.remove(post)
        .then(function(success){
          loadPosts();
        });
    }

    function getCount(){
      PostService.getTotalCount()
              .then(function(count){
                vm.count = count;
              });
    }


    function loadPosts(pageNumber,itemsPerPage){
       return PostService.findByPage(pageNumber,itemsPerPage)
                    .then(function(posts){
                        return posts;
                    });
    }

    function gotoAddPost(){
      $location.path("/posts/add");
    }

    

  }

})();