// 函数防抖
export const debounce = function (fn, delay) {
  if (typeof fn !== 'function') throw new Error('fn is not Function');
  delay = delay >= 0 ? delay : 300;

  let timer;
  return function () {
    let context = this;
    let args = arguments;

    if (timer) clearTimeout(timer);

    timer = setTimeout(() => {
      fn.apply(context, args);
    }, delay);
  };
};
// 函数节流
export const throttle = function (fn, delay) {
  if (typeof fn !== 'function') throw new Error('fn is not Function');
  delay = delay >= 0 ? delay : 300;

  var previous = 0;
  return function () {
    var _this = this;
    var args = arguments;
    var now = new Date();
    if (now - previous > delay) {
      fn.apply(_this, args);
      previous = now;
    }
  };
};
