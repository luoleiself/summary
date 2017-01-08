/*
//使用spawn方法开启子进程
var fs = require('fs');
var out = fs.createWriteStream('./message.txt');
process.stdin.on('data',function(data){
	out.write(data);
});
process.stdin.on('end',function(data){
	process.exit();
});
*/
//使用fork方法开启子进程
var fs = require('fs');
var out = fs.createWriteStream('./message.txt');
process.on("message",function(data){
	out.write(data);
});