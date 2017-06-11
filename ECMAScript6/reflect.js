1.概述:
  1.将Object对象的一些明显属于语言内部的方法(Object.defineProperty)放到Reflect对象上
  2.修改某些Object方法的返回结果,让其变的更合理
  3.让Object操作都变成函数行为
  4.Reflect对象的方法与Proxy对象的方法一一对应,只要是Proxy对象的方法,就能在Reflect对象上找到对应的方法
2.静态方法:
  1.Reflect.apply(target,thisArg,args)
  2.Reflect.construct(target,args)
  3.Reflect.get(target,name,receiver)
  4.Reflect.set(target,name,value,receiver)
  5.Reflect.defineProperty(target,name,desc)
  6.Reflect.deleteProperty(target,name)
  7.Reflect.has(target,name)
  8.Reflect.ownKeys(target)
  9.Reflect.isExtensible(target)
  10.Reflect.preventExtensions(target)
  11.Reflect.getOwnPropertyDescriptor(target, name)
  12.Reflect.getPrototypeOf(target)
  13.Reflect.setPrototypeOf(target, prototype)
3.实例:使用Proxy实现观察者模式:观察者模式（Observer mode）指的是函数自动观察数据对象，一旦对象有变化，函数就会自动执行
  eg:const queuedObservers = new Set();
    const observe = fn => queuedObservers.add(fn);
    const observable = obj => new Proxy(obj, {set});
    function set(target, key, value, receiver) {
      const result = Reflect.set(target, key, value, receiver);
      queuedObservers.forEach(observer => observer());
      return result;
    }
