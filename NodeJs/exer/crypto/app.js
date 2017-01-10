/*
//使用crypto模块的hash算法
var crypto = require("crypto");
var fs = require("fs");
var shasum = crypto.createHash("sha1");
var s = fs.ReadStream('./app.js');
s.on("data",function(d){
	shasum.update(d);
});
s.on("end",function(){
	var d = shasum.digest("hex");
	console.log(d);
})
*/
/*
//使用crypto模块的hmac算法
var crypto = require("crypto");
var fs = require("fs");
var pem = fs.readFileSync("key.pem");
var key = pem.toString("ascii");
var shasum = crypto.createHmac("sha1",key);
var s = fs.ReadStream("./app.js");
s.on("data",function(data){
	shasum.update(data);
})
s.on("end",function(){
	var data = shasum.digest("hex");
	console.log(data);
})
*/
/*
//使用cipher类加密数据
var crypto = require("crypto");
var fs = require("fs");
var pem = fs.readFileSync("key.pem");
var key = pem.toString("ascii");
var cipher = crypto.createCipher("blowfish",key);
var text = "test";
cipher.update(text,"binary","hex");
var crypted = cipher.final("hex");
console.log(crypted);
*/
/*
//使用decipher解密数据
var crypto = require("crypto");
var fs = require("fs");
var pem = fs.readFileSync("key.pem");
var key = pem.toString("ascii");
var decipher = crypto.createDecipher("blowfish",key);
var dec = decipher.update(crypted,"hex","utf8");
dec += decipher.final("utf8");
console.log(dec);
*/
/*
//使用sign签名
var crypto = require("crypto");
var fs = require("fs");
var pem = fs.readFileSync("key.pem");
var key = pem.toString("ascii");
var sign = crypto.createSign("RSH-SHA256");
sign.update("test");
console.log(sign.sign(key,"hex"));
*/
//使用verify验证签名
var crypto = require("crypto");
var fs = require("fs");
var privatepem = fs.readFileSync("key.pem");
var publicpem = fs.readFileSync("cert.pem");
var key = privatepem.toString();
var publickey = pbulicpem.toString();
var data = "test";
var sign = crypto.createSign("RSH-SHA256");
sign.update(data);
var sig = sign.sign(key,"hex");
var verify = crypto.createVerify("RSH-SHA256");
verify.update(data);
verify.verify(publickey,sig,"hex");
