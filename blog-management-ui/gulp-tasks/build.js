var constants = {
  scriptFile: 'src/config/scripts.js',
  environments: {
    mock:{
      scriptFile: 'src/config/mock/scripts.js'
    },  
    development: {
      apiHost: 'http://localhost:8000'
    },
    staging: {
      apiHost: 'http://staging.example.com/api/'
    },
    production: {
      apiHost: 'http://example.com/api/'
    }
  }
};

var gulp = require('gulp');


gulp.task('buildmock',['copy'], function(){
   var injection = new ScriptInjection(constants);
   return injection.execute('mock');
});


var ScriptInjection = function(configuration){


  this.execute = execute;

  function execute(environment){
    var scriptFiles = [configuration.scriptFile];
    var env = configuration.environments[environment];
  
    if(env){
       scriptFiles.push(env.scriptFile);
    }
   

    var fs = require("fs");
   
    var os = require("os");


    var scriptsToInject = 
      scriptFiles.map(function(scriptFile){
          var fileData = fs.readFileSync(scriptFile, "utf-8");    
          var scriptsArray = eval(fileData);
          var result =  reduceScriptsArray(scriptsArray);
         
          return result;
           
      }).reduce(function(first,second){
          return first + "\n" + second;
      });


      console.log("Injecting script:\n" + scriptsToInject);
      replaceInHtml(scriptsToInject);


  }

  function replaceInHtml(scriptsToInject){
    var inject = require('gulp-inject-string');
    gulp.src('dist/index.html')
        .pipe(inject.after('<!--BEGIN ANGULAR SCRIPTS-->',"\n" + scriptsToInject))
        .pipe(gulp.dest('dist'));
  }


  function reduceScriptsArray(scripts){   
    var result  = scripts.map(function(script){
              return "\t<script src=\""+ script + "\"></script>";
           }).reduce(function(first,second){
              return first + "\n" + second;
           });

    return result;
  };

};






