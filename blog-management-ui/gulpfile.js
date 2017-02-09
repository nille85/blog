var gulp = require('gulp');


var paths = {
 scripts: ['src/**/*.js','!src/**/*test.js',"!src/config/**/*.js"],
 html: ['src/**/*.html'],
 css: ['src/**/*.css'],
 bower: ['bower_components/**/*.js', 'bower_components/**/*.css'], 
 dist: 'dist/'
};

gulp.task('default', ['buildmock'], function(){
	console.log('Build is finished ...');
});




var requireDir = require('require-dir');
requireDir('./gulp-tasks');



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
     gulp.watch('src/**/*', ['buildmock']);
});







  







