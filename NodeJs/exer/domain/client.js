//显式绑定domain对象
var http = require("http");
var options = {
	hostname:"localhost",
	port:8888,
	path:"/",
	method:"POST"
}
var req = http.request(options,function(res){
	res.setEncoding("utf8");
	res.on("data",function(data){
		console.log("响应内容为:"+data);
	})
});
req.write("Hello World!");
req.end("Bye-Bye");
