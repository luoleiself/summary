### 跨域请求：
  * 方式一：JSONP请求：
    * 方法1：Ajax请求: 只能发送get请求
      * 本地创建Ajax请求：

                `
                  $.ajax({
                    url: "http://192.168.2.187:8000",
                    type: "get", // 此处修改post无效
                    cache: false,
                    crossDomain: true,
                    dataType: "jsonp",
                    jsonp: 'callback',
                    jsonpCallback: "cb",
                    success: function (data) {
                        console.log(data);
                        // cb({"success":true,"name":"luolei","pwd":123456})
                    }
                  })`
        * 本地服务器:192.168.2.187:3000
        
                ` var express = require('express');
                  var app = express();
                  app.listen(3000, '192.168.2.187');
                  app.use('/', express.static("public"));
                  app.get('/main.html', function (req, res) {
                      res.sendFile(__dirname + '/main.html');
                  })`
        * 远程服务器：192.168.2.187:8000
              
                ` var http = require('http');
                  var url = require('url');
                  var server = http.createServer(function (req, res) {
                  	var data = {
                   		success: true,
                  		name: 'luolei',
                  		pwd: 123456
                  	};
                  	var query = url.parse(req.url, true).query;
                  	var str = query.callback + '(' + JSON.stringify(data) + ')';
                  	console.log(query);
                  	console.log(str);
                  	res.end(str);
                  }).listen(8000, '192.168.2.187');`
    * 方法2：script标签:只能发送get请求
        * 所有浏览器均支持
        * 本地创建script标签并添加src属性，声明回调方法：
        
                ` var father = documet.getElementsByTagName('body')[0];
                  var script = document.createElement('script');
                  var str = "http://192.168.2.187:8000/?callback=cb";
                  script.src = str;
                  father.appendChild(script);
    
                  function cb(data){
                      console.log(data);
                      // {"success":true,"name":"luolei","pwd":123456} 
                  }`
        * 本地服务器：192.168.2.187:3000，方法同上
        * 远程服务器：192.168.2.187:8000，方法同上
    * 方法3：document.domain + iframe(只有在主域相同的时候才能使用该方法)，方法未测
    * 方法4：location.hash + iframe，方法未测
    * 方法5：window.name + iframe，方法未测
    * 方法6：postMessage（HTML5中的XMLHttpRequest Level 2中的API），方法未测
    * 方法7：web sockets，方法未测
 * 方式二：CORS（跨域资源共享）：可以发送任意请求（简单请求和非简单请求）
    * IE10以上才支持，  
    * 本地创建XMLHttpRequest对象，也可以使用ajax方法(get请求)；

            `       
            var xmlHttp;
            if (window.XMLHttpRequest) {
                xmlHttp = new XMLHttpRequest();
            } else {
                xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
            }
            xmlHttp.onreadystatechange = function () {
                if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
                    // 返回的是字符串，需要使用eval方法解析；
                    eval(xmlHttp.responseText);
                }
            }
            xmlHttp.open('post', 'http://192.168.2.187:8000/?callback=cp', true);
            xmlHttp.send(JSON.stringify({
                name: 'luolei',
                pwd: 123456
            }));`
    * 本地服务器：192.168.2.187:3000，方法同上
    * 远程服务器：192.168.2.187:8000
    
            ` var http = require('http');
              var url = require('url');
              var server = http.createServer(function (req, res) {
                // 设置响应头信息很重要，浏览器自动识别是否允许跨域请求
              	res.setHeader('Access-Control-Allow-Origin', '*');
                // res.setHeader('Access-Control-Allow-Methods','POST, GET, OPTIONS, DELETE,PATCH');
                // res.setHeader("Access-Control-Max-Age", "3600");
                // res.setHeader("Access-Control-Allow-Headers", "x-requested-with");
                // 是否支持cookie跨域
                // res.setHeader("Access-Control-Allow-Credentials", "true");
              	var data = {
              		success: true,
              		name: 'luolei',
              		pwd: 123456
              	};
              	var query = url.parse(req.url, true).query;
              	var str = query.callback + '(' + JSON.stringify(data) + ')';
              	console.log(query);
              	console.log(str);
              	res.end(str);
              }).listen(8000, '192.168.2.187');`
