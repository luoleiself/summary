# Hello World!

[let和const命令](https://github.com/luoleiself/summary/blob/master/ECMAScript6/letAndconst.js)
 
[变量的解构赋值](https://github.com/luoleiself/summary/blob/master/ECMAScript6/variableDeconstruct.js)

[字符串的扩展](https://github.com/luoleiself/summary/blob/master/ECMAScript6/stringExpand.js)

  String.codePointAt();String.fromCodePoint();at();normalize();includes();startsWith();endsWith();
  repeat();padStart();padEnd();String.raw();

[正则的扩展](https://github.com/luoleiself/summary/blob/master/ECMAScript6/regexpExpand.js)

  u;y;s;
  RegExp.sticky;RegExp.flags;RegExp.escape();

[数值的扩展](https://github.com/luoleiself/summary/blob/master/ECMAScript6/numberExpand.js)
  
  Number.EPSILON;  
  Number.parseInt();Number.parseFloat();Number.isInteger();
  Math.trunc();Math.sign();Math.cbrt();Math.clz32();Math.imul();Mahtl.fround();Math.hypot();
  Math.signh();Math.cosh();Math.tanh();Math.asinh();Math.acosh();Math.atanh();
  Math.signbit();
  ```**``` // 指数运算符
  
[数组的扩展](https://github.com/luoleiself/summary/blob/master/ECMAScript6/arrayExpand.js)

 Array.from();Array.of();  
 Array.prototype.copyWithin();Array.prototype.find();Array.prototype.findIndex();Array.prototype.fill();
 Array.prototype.entries();Array.prototype.keys();Array.prototype.values();Array.prototype.includes()

[函数的扩展](https://github.com/luoleiself/summary/blob/master/ECMAScript6/funcExpand.js)

 ...运算符;func.length;func.name;=>;尾调用;尾逗号;

[对象的扩展](https://github.com/luoleiself/summary/blob/master/ECMAScript6/objectExpand.js)

 简洁表示法;属性名表达式;  
 .name;  
 Object.is();Object.assign();Object.setPrototypeOf();Object.getPrototypeOf();  
 Object.keys();Object.values();Object.entries();Object.getOwnPropertyDescriptors();  
 Object.getOwnPropertySymbols();

[Symbol](https://github.com/luoleiself/summary/blob/master/ECMAScript6/symbol.js)

 类似字符串的原始数据类型(对象的属性名的两种表示方式);  
 let s = Symbol();Symbol.for();Symbol.keyFor();

[Set 和 Map数据结构](https://github.com/luoleiself/summary/blob/master/ECMAScript6/SetAndMap.js)

 Set:类似于数组的数据结构,成员值唯一;  
 const set = new Set(["a","a","b","c","c"]); // ["a","b","c"];
 Set.prototype.size;
 Set.prototype.add(value);Set.prototype.delete(value);Set.prototype.has(value);Set.prototype.clear();  
 keys();values();entries();forEach();  
 WeakSet:类似于Set的数据结构,成员值唯一,无法遍历;区别:成员只能是对象,不计入垃圾回收机制;    
 WeakSet.prototype.add(value);WeakSet.prototype.delete(value);WeakSet.prototype.has(value);  
 Map:接受任意类型的值作为键名,Object只能接受字符串;  
 const map = new Map([['name', '张三'],['title', 'Author']]);//{"name":"张三","title":"Author"};
 Map.prototype.size;  
 Map.prototype.set(key,value);Map.prototype.get(key);Map.prototype.delete(key);map.prototype.has(key);Map.prototype.clear();  
 keys();values();entries();forEach();  
 与数组,对象,JSON的互转;  
 WeakMap:类似于Map的数据结构,无法遍历;区别:只接受对象作为键名(null除外),不计入垃圾回收机制;  
 WeakMap.prototype.set(key,value);WeakMap.prototype.get(key);WeakMap.prototype.delete(key);WeakMap.prototype.has(key);
 
[Proxy](https://github.com/luoleiself/summary/blob/master/ECMAScript6/proxy.js)

new Proxy(target,handle);  
Proxy.revocable(target,handle); Proxy.prototype.revoke();

[Reflect](https://github.com/luoleiself/summary/blob/master/ECMAScript6/reflect.js)

与Proxy对象的区别:Proxy相当于去修改设置对象的属性行为，而Reflect则是获取对象的这些行为.  
Static function:  
Reflect.apply(target,thisArg,args);Reflect.construct(target,args);Reflect.get(target,name,receiver);
Reflect.set(target,name,value,receiver)Reflect.defineProperty(target,name,desc);Reflect.deleteProperty(target,name);
Reflect.has(target,name);Reflect.ownKeys(target)Reflect.isExtensible(target);Reflect.preventExtensions(target);
Reflect.getOwnPropertyDescriptor(target, name);Reflect.getPrototypeOf(target);Reflect.setPrototypeOf(target, prototype)
