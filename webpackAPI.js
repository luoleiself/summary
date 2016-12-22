http://webpack.github.io/docs/
webpack描述:
	1.支持commonJS和AMD模块
	2.支持很多模块加载器的调用，可以使模块加载器灵活定制
	3.可以通过配置打包成多个文件，有效的利用浏览器的缓存功能提升性能
	4.使用模块加载器，可以支持sass，less等处理器进行打包且支持静态资源样式及图片进行打包
console:
	$ webpack --display-error-details		//显示错误详细信息
  $ webpack         // 最基本的启动webpack的方法
  $	webpack -w      // 提供watch方法；实时进行打包更新
  $ webpack -p      // 对打包后的文件进行压缩
  $ webpack -d      // 提供source map，方便调式代码
webpack参数:
	1.entry: 字符串|数组|对象 // string | object | array
		1.entry: "./app/entry",
  	2.entry: ["./app/entry1", "./app/entry2"],
  	3.entry: {
		    a: "./app/entry-a",
		    b: ["./app/entry-b1", "./app/entry-b2"]
		  },
		  // Here the application starts executing
		  // and webpack starts bundling
	2.output: 对象
		1.filename: "bundle.js", // string
	    filename: "[name].js", // for multiple entry points
	    filename: "[chunkhash].js", // for long term caching
	    // the filename template for entry chunks
	  2.path:文件存放路径
	  	path.resolve(__dirname, "dist"), // string
	  	// the target directory for all output files
	  	// must be an absolute path (use the Node.js path module)
	  3.publicPath: 指定了一个在浏览器中被引用的URL地址, 网站运行时的访问路径
	  	string|""|url// the url to the output directory resolved relative to the HTML page
	  4.library:编译后将bundle打包成lib
	  	string// the name of the exported library
	  5.libraryTarget:格式化导出的库
	  	libraryTarget: "umd", // enum;导出为 AMD, CommonJS2 或者是顶级属性
	    libraryTarget: "umd-module", // ES2015 module wrapped in UMD
	    libraryTarget: "commonjs-module", // ES2015 module wrapped in CommonJs
	    libraryTarget: "commonjs2", // exported with module.exports;通过设置 module.exports导出: module.exports = xxx
	    libraryTarget: "commonjs", // exported as properties to exports;通过设置 exports的属性导出: exports["Library"] = xxx
	    libraryTarget: "amd", // defined with AMD defined method;导出为AMD (视情况可通过output.library来命名)
	    libraryTarget: "this", // property set on this;通过设置 this的属性来导出: this["Library"] = xxx
	    libraryTarget: "var", //default;variable defined in root scope;通过设置一个变量导出: var Library = xxx (default)
	    // the type of the exported library
	  6./* Advanced output configuration (click to show) */
	  	1.pathinfo: true, // default:false;
	  		//包含了一些module的信息的注解,不要在生产环境里面使用
	  	2.chunkFilename: "[id].js",
		    chunkFilename: "[chunkhash].js", // for long term caching
	  		//非入口chunk的文件名，作为一个相对路径放到output.path里
		    // the filename template for additional chunks
		  3.jsonpFunction: "myWebpackJsonp", // string;
		  	//webpack异步加载的JSONP函数. 较短的函数可以缩小文件的大小，在一个页面里面拥有多个
    		// name of the JSONP function used to load chunks
	    4.sourceMapFilename: "[file].map", // string
	    	//js文件的SourceMap的文件名. 也同样在 output.path 路径下面
		    sourceMapFilename: "sourcemaps/[file].map", // string
		    // the filename template of the source map location
	    5.devtoolModuleFilenameTemplate: "webpack:///[resource-path]", // string
	    	//在生成的SourceMap里的函数sources数组的文件名模板。[resource]替换被Webpack用来解析文件的路径
	    	// the name template for modules in a devtool
			6.devtoolFallbackModuleFilenameTemplate: "webpack:///[resource-path]?[hash]", // string
	    	//和6.5类似
	    	// the name template for modules in a devtool (used for conflicts)
	    7.umdNamedDefine: true, // boolean
	    	//如果 output.libraryTarget 被设置为 umd 且 output.library 被 设置, 设置该项为 true 将为AMD module 命名
	    	// use a named AMD module in UMD library
	    8.crossOriginLoading: "use-credentials", // enum;"use-credentials" - 可用.credentials将随请求被发送
		    crossOriginLoading: "anonymous",//"anonymous" - 可用.credentials将不随请求被发送
		    crossOriginLoading: false,//default:false
		    //允许跨域加载chunk
		    // specifies how cross origin request are issued by the runtime
	3.module:对象
		1.loaders:数组//模块的规则（配置加载器，解析器选项等）
			1.test: /\.jsx?$/,//必须满足的条件
			2.include: [path.resolve(__dirname, "app")],//必须满足条件
			3.exclude: [path.resolve(__dirname, "app/demo-files")],//不满足的条件
			4.issuer: { test, include, exclude },//进口来源
				// conditions for the issuer (the origin of the import)
			5.enforce: "pre",
        enforce: "post",
        // apply these rule even if rules are overridden (advanced option)
      6.loader: "babel-loader",
      7.options: {presets: ["es2015"]}
        // options for the loader
      8./* Advanced module configuration (click to show) */
      	1.noParse: [/special-library\.js$/],
      		//一个正则表达式或者一组正则，不会匹配到的路径 它不匹配整个解析请求
    			// do not parse this module
    		2.exprContext: 一个作为依赖的表达式 (如 require(expr))
    			wrappedContext: 一个加前缀或者后缀的字符串 (i. e.require("./templates/" + expr))
    			unknownContext: 一些其他不解析的 require (i. e. require)
    			1.四个选项用来自动创建上下文:
    				1.request: 上下文的请求.
						2.recursive: 递归： 子目录需要被遍历.
						3.regExp: 正则表达式.
						4.critical: 这种类型的依赖应该被视为关键（发出警告）
  			3.应用:
	  			unknownContextRequest: ".",
			    unknownContextRecursive: true,
			    unknownContextRegExp: /^\.\/.*$/,
			    unknownContextCritical: true,
			    exprContextRequest: ".",
			    exprContextRegExp: /^\.\/.*$/,
			    exprContextRecursive: true,
			    exprContextCritical: true,
			    wrappedContextRegExp: /.*/,
			    wrappedContextRecursive: true,
			    wrappedContextCritical: false,
			    // specifies default behavior for dynamic requests
	4.resolve:对象,定义了解析模块路径时的配置
		1.modules: ["node_modules",path.resolve(__dirname, "app")]
			//解析目录名的一个数组到当前目录以及先前的目录，并且是查找模块
		2.extensions: [".js", ".json", ".jsx", ".css"],//解析模块的拓展名的数组
    	// extensions that are used
    3. alias: {
	      // a list of module name aliases
	      "module": "new-module"
	      // alias "module" -> "new-module" and "module/path/file" -> "new-module/path/file"
	      "only-module$": "new-module",
	      // alias "only-module" -> "new-module", but not "module/path/file" -> "new-module/path/file"
	    },
	    //模块被其他模块名和路径替代,改配置对象键名为模块名，键值为新的路径
	  4./* Advanced resolve configuration (click to show) */
	  	1.symlinks: true,
    		// follow symlinks to new location
    	2.descriptionFiles: ["package.json"],
    		// files that are read for package description
	    3.mainFields: ["main"],
		    // properties that are read from description file
		    // when a folder is requested
	    4.aliasFields: ["browser"],
		    // properites that are read from description file
		    // to alias requests in this package
	    5.enforceExtension: false,
		    // if true request must not include an extensions
		    // if false request may already include an extension
	    6.moduleExtensions: ["-module"],
		    enforceModuleExtension: false,
		    // like extensions/enforceExtension but for module names instead of files
	    7.unsafeCache: true,
		    unsafeCache: {},
		    // enables caching for resolved requests
		    // this is unsafe as folder structure may change
		    // but preformance improvement is really big
	    8.cachePredicate: (path, request) => true,
	    	// predicate function which selects requests for caching
	5.devtool:选择开发工具来提高debug效率
		1."source-map", // enum
		2."inline-source-map", // inlines SourceMap into orginal file
		3."eval-source-map", // inlines SourceMap per module
		4."hidden-source-map", // SourceMap without reference in original file
		5."cheap-source-map", // cheap-variant of SourceMap without module mappings
		6."cheap-module-source-map", // cheap-variant of SourceMap with module mappings
		7."eval", // no SourceMap, but named modules. Fastest at the expense of detail.
	6.context: __dirname, // string (absolute path!)
		//用于解析entry选项的基础目录(绝对路径), 如果output.pathinfo设置了，就包含了缩短过的目录
	7.target: "web"|"webworker"|"node"|"async-node"|"node-webkit"|"electron-main"|"electron-renderer"|(compiler) => { /* ... */ },
		//编译到的目标使用环境
	8.externals: 对象|字符串|函数|正则|数组,
		//指定的依赖不会被webpack解析，但会成为bundle里的依赖
		1.externals: ["react", /^@angular\//],
	  2.externals: "react", // string (exact match)
	  3.externals: /^[a-z\-]+($|\/)/, // Regex
	  4.externals: { // object
		    angular: "this angular", // this["angular"]
		    react: { // UMD
		      commonjs: "react",
		      commonjs2: "react",
		      amd: "react",
		      root: "React"
		    }
		  },
	  5.externals: (request) => { /* ... */ return "commonjs " + request }
	9.stats:
	10.devServer:
	11.plugins:
	12./* Advanced configuration (click to show) */
		1.resolveLoader: { /* same as resolve */ }//像 resolve 但是是对于loaders
  		// separate resolve options for loaders
  	2.profile: true, // boolean
  		//为每一个module捕获定时信息
  		// capture timing information
  	3.cache: false, // boolean;default:true
  		//在多次增量编译时候，缓存生成的moudle和chunk来提高性能
  		// disable/enable caching
  	4.watch: true, // boolean
  		// enables watching
  		watchOptions: {
		    aggregateTimeout: 1000, // in ms
		    // aggregates multiple changes to a single rebuild
		    poll: true,
		    poll: 500, // intervall in ms
		    // enables polling mode for watching
		    // must be used on filesystems that doesn't notify on change
		    // i. e. nfs shares
		  },
	  5.node: {
	  		//包含了许多node的polyfills或者mock
		    /* TODO */
		    console: false,
			  global: true,
			  process: true,
			  Buffer: true,
			  __filename: "mock",
			  __dirname: "mock",
			  setImmediate: true
		  },
	  6.recordsPath: path.resolve(__dirname, "build/records.json"),
	  7.recordsInputPath: path.resolve(__dirname, "build/records.json"),
	  8.recordsOutputPath: path.resolve(__dirname, "build/records.json"),
	  	//存储/加载 compiler状态 从/到 一个json文件里面。结果将会是一些module和chunk的固定id
	  	//需要是 绝对路径，如果recordsInputPath,recordsOutputPath都为undefined，recordsInputPath将被使用
	  	//在多个编译请求做热替换的时候是需要这个配置的
	  	// TODO

gulp and webpack:
//first use mode
var gulp = require("gulp");
var webpack = require("webpack");
gulp.task("default",function(){
	gulp.src("src/entry.js") //指定入口文件
			.pipe(webpack())
			.pipe(gulp.dest("dist/"));
})
//seconds uses mode
var gulp = require("gulp");
var webpack = require("webpack");
gulp.task("default",function(){
	gulp.src("src/entry.js")
			.pipe(webpack({
				watch:true,
				module:{
					loaders:[
						{test:/\.css$/,loader:"style!css"}
					]
				}
			}))
			.pipe(gulp.dest("dist/"))
})
//third uses mode
var gulp = require("gulp");
var webpack = require("webpack");
gulp.task("default",function(){
	gulp.src("src/entry.js")
			.pipe(webpack(require("./webpack.config.js")))
			.pipe(gulp.dest("dist/"))
})
//fourth uses mode
var gulp = require("gulp");
var webpack = require("webpack");
var gulpWebpack = require("gulp-webpack");
gulp.task("default",function(){
	gulp.src("src/entry.js")
			.pipe(gulpWebpack({},webpack))
			.pipe(gulp.dest("dist/"))
})
//fifth uses mode
var gulp = require("gulp");
var webpack = require("gulp-webpack");
gulp.task("default",function(){
	gulp.src("src/entry.js")
			.pipe(webpack({
				/*config*/
			},null,function(err,stats){
				/*use stats to do more things if needed*/
			}))
})
//multiple entry Point
var gulp = require('gulp');
var webpack = require('gulp-webpack');
gulp.task('default', function() {
  gulp.src('src/entry.js')
    	.pipe(webpack({
	      entry: {
	        app: 'src/app.js',
	        test: 'test/test.js',
	      },
	      output: {
	        filename: '[name].js',
	      },
	    }))
	    .pipe(gulp.dest('dist/'));
});
//renaming vinyl-named
var gulp = require('gulp');
var webpack = require('gulp-webpack');
var named = require('vinyl-named');
gulp.task('default', function() {
  return gulp.src(['src/app.js', 'test/test.js'])
    .pipe(named())
    .pipe(webpack())
    .pipe(gulp.dest('dist/'));
});
	  	
案例:
module.exports = {
	devtool:"eval-source-map",//配置生成Source Maps，选择合适的选项

	//__dirname是Node.js中的一个全局变量，它指向当前执行脚本所在的目录
  entry:  __dirname + "/app/main.js",//已多次提及的唯一入口文件
  output: {
    path: __dirname + "/public",//打包后的文件存放的地方
    filename: "bundle.js"//打包后输出文件的文件名
  },
  module: {//在配置文件里添加JSON loader
    loaders: [
      {
        test: /\.json$/,
        loader: "json"
      },
      {
        test: /\.js$/,
        exclude: /node_modules/,
        loader: 'babel',
        query: {
          presets: ['es2015','react']
        }
      },
      {
        test: /\.css$/,
        //感叹号的作用在于使同一文件能够使用不同类型的loader
        loader: 'style!css'//添加对样式表的处理
      }
    ]
  },
  plugins: [
    new HtmlWebpackPlugin({
      template: __dirname + "/app/index.tmpl.html"//new 一个这个插件的实例，并传入相关的参数
    })
  ], 
  //使用webpack配置本地服务器
  devServer:{
  	contentBase:"./public",//本地服务器所加载的页面所在的目录
    port:3000,
  	colors:true,//终端中输出结果为彩色
  	inline:true,//实时刷新
  	historyApiFallback:true,//不跳转
  }
}	  	