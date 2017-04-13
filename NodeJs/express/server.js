var app = require("express")();
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
//
