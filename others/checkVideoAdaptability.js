(function (win) {
  /**
   * @method checkVideoAdaptability 检查视频源和浏览器的兼容性
   * @param {string} src 视频源链接
   * @param {Object} options 相关配置,可以不传
   * @returns {Object} result
   * ```javascript
   * {
   *  isCanPlay: isCanPlay, // 视频是否可播放
   *  browserVersion: browserVersion, // 浏览器版本号
   *  tips: tips  // IE10 以下浏览器提示信息
   * }
   * ```
   */
  win.checkVideoAdaptability = function (src, options) {
    if (!src || Object.prototype.toString.call(src) != '[object String]') {
      throw new Error('视频源地址格式错误!');
    }
    if (src.trim() == '') {
      throw new Error('视频源地址格式错误!');
    }
    if (Object.prototype.toString.call(options) !== '[object Object]') {
      options = { type: '.m3u8' };
    }
    var userAgent = navigator.userAgent;
    var isIE = (isCanPlay = false);
    var browserVersion = '';
    var tips = '';
    var _tips =
      '<style>' +
      '.ie-warning{width:100%;height:100%;text-align:center;display:-webkit-box;display:-ms-flex;display:flex;-webkit-box-orient:vertical;webkit-box-direction:normal;-ms-flex-direction:column;flex-direction:column;-webkit-box-pack:center;-ms-flex-pack:center;justify-content:center;-webkit-box-align:center;-ms-flex-align:center;align-items:center;background:#4b4b4b;color:#fff;line-height:1.15;font-weight:700;font-size:16px;font-family:Arial,Microsoft YaHei,Microsoft Sans Serif,Microsoft SanSerf,微软雅黑 !important;}' +
      '.ie-warning .ie-warning-box{width:100%;position:absolute;left:50%;top:50%;transform:translate(-50%, -50%);}' +
      '.ie-warning .ie-warning-title{margin:10px 0;padding:0;font-size:19px;}' +
      '.ie-warning a{color:#fff;text-decoration:underline;cursor:pointer;outline:none;float:none !important;}' +
      '.ie-warning .ie-warning-text{margin-bottom:10px;}' +
      '</style>' +
      '<div class="ie-warning">' +
      '<div class="ie-warning-box">' +
      '<p class="ie-warning-title">Flash Player已于2020年12月31日终止服务，详情参阅<a href="https://www.adobe.com/products/flashplayer/end-of-life.html" target="_blank">官方说明</a></p>' +
      '<p class="ie-warning-text">为保障您的直播观看体验，请使用支持HTML5的浏览器进行观看</p>' +
      '<p class="ie-warning-text">推荐使用新版 <a href="https://www.microsoft.com/zh-cn/edge" target="_blank">Edge</a>、<a href="https://www.google.cn/chrome/" target="_blank">Chrome</a>、<a href="https://support.apple.com/zh_CN/downloads/safari" target="_blank">Safari</a> 等浏览器</p>' +
      '</div>' +
      '</div>';
    var isLive = src.indexOf(options.type) !== -1 ? true : false;
    if (userAgent.indexOf('Firefox') !== -1) {
      browserVersion = userAgent.match(/Firefox\/[\d.]+/gi)[0];
    } else if (userAgent.indexOf('Edge') !== -1) {
      browserVersion = userAgent.match(/Edge\/[\d.]+/gi)[0];
    } else if (userAgent.indexOf('Opera') !== -1) {
      browserVersion = userAgent.match(/Opera\/[\d.]+/gi)[0];
    } else if (userAgent.indexOf('Chrome') !== -1) {
      browserVersion = userAgent.match(/Chrome\/[\d.]+/gi)[0];
    } else if (userAgent.indexOf('Safari') !== -1) {
      browserVersion = userAgent.match(/Safari\/[\d.]+/gi)[0];
    } else if (userAgent.indexOf('MSIE') !== -1 || userAgent.indexOf('Trident') !== -1) {
      isIE = true;
      browserVersion =
        'IE ' +
        (userAgent.indexOf('MSIE') !== -1
          ? userAgent.match(/MSIE\s*[\d.]+/gi)[0].match(/[\d.]+/)[0]
          : userAgent.indexOf('Trident') !== -1
            ? parseInt(userAgent.match(/Trident\/[\d.]+/gi)[0].match(/[\d.]+/)) + 4
            : '');
    }

    if (isIE) {
      var version = browserVersion.match(/[\d.]+/)[0];
      if (version > 10) {
        isCanPlay = true;
        tips = '';
      } else if (version > 8) {
        isCanPlay = isLive ? false : true;
        tips = isLive ? _tips : '';
      } else {
        isCanPlay = false;
        tips = _tips;
      }
    } else {
      isCanPlay = true;
      tips = '';
    }

    return { isCanPlay: isCanPlay, browserVersion: browserVersion, tips: tips };
  };
})(window);
var result = checkVideoAdaptability(
  'https://play.xcar.com.cn/6c982460vodcq1500001977/f842d0c95285890810537505832/playlist.m3u8'
);
if (!result.isCanPlay) {
  document.getElementById('msgBox').innerHTML = result.tips;
}
console.log(result);

; (function () {
  // 浏览器小于等于 IE11 提示
  window.lteIE11 = function () {
    var ua = window.navigator.userAgent;
    if (ua.indexOf('MSIE') === -1 && ua.indexOf('Trident') === -1) {
      return false;
    }
    var version = ua.indexOf('MSIE') !== -1
      ? ua.match(/MSIE\s*[\d.]+/gi)[0].match(/[\d.]+/)[0]
      : ua.indexOf('Trident') !== -1
        ? parseInt(ua.match(/Trident\/[\d.]+/gi)[0].match(/[\d.]+/)) + 4
        : '';

    if (version > 11) {
      return false;
    }

    var $warningBox = document.querySelector('.ie-warning-box');
    if ($warningBox != null && typeof $warningBox == 'object') {
      $warningBox.style.display = 'block';
      return true;
    }

    var _tips = '<style>' +
      '.ie-warning-box {' +
      'position: fixed;' +
      'top: 0;' +
      'left: 0;' +
      'width: 100%;' +
      'height: 100%;' +
      'z-index: 9;' +
      'background-color: rgba(00, 00, 00, 0.4);' +
      '}' +
      '.ie-warning-box .ie-warning-content {' +
      'position: absolute;' +
      'top: 50%;' +
      'left: 50%;' +
      'width: 500px;' +
      'height: 200px;' +
      'transform: translate(-50%, -50%);' +
      'background-color: #fff;' +
      'border-radius: 10px;' +
      '}' +
      '.ie-warning-box .ie-warning-content .ie-icon-close {' +
      'display: inline-block;' +
      'width: 32px;' +
      'height: 32px;' +
      'background: url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAEAAAABACAYAAACqaXHeAAAAAXNSR0IArs4c6QAAAjtJREFUeF7tmt8qBVEYxX/nfdx5AS+BiIiIiIiI/I+IiIiIiIhbD8ADuPUUXsClvjqnxrQ3M3vPnqn59rk88+351lqz1syevaeB8l9DOX+iANEByhWIEVBugHgTjBGIEVCuQIyAcgPEp4BPBNaATuAbeAU2SnZTq/8X8O7a30eAN6AjQXoV2CpJhBVgM9HrE2hz6e0jwAfQnmq6DOy4AMkxZgnYTtVXIoBYcN0AfBHYy0EoT+kCsGsYIDicIujjAMGRtmIL2zxwkIdZhto5YN9Q5xU9XwEEj8mS8v8scJSBWJaSGeDQUOgduSIEEFw2a04DJ1kY/lEzBRyHilpRAgg+m0UngTNHESaAU8PYwiJWpACC02bVceAipwhjwLlhTJHRCjITtFl2FLjKKMIIcGmoLSJSv05btANaJ7dZdxi4+UeEIeDaUOMTJWvLUAJIQ5uFB4E7C6IB4NZwzCVCmcwWUgABYLNyP/CQQtgH3BtQ54lOJtLJotACSC+bpXuBpyaYHuDRgD5LZHKTLlsA6WezdncTzLOBxV9R8SJdhQDS02ZxExlTRAojXZUA0tdm9SSmZDSCkK5SAOndBZgsL8ckEi/BWScalHETTPNRLYDqCKi+Cap+DKqeCKmeCqt+GVL9Oqx6QUT1kpjqRVHVy+KqN0ZUb42p3xxVvz2u/gMJ9Z/IlLlyFaxXFUtiwci4nDgK4KJancZEB9TparpwiQ5wUa1OY6ID6nQ1XbhEB7ioVqcx0QF1upouXH4AJriGQet4IxkAAAAASUVORK5CYII=) center center no-repeat;' +
      'background-size: 100% 100%;' +
      'position: absolute;' +
      'top: 10px;' +
      'right: 10px;' +
      'cursor: pointer;' +
      '}' +
      '.ie-warning-box .ie-warning-content .ie-warning-body {' +
      'height: 100%;' +
      'padding: 20px;' +
      'box-sizing: border-box;' +
      'display: -webkit-box;' +
      '-webkit-box-orient: vertical;' +
      'display: flex;' +
      'flex-flow: column nowrap;' +
      'justify-content: center;' +
      'align-items: center;' +
      '}' +
      '.ie-warning-box .ie-warning-content .ie-warning-body .ie-warning-text {' +
      'margin: 0;' +
      'padding: 0;' +
      'font-size: 18px;' +
      'line-height: 1.8;' +
      '}' +
      '</style>' +
      '<div class="ie-warning-box">' +
      '<div class="ie-warning-content">' +
      '<div class="ie-warning-header">' +
      '<i class="ie-icon-close"></i>' +
      '</div>' +
      '<div class="ie-warning-body">' +
      '<p class="ie-warning-text">您当前浏览器的版本过低, 为了您的使用体验<br />请升级使用新版 <a href="https://www.google.cn/chrome/"target="_blank">Chrome</a>、' +
      '<a href="http://www.firefox.com.cn/download/#product-desktop-release">Firefox</a>、' +
      '<a href="https://www.microsoft.com/zh-cn/edge" target="_blank">Edge</a>' +
      '<!-- <a href="https://support.apple.com/zh_CN/downloads/safari" target="_blank">Safari</a> -->等浏览器' +
      '</p>' +
      '</div>' +
      '</div>' +
      '</div>';
    document.body.innerHTML += _tips;
    document.querySelector('.ie-warning-box .ie-icon-close').addEventListener('click', function (evt) {
      evt.stopPropagation();
      document.querySelector('.ie-warning-box').style.display = 'none';
    });
    return true;
  }
  lteIE11();
})();
