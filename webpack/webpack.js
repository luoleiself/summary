webpack:
	1.优点: 
		1.代码拆分:Webpack 有两种组织模块依赖的方式，同步和异步。异步依赖作为分割点，形成一个新的块。
							在优化了依赖树后，每一个异步区块都作为一个文件被打包.
		2.Loader:Webpack 本身只能处理原生的 JavaScript 模块，
						但是 loader 转换器可以将各种类型的资源转换成 JavaScript 模块
		3.智能解析:Webpack 有一个智能解析器，几乎可以处理任何第三方库，
							无论它们的模块形式是 CommonJS、 AMD 还是普通的 JS 文件
		4.插件系统:Webpack 还有一个功能丰富的插件系统。大多数内容功能都是基于这个插件系统运行的，
							还可以开发和使用开源的 Webpack 插件，来满足各式各样的需求
		5.快速运行:Webpack 使用异步 I/O 和多级缓存提高运行效率，
							这使得 Webpack 能够以令人难以置信的速度快速增量编译
	2.安装: $ npm install webpack -g //--save-dev
	3.配置: 
		1.Loader:
			1.Loader 可以通过管道方式链式调用，每个 loader 可以把资源转换成任意格式并传递给下一个 loader ，但是最后一个 loader 必须返回 JavaScript。
			2.Loader 可以同步或异步执行。
			3.Loader 运行在 node.js 环境中，所以可以做任何可能的事情。
			4.Loader 可以接受参数，以此来传递配置项给 loader。
			5.Loader 可以通过文件扩展名（或正则表达式）绑定给不同类型的文件。
			6.Loader 可以通过 npm 发布和安装。
			7.除了通过 package.json 的 main 指定，通常的模块也可以导出一个 loader 来使用。
			8.Loader 可以访问配置。
			9.插件可以让 loader 拥有更多特性。
			10.Loader 可以分发出附加的任意文件
		2.loader 一般以 xxx-loader 的方式命名，xxx 代表了这个 loader 要做的转换功能，比如 json-loader,css-loader,style-loader
		3.创建webpack.config.js配置文件:
			1. cmd: $ webpack --progress --colors //设置编译过程中的输出内容带有进度和颜色
			2. cmd: $ webpack --progress --colors --watch //启动监听模式，不用每次修改后手动编译
			3. 使用webpack-dev-server
					1.cmd: $ npm webpack-dev-server //启动后会建立一个express的:8080静态web服务器，并且自动启动监听模式刷新页面
					2.cmd:webpack-dev-server --progress --colors
		4.故障处理:
		  1. $ webpack --display-error-details //输出错误详细信息
		  2.Webpack 的配置提供了 resolve 和 resolveLoader 参数来设置模块解析的处理细节，
		  	resolve 用来配置应用层的模块（要被打包的模块）解析，
		  	resolveLoader 用来配置 loader 模块的解析
		  	当出现 Node.js 模块依赖查找失败的时候，可以尝试设置 resolve.fallback 和 resolveLoader.fallback 来解决问题
		  		module.exports = {
					  resolve: { fallback: path.join(__dirname, "node_modules") },
					  resolveLoader: { fallback: path.join(__dirname, "node_modules") }
					};
			3.Webpack 中涉及路径配置最好使用绝对路径，
				建议通过 path.resolve(__dirname, "app/folder") 或 path.join(__dirname, "app", "folder") 的方式来配置，
				以兼容 Windows 环境
		5.参数:
			1.entry:指定webpack进行编译的入口文件
			2.output:
	4.运行: 1.cmd: webpack [entryfilepath/filesname.js] [outputfilepath/newfilesname.js]
					2.package.json: scripts:{"start":"webpack"} => cmd: npm start
	5.Webpack的强大功能
		1.生成Source Maps:提供一种编译文件和源文件对应的方法,使得编译后的代码可读性更高，也更容易调试
			1.devtool配置选项:
				1.source-map:在一个单独的文件中产生一个完整且功能完全的文件。这个文件具有最好的source map，但是它会减慢打包文件的构建速度
				2.cheap-module-source-map:在一个单独的文件中生成一个不带列映射的map，不带列映射提高项目构建速度，但是也使得浏览器开发者工具只能对应到具体的行，不能对应到具体的列（符号），会对调试造成不便			
				3.一般应用在中小型项目的开发环境阶段，方便调试,构建速度快
					eval-source-map:使用eval打包源文件模块，在同一个文件中生成干净的完整的source map。这个选项可以在不影响构建速度的前提下生成完整的sourcemap，但是对打包后输出的JS文件的执行具有性能和安全的隐患。不过在开发阶段这是一个非常好的选项，但是在生产阶段一定不要用这个选项
				4.一般应用在大型项目中，构建速度最快，
					cheap-module-eval-source-map:这是在打包文件时最快的生成source map的方法，生成的Source Map 会和打包后的JavaScript文件同行显示，没有列映射，和eval-source-map选项具有相似的缺点
		2.使用webpack构建本地服务器
			1.cmd:$ npm install --save-dev webpack-dev-server
			2.devServer配置选项:
				1.contentBase:默认webpack-dev-server会为根文件夹提供本地服务器，如果想为另外一个目录下的文件提供本地服务器，应该在这里设置其所在目录（本例设置到'public'目录）
				2.port:设置默认监听端口，如果省略，默认为'8080'
				3.inline:设置为true，当源文件改变时会自动刷新页面
				4.colors:设置为true，使终端输出的文件为彩色的
				5.historyApiFallback:在开发单页应用时非常有用，它依赖于HTML5 history API，如果设置为true，所有的跳转将指向index.html
		3.Loaders:通过使用不同的loader，webpack通过调用外部的脚本或工具可以对各种各样的格式的源文件进行处理
			1.modules关键字下进行配置:
				1.test:一个匹配loaders所处理的文件的拓展名的正则表达式（必须）
				2.loader:loader的名称（必须）
				3.include/exclude:手动添加必须处理的文件（文件夹）或屏蔽不需要处理的文件（文件夹）（可选）
				4.query:为loaders提供额外的设置选项（可选）
			2.css: style-loader,css-loader
				1.style-loader:style-loader将所有的计算后的样式加入页面中
				2.css-loader:使用类似@import 和 url(...)的方法实现 require()的功能
				3.CSS module:把module传递到需要的组件中，类名只对当前组件有效,
				4.CSS 预处理器: Less-loader,Sass-loader,stylus-loader
		4.插件(plugins):在整个构建过程中执行相应的任务
			1.使用:plugins:[new webpack.BannerPlugin("Copyright Flying Unicorns inc.")//在这个数组中new一个就可以了]
			2.HtmlWebpackPlugin:生成最终的HTML5文件
			3.Hot Module Replacement:自动刷新实时预览修改后的效果
				1.在webpack配置文件中添加HMR插件
				2.在Webpack Dev Server中添加“hot”参数
		4.Babel:是一个编译JavaScript的平台
			1.下一代的JavaScript标准（ES6，ES7），这些标准目前并未被当前的浏览器完全的支持
			2.使用基于JavaScript进行了拓展的语言，比如React的JSX
			3.安装: cmd: $ npm install --save-dev babel-core babel-loader babel-preset-es2015 babel-preset-react
      4.使用react: $ npm install --save react react-dom
webpack参数详解:
	1.entry:定义webpack工作的入口文件
		1.字符串:用来定义入口文件
			entry:"./*.js"
		2.数组: 一个参数为入口文件，一个参数为webpack-dev-server静态服务器，由配置的服务器监视文件的变化
			数组中有多个入口文件时,所有模块都是启动时加载，模块导出到最后一个里面
			entry:["webpack-dev-server","./*.js"]
		3.对象:根据不同的需要指定不同的入口文件，按需引入,
			entry:{hello:"./hello.js",world:"./word.js"}
	2.output:对象,定义构建后的文件的输出。其中包含path和filename
		1.path:指定输出目录
		2.filename:指定输出文件名,如果入口文件有多个时,使用[name].js或者[id].js
			output:{path:"./public",filename:"[name].js",chunkFilename: "[id].js"}
	3.module:模块文件定义在loaders中,
		1.test:一个匹配loaders所处理的文件的拓展名的正则表达式（必须）
		2.loader:loader的名称（必须）
		3.include/exclude:手动添加必须处理的文件（文件夹）或屏蔽不需要处理的文件（文件夹）（可选）
		4.query:为loaders提供额外的设置选项（可选）
	4.resolve:构建包的时候会按目录的进行文件的查找，resolve属性中的extensions数组中用于配置程序可以自行补全哪些文件后缀
		resolve:{extensions:['','.js','.json']}
	5.externals:引入类库文件,不会被构建到运行文件中
		 externals: {"jquery": "jQuery"}
		 var jQuery = require(“jquery”)



