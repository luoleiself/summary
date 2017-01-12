/*
//使用readline模块读取行流数据
var readline = require("readline");
var intface = readline.createInterface({
	input:process.stdin,
	output:process.stdout
});
intface.on("line",function(line){
	if(line == "exit" || line == "quit" || line == "q"){
		intface.close();
	}else{
		console.log("已输入:"+line);
	}
})
*/
/*
var readline = require("readline");
var intface = readline.createInterface({
	input:process.stdin,
	output:process.stdout,
	completer:completer
});
function completer(line){
	var completions = "help error quit aaa bbb ccc".split(" ");
	var hits = completions.filter(function(c){return c.indexOf(line) == 0});
	return [hits,line];
}
intface.on("line",function(line){
	if(line == "exit" || line == "quit" || line == "q"){
		intface.close();
	}else{
		console.log("已输入:"+line);
	}
})
*/
/*
//readline模块中的setPrompt与prompt方法
var readline = require("readline");
var intface = readline.createInterface({
	input: process.stdin,
	output: process.stdout
});
intface.setPrompt("请输入:",7);
intface.prompt();
intface.on("line",function(line){
	if(line == "exit" || line == "quit" || line == "q"){
		intface.close();
	}else{
		console.log("已输入:"+line);
		intface.prompt();
	}
});
intface.on("close",function(){
	console.log("\r\n行数据读取操作被终止...");
})
*/
//readline模块中的question方法
var readline = require("readline");
var intface = readline.createInterface({
	input: process.stdin,
	output: process.stdout
});
intface.question("元芳,你怎么看?",function(answer){
	console.log("元芳的回答:"+answer);
	intface.close();
})