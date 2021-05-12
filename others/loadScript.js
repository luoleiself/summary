function loadScript(url, callBack) {
  if (!/^((https?)?:)?\/\/.*/gim.test(url)) {
    console.log('url 不正确...');
    return false;
  }
  var headDOM = document.getElementsByTagName('head')[0];
  var script = document.createElement('script');
  script.type = 'text/javascript';
  script.onload = script.onreadystatechange = function () {
    if (!this.readyState || this.readyState === 'loaded' || this.readyState === 'complete') {
      callBack && callBack();
      script.onload = script.onreadystatechange = null; // Handle memory leak in IE
    }
  };
  script.src = url;
  headDOM.appendChild(script);
}
