var express = require('express');
var app = express();
app.listen(3000, 'localhost');
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
