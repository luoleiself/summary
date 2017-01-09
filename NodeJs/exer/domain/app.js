var domain = require("domain");
var fs = require("fs");
var d = domain.create();
d.name = "dl";
d.on("error",function(err){
	console.log("%s捕获到异常!",d.name,err)
});
d.run(function(){
	process.nextTick(function(){
		setTimeout(function(){
			fs.open("non-existent file","r",function(err,fd){
				if(err){throw err;}
			})
		},1000)
	})
})