var http = require("http");
var options = {
	hostname:"127.0.0.1",
	port:3000,
	path:"/",
	method:"POST"
};
var req = http.request(options,function(res){
	res.on("data",function(data){
		console.log("客户端接收到的数据:"+data);
	});
	res.on("end",function(){
		console.log("Trailers头部信息:%j",res.trailers);
	})
});
req.write("Hello Http!");
req.end("Bye-Bye");