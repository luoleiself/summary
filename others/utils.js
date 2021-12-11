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
/**
 * @description 随机生成颜色
 * @return {String}
 */
export const randomColor = function () {
  return '#' + ('00000' + ((Math.random() * 0x1000000) << 0).toString(16)).slice(-6);
};

/**
 * @description 获取浏览器类型和版本
 * @return {String}
 */
export const getExplore = function () {
  var sys = {},
    ua = navigator.userAgent.toLowerCase(),
    s;
  (s = ua.match(/rv:([\d.]+)\) like gecko/))
    ? (sys.ie = s[1])
    : (s = ua.match(/msie ([\d\.]+)/))
    ? (sys.ie = s[1])
    : (s = ua.match(/edge\/([\d\.]+)/))
    ? (sys.edge = s[1])
    : (s = ua.match(/firefox\/([\d\.]+)/))
    ? (sys.firefox = s[1])
    : (s = ua.match(/(?:opera|opr).([\d\.]+)/))
    ? (sys.opera = s[1])
    : (s = ua.match(/chrome\/([\d\.]+)/))
    ? (sys.chrome = s[1])
    : (s = ua.match(/version\/([\d\.]+).*safari/))
    ? (sys.safari = s[1])
    : 0;
  // 根据关系进行判断
  if (sys.ie) return 'IE: ' + sys.ie;
  if (sys.edge) return 'EDGE: ' + sys.edge;
  if (sys.firefox) return 'Firefox: ' + sys.firefox;
  if (sys.chrome) return 'Chrome: ' + sys.chrome;
  if (sys.opera) return 'Opera: ' + sys.opera;
  if (sys.safari) return 'Safari: ' + sys.safari;
  return 'Unkonwn';
};
// 复制粘贴板
export const copyText = (text) => {
  // 数字没有 .length 不能执行selectText 需要转化成字符串
  const textString = text.toString();
  let input = document.querySelector('#copy-input');
  if (!input) {
    input = document.createElement('input');
    input.id = 'copy-input';
    input.readOnly = 'readOnly'; // 防止ios聚焦触发键盘事件
    input.style.position = 'absolute';
    input.style.left = '-10000px';
    input.style.zIndex = '-1000';
    document.body.appendChild(input);
  }

  input.value = textString;
  // ios必须先选中文字且不支持 input.select();
  selectText(input, 0, textString.length);
  console.log(document.execCommand('copy'), 'execCommand');
  if (document.execCommand('copy')) {
    document.execCommand('copy');
  }
  input.blur();

  // input自带的select()方法在苹果端无法进行选择，所以需要自己去写一个类似的方法
  // 选择文本。createTextRange(setSelectionRange)是input方法
  function selectText(textbox, startIndex, stopIndex) {
    if (textbox.createTextRange) {
      //ie
      const range = textbox.createTextRange();
      range.collapse(true);
      range.moveStart('character', startIndex); //起始光标
      range.moveEnd('character', stopIndex - startIndex); //结束光标
      range.select(); //不兼容苹果
    } else {
      //firefox/chrome
      textbox.setSelectionRange(startIndex, stopIndex);
      textbox.focus();
    }
  }
};

/* 扁平数据结构转 tree */
export const arrayToTree = function (arr) {
  const result = []; // 存放结果集
  const itemMap = {};
  for (const item of arr) {
    const id = item.id;
    const pid = item.pid;

    if (!itemMap[id]) {
      itemMap[id] = { children: [] };
    }

    itemMap[id] = { ...item, children: itemMap[id]['children'] };

    const treeItem = itemMap[id];

    if (pid === 0) {
      result.push(treeItem);
    } else {
      if (!itemMap[pid]) {
        itemMap[pid] = { children: [] };
      }
      itemMap[pid].children.push(treeItem);
    }
  }
  return result;
};
