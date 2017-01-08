/*
//使用spawn方法开启子进程
var cp = require('child_process');
var sp1 = cp.spawn('node',['test1.js','one','two','three','four'],{cwd:'./test',stdio:['ipc','pipe','ignore']});
var sp2 = cp.spawn('node',['test2.js'],{stdio:'pipe',cwd:'./test'});
sp1.stdout.on('data',function(data){
	console.log('子进程标准输出:'+data);
	sp2.stdin.write(data);
	sp1.kill();
});
sp1.on('exit',function(code,signal){
	if(!code){
		console.log('子进程退出,退出信号为:'+signal);
	}else{
		console.log('子进程退出,退出代码为:'+code);
	}
	process.exit();
})
sp1.on("error",function(err){
	console.log("子进程开启失败:"+err);
	process.exit();
});
sp2.on("error",function(err){
	console.log("子进程开启失败:"+err);
	process.exit();
});
*/
//使用fork方法开启子进程
var cp = require('child_process');
var sp1 = cp.fork('test1.js',['one','two','three','four'],{silent:true});
var sp2 = cp.fork('test2.js');
sp1.stdout.on('data',function(data){
	console.log('子进程标准输出:'+data);
	sp2.send(data.toString());
});
sp1.on('exit',function(code,signal){
	if(!code){
		console.log('子进程退出,退出信号为:'+signal);
	}else{
		console.log('子进程退出,退出代码为:'+code);
	}
	process.exit();
})
sp1.on("error",function(err){
	console.log("子进程开启失败:"+err);
	process.exit();
});
sp2.on("error",function(err){
	console.log("子进程开启失败:"+err);
	process.exit();
});
/*
//使用fork方法开启子进程
var cp = require('child_process');
var n = cp.fork(__dirname + '/test1.js');
n.on("message",function(message,setHandle){
	console.log('父进程接收到消息:%j',message);
	process.exit();
})
n.send({username:"Hello World"});
*/