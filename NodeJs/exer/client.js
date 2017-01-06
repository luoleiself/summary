var net = require("net");
var client = new net.Socket();
client.setEncoding("utf8");
client.connect("3000","localhost",function(){
	console.log("已连接到服务器");
	client.write("服务器,你好!");
	console.log("当前已发送%d字节",client.bytesWritten);
})
client.on("data",function(data){
	console.log("已发送到服务器的数据:"+data);
	setTimeout(function(){
		client.end();
	},10000);
});
client.on("error",function(err){
	console.log("链接出错...");
	client.destroy();
})