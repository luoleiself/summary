/*
//创建http服务器
var http = require("http");
var server = http.createServer(function(req,res){
	console.log(req.header);
}).listen(3000,"127.0.0.1",function(){
	console.log("服务器端开始监听...");
});
server.on("close",function(){
	console.log("服务器已关闭...");
});
server.on("error",function(err){
	if(err.code == "EADDRINUSE"){
		console.log("端口及地址被占用...");
	}
})
server.on("connection",function(socket){
	console.log("客户端已成功链接...");
})
server.setTimeout(60*1000,function(socket){
	console.log("服务器连接超时...");
	server.close();
})
*/
var http = require("http");
var fs = require("fs");
var server = http.createServer(function(req,res){
	if(req.url !== "/favicon.ico" ){
		/*
		var out = fs.createWriteStream("./request.log");
		out.write("客户端所用的请求方法为:"+req.method+"\r\n");
		out.write("客户端所用的url字符串为:"+req.url+"\r\n");
		out.write("客户端请求头对象为:"+JSON.stringify(req.headers)+"\r\n");
		out.end("客户端所用的请求版本:"+req.httpVersion+"\r\n");
		*/
		/*
		req.on("data",function(data){
			console.log("服务器接收到数据:"+decodeURIComponent(data));
		});
		req.on("end",function(){
			console.log("数据已接收完毕...");
		})
		*/
		if(!res.headerSent){
			res.writeHead(200,"ok",{'cotent-type':'text/plain','Access-Control-Allow-Origin':'http://localhost'});
			res.statusCode = 400;//设置响应状态码
			res.sendDate = false;//取消自动发送当前服务器时间字段
			res.write("你好");
		}else{

		}
	}
	res.end();
}).listen("3000","localhost");