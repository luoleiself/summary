/*
var dgram = require("dgram");
var client = dgram.createSocket("udp4");
var message = new Buffer("测试代码");
client.send(message,0,message.length,3000,"localhost",function(err,bytes){
	if(err){
		console.log("数据发送失败...");
	}else{
		console.log("已发送%d字节数据",bytes);
	}
});
client.on("message",function(msg,rinfo){
	console.log("已接收服务器发送的数据:%s",msg);
	console.log("服务器地址信息为:%j",rinfo);
	client.close();
})
client.on("close",function(){
	console.log("socket端口已关闭..."+new Date().toLocaleString());
})
*//*
var dgram = require("dgram");
var client = dgram.createSocket("udp4");
client.bind("3001","192.168.2.107");
var buf = new Buffer("你好");
client.send(buf,0,buf.length,"3000","192.168.2.107");
client.on("message",function(msg,rinfo){
	console.log("已接收服务器发送的数据%s",msg);
})
*/
//UDP客户端组播练习
var dgram = require("dgram");
var client = dgram.createSocket("udp4");
var count = 0;
client.on("listening",function(){
	client.addMembership("235.185.192.108");
})
client.on("message",function(msg,rinfo){
	console.log("接收组播信息第%d次",++count);
	console.log(msg.toString());
	console.log(rinfo);
	if(count === 10){
		var buf = new Buffer("ok");
		client.send(buf,0,buf.length,rinfo.port,rinfo.address,function(err,bytes){
			if(err){
				console.log("请求停止组播发送信息失败...");
			}else{
				console.log("请求停止组播信息成功!");
				client.unref();
			}
		});
	}
})
client.bind(8888,"192.168.2.107");


