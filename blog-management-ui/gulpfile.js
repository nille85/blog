// Include Gulp
var gulp = require('gulp');

// Include plugins
var plugins = require("gulp-load-plugins")({
	pattern: ['gulp-*', 'gulp.*', 'main-bower-files'],
	replaceString: /\bgulp[\-.]/
});

// Define default destination folder
var dest = 'src/public/';

gulp.task('js', function() {

	var jsFiles = ['js/*'];

	plugins.mainBowerFiles().forEach(function(file){
		console.log(file);
	});


	gulp.src(plugins.mainBowerFiles().concat(jsFiles))
		
		
		
		.pipe(gulp.dest(dest + 'js'));

});

gulp.task('css', function() {

	var cssFiles = ['css/*'];

	gulp.src(plugins.mainBowerFiles().concat(cssFiles))
		
	
		.pipe(gulp.dest(dest + 'css'));

});

// Default Task
gulp.task('build', ['js','css']);