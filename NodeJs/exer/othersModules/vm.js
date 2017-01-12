var vm = require("vm");
var obj = {name:"Hello World"};
var context1 = vm.createContext(obj);
vm.runInContext("name = 'HeHe'",context1);
console.log(context1.name);
var context2 = vm.createContext(obj);
vm.runInContext("name = 'HeiHei'",context2);
console.log(context2.name);
