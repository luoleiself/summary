/*
//使用dns模块进行域名解析
var dns = require("dns");
dns.resolve("www.baidu.com","A",function(err,addresses){
	console.log(addresses);
});
*/
/*
//使用dns模块的resolveMx方法解析
var dns = require("dns");
dns.resolveCname("www.baidu.com",function(err,addresses){
	console.log(addresses);
})
*/
/*
//使用dns模块的lookup方法查找ip
var dns = require("dns");
dns.lookup("www.baidu.com",6,function(err,addresses,family){
	console.log(addresses);
	console.log(family);
})
*/
//使用dns模块的reverse方法逆向解析
var dns = require("dns");
dns.reverse("161.135.169.121",function(err,domains){
	console.log(domains);
})