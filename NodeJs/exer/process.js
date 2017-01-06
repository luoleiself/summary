/*
//标准输入输出流对象应用
process.stdin.resume();
process.stdin.on("data",function(data){
	process.stdout.write("进程接收到数据:"+data);
});
*/
/*
//进程的属性的命令参数数组遍历
process.argv.forEach(function(val,index,array){
	console.log(index+" : "+val);
})
*/
function foo(){
	console.log("foo");
}
process.nextTick(foo);
console.log("bar");