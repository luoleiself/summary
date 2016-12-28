/*
var net = require("net");
var server = net.createServer();
var fs = require("fs");
server.on("connection",function(socket){
	console.log("客户端与服务器已建立连接..."+new Date().toLocaleString());
	socket.setEncoding("utf8");
	var readStream = fs.createReadStream('./server.js');
	readStream.on("data",function(data){
		var flag = socket.write(data);
		console.log("write方法的返回值"+flag);
		console.log("缓存队列缓存了%d字符",socket.bufferSize);
	})
	socket.on("data",function(data){
		console.log("已接收到客户端发送的数据..."+new Date().toLocaleString());
	})
	socket.on("drain",function(){
		console.log("TCP缓存区数据已全部发送完毕..."+new Date().toLocaleString())
	})
}).listen("3000","localhost");
*/
var net = require("net");
var server = net.createServer({allowHalfOpen:true});
server.on("connection",function(socket){
	console.log("客户端和服务器已经建立连接...");
	socket.setEncoding("utf8");
	server.getConnections(function(err,count){
		console.log("客户端链接数量:"+count)
	});
	socket.on("data",function(data){
		console.log("已接收到客户端发送的数据:"+data+"\n接收时间:"+new Date().toLocaleString());
		socket.write("确认数据:"+data);	
	});
	socket.on("end",function(){
		console.log("客户端链接关闭...");
	});
	socket.on("error",function(){
		cosnole.log("链接出现错误...");
		socket.destroy();
	})
	//socket端口彻底关闭时触发close事件
	socket.on("close",function(){
		console.log("服务器应用程序关闭时间..."+new Date().toLocaleString());
		server.unref();//关闭tcp服务器应用程序
	})
}).listen("3000","localhost");
