(function(){
	 'use strict';
	 angular.module('blog').directive('paging', paging);
	 

	 paging.$inject = [];
	 function paging(){

	 	var directive = {};

	 	directive.restrict = 'E'; /* restrict this directive to elements */
	 	directive.templateUrl = "/app/directives/paging-template.html";
	 	directive.scope = {
	        pageNumber : "=pageNumber",
	        itemsPerPage : "=itemsPerPage",
	        totalItems : "=totalItems",
	        pageFunction : "=pageFunction",
	        entities : "=entities"

	    }

        directive.compile = function(element, attributes) {
        // do one-time configuration of element.

	        var linkFunction =function(scope, element, attrs) {
            
	            scope.$watch(
			        function(scope) {
			        	
			            return(scope.pageNumber);
			        },
			        function handleChange( newPage, oldPage ) {

			            alert("loading a new page: " +newPage);
			            scope.pageFunction(scope.pageNumber, scope.itemsPerPage)
			            .then(function(entities){
			                scope.entities = entities;
			            });
			        }
	    		);
 
            
       		};

	        return linkFunction;
	    }
 
	 	return directive;


	 }

})();







