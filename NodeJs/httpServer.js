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