/**
 *  创建 express 服务器:
 */
var express = require('express');
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

