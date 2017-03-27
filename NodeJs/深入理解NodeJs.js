NodeJs:
	1.Node Standard Library:标准库,例: Http,Buffer等模块
	2.Node Bindings:沟通JS 和 C++的桥梁，封装V8和Libuv的细节，向上层提供基础API服务.这一层是支撑 Node.js 运行的关键，由 C/C++ 实现
		1.V8 是Google开发的JavaScript引擎，提供JavaScript运行环境，可以说它就是 Node.js 的发动机
		2.Libuv 是专门为Node.js开发的一个封装库，提供跨平台的异步I/O能力
		3.C-ares：提供了异步处理 DNS 相关的能力
		4.http_parser、OpenSSL、zlib 等：提供包括 http 解析、SSL、数据压缩等其他的能力
	3.V8
	4.Libuv
NodeJs-module:
	1.builtin module: Node 中以 c++ 形式提供的模块，如 tcp_wrap、contextify 等
	2.constants module: Node 中定义常量的模块,用来导出如 signal, openssl 库、文件访问权限等常量的定义.
		如文件访问权限中的 O_RDONLY，O_CREAT、signal 中的 SIGHUP，SIGINT 等。
	3.native module: Node 中以 JavaScript 形式提供的模块，如 http,https,fs 等。
		有些 native module 需要借助于 builtin module 实现背后的功能。如对于 native 模块 buffer,还是需要借助 
		builtin node_buffer.cc 中提供的功能来实现大容量内存申请和管理，目的是能够脱离 V8 内存大小使用限制。
	4.3rd-party module: 以上模块可以统称 Node 内建模块，除此之外为第三方模块，典型的如 express 模块。
模块加载:
	Global-Object:process,global,console,
	Global-Fun:setInterval(),setTimeout(),clearInterval(),clearTimeout(),require(),Buffer()
	Global-Variable:__filename,__dirname
CommonJs规范:
	CommonJS规范加载模块是同步的,也就是说，只有加载完成，才能执行后面的操作。
	AMD规范则是非同步加载模块,允许指定回调函数。
	由于Node.js主要用于服务器编程,模块文件一般都已经存在于本地硬盘,所以加载起来比较快,不用考虑非同步加载的方式,所以CommonJS规范比较适用。
	但是,如果是浏览器环境,要从服务器端加载模块,这时就必须采用非同步模式,因此浏览器端一般采用AMD规范
	


