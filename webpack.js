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
	4.运行:






