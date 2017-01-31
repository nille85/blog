var gulp = require('gulp');


var paths = {
 scripts: ['src/**/*.js','!src/**/*test.js'],
 html: ['src/**/*.html'],
 bower: ['bower_components/**/*.js', 'bower_components/**/*.css'], 
 dist: 'dist/'
};

gulp.task('default', ['build'], function(){
	console.log('Build is finished ...');
});

gulp.task('build', ['clean'], function(){

	var stream = gulp.src(paths.scripts.concat(paths.html))
 		.pipe(gulp.dest(paths.dist));
 	
 	return stream.on('end', function() {
    	//run some code here
    	return gulp.src(paths.bower)
  		.pipe(gulp.dest(paths.dist + 'public/vendor/'))
  	});

  	
});


var clean = require('gulp-clean');

gulp.task('clean',function(){
	 return gulp.src('dist',{force: true})
        .pipe(clean());
});