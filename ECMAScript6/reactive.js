const toProxy = new WeakMap();
const toRaw = new WeakMap();
function trigger() {
  console.log('trigger methods was triggered...');
}
function isObject(target) {
  return target !== null && typeof target === 'object';
}
function reactive(target) {
  if (!isObject(target)) {
    return target;
  }
  let proxy = toProxy.get(target);
  if (proxy) {
    // 如果存在代理对象则直接返回
    return proxy;
  }
  if (toRaw.has(target)) {
    // 如果对象已经被代理过了则直接返回该对象
    return target;
  }
  const handlers = {
    get(target, key, receiver) {
      const res = Reflect.get(target, key);
      if (isObject(res)) {
        return reactive(res); // 如果为嵌套对象时,递归响应式代理
      }
      return res;
    },
    set(target, key, value, receiver) {
      console.log(key);
      if (Reflect.has(target, key)) {
        trigger();
      }
      return Reflect.set(target, key, value);
    },
    deleteProperty(target, key) {
      return Reflect.deleteProperty(target, key);
    },
  };
  const observed = new Proxy(target, handlers);
  toProxy.set(target, observed); // 缓存代理对象
  toRaw.set(observed, target); // 缓存代理对象
  return observed;
}

// var obj = { name: 'a', age: 18 };
// var p = reactive(obj);
// console.log(p.name);
// var p1 = reactive(p);
// console.log(p1.name);
// console.log('---------------------------');

// var arr = [1, 2, 3];
// var p = reactive(arr);
// p.push(4);
// console.log('---------------------------');

var obj = { name: 'a', age: 18, arr: [1, 2, 3] };
var p = reactive(obj);
p.arr.push(5);
