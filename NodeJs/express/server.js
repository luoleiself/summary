/*var app = require("express")();
var http = require("http");
app.get("/index.html/:id?/:name?", function(req, res) {
  // res.writeHeader("200",{"content-type":"text/html"});
  // res.write("<head><meta charset='utf-8'></head>");
  // res.end("Hello World\n");
  var str = "";
  if (req.params.id)
    str += "Id参数值: " + req.params.id;
  if (str != "")
    str += "<br>";
  if (req.params.name)
    str += "Name参数值: " + req.params.name;
  res.send(str);
}).listen("9000", "localhost");
// http.createServer(app).listen("9000");
//*/
/*var app = require("express")();
var http = require("http");
app.get("/index.html/:id(\\d+)", function(req, res, next) {
  if (req.params.id > 10) {
    next();
  } else {
    res.send("id参数值必须大于10");
  }
});
app.get("/index.html/:id(\\d+)", function(req, res) {
  res.send("Hello World");
});
app.listen("9000", "localhost");*/
var app = require("express")();
var http = require("http");
app.get("/index", function(req, res) {
  res.writeHeader("200", { "content-type": "text/html" });
  res.write("<head><meta charset='utf-8'></head>");
  res.end("<h1 style='background:#e4393c;color:blue;'>请求路径为/index</h1>");
});
app.get("/about", function(req, res) {
  res.writeHeader("200", { "content-type": "text/html" });
  res.write("<head><meta charset='utf-8'></head>");
  res.end("<h1 style='background:#e4393c;color:blue;'>请求路径为/about</h1>");
});

app.listen("9000", "localhost");
