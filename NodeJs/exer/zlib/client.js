var zlib = require("zlib");
var http = require("http");
var fs = require("fs");
var options = {
	host:"localhost",
	path:"/",
	port:"8888",
	headers:{"accept-encoding":"gzip,deflate"}
}
var request = http.get(options,function(response){
	var output = fs.createWriteStream("test2.txt");
	switch(response.headers["content-encoding"]){
		case "gzip":
			response.pipe(zlib.createGunzip()).pipe(output);
			break;
		case "deflate":
			response.pipe(zlib.createInflate()).pipe(output);
			break;
		default:
			response.pipe(output);
			break;
	}
})