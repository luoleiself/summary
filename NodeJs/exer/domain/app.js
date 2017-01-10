/*
//使用domain模块捕获异常,隐式绑定
var domain = require("domain");
var fs = require("fs");
var d = domain.create();
d.name = "dl";
d.on("error",function(err){
	console.log("%s捕获到异常!",d.name,err)
});
//隐式绑定
d.run(function(){
	process.nextTick(function(){
		setTimeout(function(){
			fs.open("non-existent file","r",function(err,fd){
				if(err){throw err;}
			})
		},1000)
	})
})
*/
/*
//使用bind绑定回调函数
var fs = require("fs");
var domain = require("domain");
var d = domain.create();
fs.readFile("./test.txt",d.bind(function(err,data){
	// d.intercept(function(err,data){
		console.log(data);
}));
d.on("error",function(err){
	console.log("读取文件发生以下错误...");
	console.log(err);
})
*/