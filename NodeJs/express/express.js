/**
 *  创建 express 服务器:
 */
var express = require('express');
var fs = require('fs');
var querystring = require('querystring');
// var http = require('http');
var app = express();
app.listen(3000, 'localhost');
// 使用 NodeJs 提供的 http/https 模块创建服务器
// http.createServer(app).listen(3000); 
// https.createServer(options, app), listen(443);
app.get('./index.html', function (req, res) {
  /* res.writeHead(200, {
    'Content-Type': 'text/html'
  });
  res.write('<head><meta charset="utf-8"></head>');
  res.end('你好'); */
  res.send('你好');
  // express 框架中,为 http.ServerResponse 对象提供了一个send方法,
  // 使用该方法时,不需要使用该对象的 writeHead 方法或者 setHeader 方法来设置响应信息,
  // 不需要使用该对象的 end 方法来结束响应,此方法等于上面三个方法
})
/**
 *  设置路由( : 和 ? 匹配路由,正则表达式)
 */
app.get('/:id(\\d+)/:name?/:age?', function (req, res, next) {
  if (req.params.id > 10) {
    next(); // http://localhost:3000/20
  } else {
    res.send('id参数值必须大于10...');
  }
})
app.get('/:id/:name?/:age?', function (req, res, next) {
  // http://localhost:3000/20/2
  res.send('next() => /:id/:name?/:age?');
  console.dir(req.params); // { id: 20, name: 2 }
})
app.get('/', function (req, res, next) {
  // http://localhost:3000/
  res.send('Hello world...');
})
/**
 *  带查询参数的请求: /:id(\\d+)?/?id=001&name=james&age=18
 */
app.get('/:id(\\d+)?/', function (req, res, next) {
  // http://localhost:3000/12/?id=001&name=james&age=18
  if (req.params.id <= 10) {
    res.send('req.params的参数值必须大于10...');
  } else {
    res.send('Hello world.......<br>querystring.....');
    console.log(req.params); // { id: 12 }
    console.log(req.query); // { id: 001, name: 'james', age: 18}
  }
})
/**
 *  POST 请求: app.post(path, callback);
 */
app.get('/index.html', function (req, res) {
  /* res.writeHead(200, {
    'Content-Type': 'text/html'
  });
  res.write('<head><meta charset=utf-8><title>使用post请求发送数据</title></head>');
  var file = fs.createReadStream('index.html');
  file.pipe(res); */
  res.sendFile(__dirname + '/index.html'); // express 提供的发送文件方法
  console.log(__dirname); // 当前执行文件所在目录的完整目录名(绝对路径)
  console.log(__filename); // 当前执行文件的带有完整绝对路径的文件名(绝对路径)
  console.log(process.cwd()); // 当前执行node命令的完整目录名(绝对路径)
})
app.post('/index.html', function (req, res) {
  req.on('data', function (data) {
    console.log(querystring.parse(data.toString()));
  })
  req.on('end', function () {
    console.log('客户端数据读取完毕...');
  });
})
/**
 *  put 请求、delete 请求、all 请求: app.put/delete/all(path,callback);
 */
/**
 * 中间件的使用:
 */
// 定义中间件
var setHeader = function(){
  return function(req,res,next){
    res.statusCode = 200;
    res.header = {'Content-Type':'text/html'};
    res.head = '<head><meta charset=utf-6></head>'
    next(); // 调用下一个相同路由的方法
  } 
}
exports.setHeader = setHeader;
// 使用中间件
var middleWare = require('./middleWare');
app.use('/static',middleWare.setHeader());
/**
*  express 框架提供的中间件
*/
// cookie-parser: 获取客户端发送的 cookie
npm i -g cookie-parser // 安装中间件,express 4.x以后不在内置中间件,只保留express.static
var cookieParser = require('cookie-parser');
app.use(cookieParser());
app.get('/index.html', function(req,res){
  for(var key in req.cookies){
    console.log(key);
    console.log(req.cookies[key]);
  }
  res.end();
})
