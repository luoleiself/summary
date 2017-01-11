/*
//使用zlib模块的gzip对象压缩文件
var zlib = require("zlib");
var fs = require("fs");
var gzip = zlib.createGzip();
var inp = fs.createReadStream("./test.txt");
var out = fs.createWriteStream("./test.txt.gz");
inp.pipe(gzip).pipe(out);
*/
/*
//使用zlib模块的gunzip对象解压缩文件
var zlib = require("zlib");
var fs = require("fs");
var gunzip = zlib.createGunzip();
var inp = fs.createReadStream("./test.txt.gz");
var out = fs.createWriteStream("./hehe.txt");
inp.pipe(gunzip).pipe(out);
*/
//使用zlib模块的方法
var zlib = require("zlib");
var fs = require("fs");
var out = fs.createWriteStream("commpress.log");
var input = "fdjkahklfhdaslhfkdlas";
zlib.gzip(input,function(err,buffer){
	if(!err){
		zlib.unzip(buffer,function(err,buffer){
			if(!err){
				console.log(buffer.toString());
				out.write(buffer);
			}
		})
	}
})