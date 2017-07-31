#### [express在线文档](http://www.expressjs.com.cn/)
1. 创建 `express` 服务器: 
    *  `var app = require('express')();`
    *  使用 NodeJs 提供的 http/https 模块创建 express:
       ```
          var http = require('http');
          var express = require('express')();
          var server = http.createServer(app).listen(3000,'localhost');
          ver server = https.createServer(options,app).listen(3000,'localhost');
       ```
2. 监听指定地址及端口: `app.listen(3000,'localhost');`
3. 设置路由:
    1. :  ?  (\\d+)正则表达式 : 设置路由
       ```
          app.get(path, [callback...], callback);
          app.get('/:id(\\d+)?',function(req,res,next){
            // http://localhost:3000/11/?uid=001&name=james
            console.log(req.params); // 获取路由参数
            // { id: 11 }
            console.log(req.query); // 获取请求携带的参数
            // { uid: 001, name: james }
          })
       ```
    2. 请求方式: get/post/put/delete/all(接收所有请求)  
       ```
          app.all('/index.html',function(req,res,next){
              next(); // 调用下一个使用该相同路由的请求方法  
          }) 
       ```
        
4. express 实例方法:
    1. res.send(param);  // express 框架为 http.ServerResponse 对象提供的方法,代替 writeHead、setHead、end 方法
       ```
          app.all('/index.html',function(req,res,next){
            res.send('Hello World');  // 代替 writeHead、setHead、end 方法
          })
       ```
    2. res.sendFile(fileName); // express 框架提供的发送文件的方法 
       ```
          app.all('/index.html',function(req,res,next){
            /* res.writeHead(200, {
                  'Content-Type': 'text/html'
              });
              res.write('<head><meta charset=utf-8><title>使用post请求发送数据</title></head>');
              var file = fs.createReadStream('index.html');
              file.pipe(res); */
            res.sendFile(__dirname + '/index.html'); // 可以替换上面的发送文件方法
          })
       ```
       
5. 中间件: 一个中间件为一个处理客户端请求的函数   
    1.  定义中间件:
        ```
           var setHeaher = function(){
             return function(req,res,next){
                res.statusCode = 200;
                res.header = {'Content-Type':'text/html'};
                res.head = '<head><meta charset=utf-8></head>';
                next();
             }
           }
           exports.setHeader = setHeader;
        ```
    2. 使用中间件: app.use([path], function)
       ```
          var middleWare = require('./middleWare');
          app.use('/static', middleWare.setHeader());
       ```
    3. express 框架提供的中间件:  http://www.expressjs.com.cn/resources/middleware.html
       
