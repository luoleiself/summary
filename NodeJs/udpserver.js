/*
var dgram = require("dgram");
var server = dgram.createSocket("udp4");
server.on("message",function(msg,rinfo){
	console.log("已接收到客户端发送的数据.."+msg);
	console.log("客户端地址信息为%j",rinfo);
	var buffer = new Buffer("确认信息为:"+msg);
	server.setTTL(128);//设置数据包在网络中经过的路由器的最大数目
	server.send(buffer,0,buffer.length,rinfo.port,rinfo.address);
	setTimeout(function(){
		server.unref();
	},10000)
})
server.on("listening",function(){
	var address = server.address();
	console.log("服务器开始监听,地址信息为%j",address);
})
server.bind("3000","localhost");
*/
/*
var dgram = require("dgram");
var server = dgram.createSocket("udp4");
server.on("message",function(msg,rinfo){
	var buf = new Buffer("已接收客户端发送的数据:"+msg);
	server.setBroadcast(true);
	server.send(buf,0,buf.length,"3000","192.168.2.255");
})
server.bind("3000","192.168.2.107");
*/
//UDP服务器组播练习
var dgram = require("dgram");
var server = dgram.createSocket("udp4");
server.on("listening",function(){
	server.setMulticastTTL(128);
	server.addMembership("235.185.192.108");
});
setInterval(function(){
	var buf = new Buffer(new Date().toLocaleString());
	server.send(buf,0,buf.length,"8888","235.185.192.108");
},5000)
server.on("message",function(msg,rinfo){
	if(msg.toString() === "ok"){
		console.log("响应停止组播信息成功...");
		server.unref();
	}
})