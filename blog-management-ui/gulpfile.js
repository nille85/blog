var gulp = require('gulp');


var paths = {
 scripts: ['src/**/*.js','!src/**/*test.js'],
 html: ['src/**/*.html'],
 css: ['src/**/*.css'],
 bower: ['bower_components/**/*.js', 'bower_components/**/*.css'], 
 dist: 'dist/'
};

gulp.task('default', ['build'], function(){
	console.log('Build is finished ...');
});


gulp.task('build',['copy'], function(){
    var fs = require("fs");
    var inject = require('gulp-inject-string');
    var os = require("os");

    fs.readFile("src/config/scripts.js", "utf-8", function(err, data) {     
       var scriptsArray = eval(data);
       var result =  reduceScripts(scriptsArray);
        gulp.src('dist/index.html')
        .pipe(inject.after('<!--BEGIN ANGULAR SCRIPTS-->', os.EOL + result))
        .pipe(gulp.dest('dist/'));
    })
  });


gulp.task('copy', ['clean'], function(){

	var stream = gulp.src(paths.scripts.concat(paths.html).concat(paths.css))
 		.pipe(gulp.dest(paths.dist))

 	return stream.on('end', function () { 
     return gulp.src(paths.bower)
      .pipe(gulp.dest(paths.dist + 'public/vendor/')); 

  });

  	  	
});


var clean = require('gulp-clean');

gulp.task('clean',function(){
	 return gulp.src('dist',{force: true})
        .pipe(clean());
});

// plugins
var connect = require('gulp-connect');


gulp.task('connect', function () {
  connect.server({
    root: 'dist/',
    port: 8888
  });
});




gulp.task('watch', function () { 
     gulp.watch('src/**/*', ['build']);
});




var reduceScripts = function(scripts){   
  var result  = scripts.map(function(script){
            return "\t<script src=\""+ script + "\"></script>";
         }).reduce(function(first,second){
            return first + "\n" + second;
         });

  return result;
};







