一、grunt 和 gulp 的区别:
	1、grunt: Grunt主要是以文件为媒介来运行它的工作流的,需要频繁的建立临时文件.
	2、gulp: 使用的是Nodejs中的stream(流).
gulp.task();用来定义任务，内部使用的是Orchestrator，
	1、基本语法: gulp.task(name[, deps], fn);
		1.1、name 为任务名
		1.2、deps 是当前定义的任务需要依赖的其他任务，为一个数组。当前定义的任务会在所有依赖的任务执行完毕后才开始执行。如果没有依赖，则可省略这个参数
		1.3、fn 为任务函数，我们把任务要执行的代码都写在里面。该参数也是可选的。
				gulp.task('mytask', ['array', 'of', 'task', 'names'], function() { 
					//定义一个有依赖的任务
		  		// Do something
				});
		1.4、gulp中执行多个任务，可以通过任务依赖来实现。
				//只要执行default任务，就相当于把one,two,three这三个任务执行了
				gulp.task('default',['one','two','three']);
		1.5、gulp不会等待异步的依赖任务执行完毕之后再继续往下执行.
		1.6、异步任务的执行顺序控制:
			第一：在异步操作完成后执行一个回调函数来通知gulp这个异步任务已经完成,这个回调函数就是任务函数的第一个参数。
				gulp.task('one',function(cb){ //cb为任务函数提供的回调，用来通知任务已经完成
				  //one是一个异步执行的任务
				  setTimeout(function(){
				    console.log('one is done');
				    cb();  //执行回调，表示这个异步任务已经完成
				  },5000);
				});
				//这时two任务会在one任务中的异步操作完成后再执行
				gulp.task('two',['one'],function(){
				  console.log('two is done');
				});
			第二：定义任务时返回一个流对象。适用于任务就是操作gulp.src获取到的流的情况。
				gulp.task('one',function(cb){
				  var stream = gulp.src('client/**/*.js')
				      .pipe(dosomething()) //dosomething()中有某些异步操作
				      .pipe(gulp.dest('build'));
				    return stream;
				});
				gulp.task('two',['one'],function(){
				  console.log('two is done');
				});
			第三：返回一个promise对象。
				//一个著名的异步处理的库 https://github.com/kriskowal/q
				var Q = require('q'); 
				gulp.task('one',function(cb){
				  var deferred = Q.defer();
				  // 做一些异步操作
				  setTimeout(function() {
				     deferred.resolve();
				  }, 5000);
				  return deferred.promise;
				});

				gulp.task('two',['one'],function(){
				  console.log('two is done');
				});
gulp.src();获取一个虚拟文件对象流(Vinyl files)，这个虚拟文件对象中存储着原始文件的路径、文件名、内容等信息。
	1、基本语法: gulp.src(globs[, options]);
		1.1、globs参数是文件匹配模式(类似正则表达式)，用来匹配文件路径(包括文件名)，当然这里也可以直接指定某个具体的文件路径。
				当有多个匹配模式时，该参数可以为一个数组。
			1、* 匹配文件路径中的0个或多个字符，但不会匹配路径分隔符，除非路径分隔符出现在末尾.
				 * 能匹配 a.js,x.y,abc,abc/,但不能匹配a/b.js
				 *.* 能匹配 a.js,style.css,a.b,x.y
				 */*/*.js 能匹配 a/b/c.js,x/y/z.js,不能匹配a/b.js,a/b/c/d.js       */
			2、** 匹配路径中的0个或多个目录及其子目录,需要单独出现，即它左右不能有其他东西了。如果出现在末尾，也能匹配文件。
				 ** 能匹配 abc,a/b.js,a/b/c.js,x/y/z,x/y/z/a.b,能用来匹配所有的目录和文件
				 **/*.js 能匹配 foo.js,a/foo.js,a/b/foo.js,a/b/c/foo.js            */
				 a/**/z 能匹配 a/z,a/b/z,a/b/c/z,a/d/g/h/j/k/z
				 a/**b/z 能匹配 a/b/z,a/sb/z,但不能匹配a/x/sb/z,因为只有单**单独出现才能匹配多级目录    */
			3、? 匹配文件路径中的一个字符(不会匹配路径分隔符);
				 ?.js 能匹配 a.js,b.js,c.js
				 a?? 能匹配 a.b,abc,但不能匹配ab/,因为它不会匹配路径分隔符
			4、[...] 匹配方括号中出现的字符中的任意一个，当方括号中第一个字符为^或!时，
						则表示不匹配方括号中出现的其他字符中的任意一个，类似js正则表达式中的用法.
					[xyz].js 只能匹配 x.js,y.js,z.js,不会匹配xy.js,xyz.js等,整个中括号只代表一个字符
					[^xyz].js 能匹配 a.js,b.js,c.js等,不能匹配x.js,y.js,z.js
			5、!(pattern|pattern|pattern) 匹配任何与括号中给定的任一模式都不匹配的
			6、?(pattern|pattern|pattern) 匹配括号中给定的任一模式0次或1次，类似于js正则中的(pattern|pattern|pattern)?
			7、+(pattern|pattern|pattern) 匹配括号中给定的任一模式至少1次，类似于js正则中的(pattern|pattern|pattern)+
			8、*(pattern|pattern|pattern) 匹配括号中给定的任一模式0次或多次，类似于js正则中的(pattern|pattern|pattern)*
			9、@(pattern|pattern|pattern) 匹配括号中给定的任一模式1次，类似于js正则中的(pattern|pattern|pattern)
			10、当有多种匹配模式时可以使用数组;
				//使用数组的方式来匹配多种文件
				gulp.src(['js/*.js','css/*.css','*.html']);
				例: gulp.src([*.js,'!b*.js']) //匹配所有js文件，但排除掉以b开头的js文件
						gulp.src(['!b*.js',*.js]) //不会排除任何文件，因为排除模式不能出现在数组的第一个元素中
			11、展开模式以花括号作为定界符;
				a{b,c}d 会展开为 abd,acd
				a{b,}c 会展开为 abc,ac
				a{0..3}d 会展开为 a0d,a1d,a2d,a3d
				a{b,c{d,e}f}g 会展开为 abg,acdfg,acefg
				a{b,c}d{e,f}g 会展开为 abdeg,acdeg,abdfg,acdfg
		1.2、options为可选参数。通常情况下我们不需要用到。
gulp.dest();方法是用来写文件的.
	1、基本语法: gulp.dest(path[,options]);
		1.1、path为写入文件的路径
		1.2、options为一个可选的参数对象，通常我们不需要用到
		1.3、gulp 的使用流程:
			1、首先通过gulp.src()方法获取到我们想要处理的文件流，
			2、然后把文件流通过pipe方法导入到gulp的插件中，
			3、最后把经过插件处理后的流再通过pipe方法导入到gulp.dest()中,
			4、gulp.dest()方法则把流中的内容写入到文件中，只能指定生成的目录名,
			5、如果要改变文件名字,请使用gulp-rename插件,
			例: var gulp = require('gulp');
					gulp.src('script/jquery.js').pipe(gulp.dest('dist/foo.js'));
					//最终生成的文件路径为 dist/foo.js/jquery.js,而不是dist/foo.js
			例: gulp.src('script/avalon/avalon.js').pipe(gulp.dest('dist')); 
					//没有通配符出现的情况
					//最后生成的文件路径为 dist/avalon.js
			例:	//有通配符开始出现的那部分路径为 **/underscore.js
					gulp.src('script/**/underscore.js').pipe(gulp.dest('dist'));
			  	//假设匹配到的文件为script/util/underscore.js
			  	//则最后生成的文件路径为 dist/util/underscore.js
			例:	//有通配符出现的那部分路径为 *
					gulp.src('script/*').pipe(gulp.dest('dist')); 
				   	//假设匹配到的文件为script/zepto.js    
			   	//则最后生成的文件路径为 dist/zepto.js
			例: gulp.src('app/src/**/*.css').pipe(gulp.dest('dist')); 
					//此时base的值为app/src,也就是说它的base路径为app/src
			    //设该模式匹配到了文件 app/src/css/normal.css
			    //用dist替换掉base路径，最终得到 dist/css/normal.css
			例: gulp.src(script/lib/*.js).pipe(gulp.dest('build')) */
					//没有配置base参数，此时默认的base路径为script/lib
			  	//假设匹配到的文件为script/lib/jquery.js
			   	//生成的文件路径为 build/jquery.js
			例: gulp.src(script/lib/*.js, {base:'script'}).pipe(gulp.dest('build')) */
					//配置了base参数，此时base路径为script
			  	//假设匹配到的文件为script/lib/jquery.js
			   	//此时生成的文件路径为 build/lib/jquery.js  
gulp.watch();用来监视文件的变化，当文件发生变化后，我们可以利用它来执行相应的任务.
	1、基本语法: gulp.watch(glob[, opts], tasks);
		1.1、glob 为要监视的文件匹配模式，规则和用法与gulp.src()方法中的glob相同。
		1.2、opts 为一个可选的配置对象，通常不需要用到
		1.3、tasks 为文件变化后要执行的任务，为一个数组
		gulp.task('uglify',function(){
		  //do something
		});
		gulp.task('reload',function(){
		  //do something
		});
		gulp.watch('js/**/*.js', ['uglify','reload']);
		gulp.watch('js/**/*.js', function(event){
    	console.log(event.type); //变化类型 added为新增,deleted为删除，changed为改变 
    	console.log(event.path); //变化的文件的路径
		}); 
gulp常用的插件:
	1、自动加载插件: gulp-load-plugins
	2、重命名: gulp-rename
		var gulp = require('gulp'),
    		rename = require('gulp-rename'),
    		uglify = require("gulp-uglify");
		gulp.task('rename', function () {
		    gulp.src('js/jquery.js')
		    .pipe(uglify())  //压缩
		    .pipe(rename('jquery.min.js')) //会将jquery.js重命名为jquery.min.js
		    .pipe(gulp.dest('js'));
		    //关于gulp-rename的更多强大的用法请参考https://www.npmjs.com/package/gulp-rename
		});
	3、js文件压缩: gulp-uglify
		var gulp = require('gulp'),
    		uglify = require("gulp-uglify");
		gulp.task('minify-js', function () {
		    gulp.src('js/*.js') // 要压缩的js文件
		    .pipe(uglify())  //使用uglify进行压缩,更多配置请参考：
		    .pipe(gulp.dest('dist/js')); //压缩后的路径
		});
	4、css文件压缩: gulp-minify-css //gulp-clean-css
		var gulp = require('gulp'),
    		minifyCss = require("gulp-minify-css");
		gulp.task('minify-css', function () {
		    gulp.src('css/*.css') // 要压缩的css文件
		    .pipe(minifyCss({
			    	advanced: true,//类型：Boolean 默认：true [是否开启高级优化（合并选择器等）]
	          compatibility: 'ie7',//保留ie7及以下兼容写法 类型：String 默认：''or'*' [启用兼容模式； 'ie7'：IE7兼容模式，'ie8'：IE8兼容模式，'*'：IE9+兼容模式]
	          keepBreaks: true,//类型：Boolean 默认：false [是否保留换行]
	          keepSpecialComments: '*'
            //保留所有特殊前缀 当你用autoprefixer生成的浏览器前缀，如果不加这个参数，有可能将会删除你的部分前缀
		    })) //压缩css
		    .pipe(gulp.dest('dist/css'));
		});
	5、html文件压缩: gulp-minify-html
		var gulp = require('gulp'),
    		minifyHtml = require("gulp-minify-html");
		gulp.task('minify-html', function () {
		    gulp.src('html/*.html') // 要压缩的html文件
		    .pipe(minifyHtml()) //压缩
		    .pipe(gulp.dest('dist/html'));
		});
	6、js文件校验: gulp-jshint //npm install jshint gulp-jshint --save-dev
		var gulp = require('gulp'),
    		jshint = require("gulp-jshint");
		gulp.task('jsLint', function () {
		    gulp.src('js/*.js')
		    .pipe(jshint())
		    .pipe(jshint.reporter()); // 输出检查结果
		});
	7、文件合并: gulp-concat
		var gulp = require('gulp'),
    		concat = require("gulp-concat");
		gulp.task('concat', function () {
		    gulp.src('js/*.js')  //要合并的文件
		    .pipe(concat('all.js'))  // 合并匹配到的js文件并命名为 "all.js"
		    .pipe(gulp.dest('dist/js'));
		});
	8、less和sass的预编译: gulp-sass
		var gulp = require('gulp'),
    		less = require("gulp-less");
		gulp.task('compile-less', function () {
		    gulp.src('less/*.less')
		    .pipe(less())
		    .pipe(gulp.dest('dist/css'));
		});
		var gulp = require('gulp'),
    		sass = require("gulp-sass");
		gulp.task('compile-sass', function () {
		    gulp.src('sass/*.sass')
		    .pipe(sass())
		    .pipe(gulp.dest('dist/css'));
		});
	9、图片压缩: gulp-imagemin
		var gulp = require('gulp');
		var imagemin = require('gulp-imagemin');
		var pngquant = require('imagemin-pngquant'); //png图片压缩插件
		gulp.task('default', function () {
	    return gulp.src('src/images/*')
	        .pipe(imagemin({
	            progressive: true,
	            use: [pngquant()] //使用pngquant来压缩png图片
	        }))
	        .pipe(gulp.dest('dist'));
		});
	10、自动刷新: gulp-livereload
		var gulp = require('gulp'),
    		less = require('gulp-less'),
    		livereload = require('gulp-livereload');
		gulp.task('less', function() {
		  gulp.src('less/*.less')
		    .pipe(less())
		    .pipe(gulp.dest('css'))
		    .pipe(livereload());
		});
		gulp.task('watch', function() {
		  livereload.listen(); //要在这里调用listen()方法
		  gulp.watch('less/*.less', ['less']);
		});
	11、自动补全: gulp-autoprefixer
		var autoprefixer = require("gulp-autoprefixer");
		gulp.task('sass', function() {
    gulp.src('public/stylesheets/*.scss',{base:"public/stylesheets"})
        .pipe(sass())
        .pipe(autoprefixer({
           	// browsers: ['last 2 versions', 'Android >= 4.0'],
            cascade: true, //是否美化属性值 默认：true 像这样：
            //-webkit-transform: rotate(45deg);
            //        transform: rotate(45deg);
            remove:true //是否去掉不必要的前缀 默认：true 
        }))
        .pipe(gulp.dest('public/stylesheets'));
		});



		