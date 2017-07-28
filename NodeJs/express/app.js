var express = require('express');
var fs = require('fs');
var querystring = require('querystring');
// var http = require('http');
var app = express();
app.listen(3000, 'localhost');
// app.get 请求:
/* app.get('/:id(\\d+)/:name?/:age?', function (req, res, next) {
  if (req.params.id > 10) {
    next(); // http://localhost:3000/20
  } else {
    res.send('id参数值必须大于10...');
  }
})
app.get('/:id/:name?/:age?', function (req, res, next) {
  // http://localhost:3000/20/2
  res.send('next() => /:id/:name?/:age?');
  console.dir(req.params);
  // { id: 20, name: 2 }
})
*/
/* app.get('/:id(\\d+)?/', function (req, res, next) {
  // http://localhost:3000/12/?id=001&name=james&age=18
  if (req.params.id <= 10) {
    res.send('req.params的参数值必须大于10...');
  } else {
    res.send('Hello world.......<br>querystring.....');
    console.log(req.params); // { id: 12 }
    console.log(req.query); // { id: 001, name: 'james', age: 18}
  }
}) */
// app.post 请求:
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
// app.put 请求:
app.put('/index.html', function (req, res) {
  req.on('data', function (data) {
    console.log(JSON.parse(data.toString())); // { name:'haha', age: 27 }
  })
})
// 处理所有请求
app.all('/index.html', function (req, res, next) {
  req.on('data', function (data) {
    console.log(data);
  })
})