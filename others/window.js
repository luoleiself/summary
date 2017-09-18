// 修改历史记录阻止后退功能
$(document).ready(function () {
  if (window.history && window.history.pushState) {
    $(window).on('popstate', function () {
      window.history.pushState('forward', null, '');
      window.history.forward(1);
    });
  }
  window.history.pushState('forward', null, ''); //在IE中必须得有这两行
  window.history.forward(1);
});

// js调用本地摄像头拍照
var video = document.querySelector("video");
var canvas = document.querySelector('canvas');
// 调用媒体设备
navigator.mediaDevices.getUserMedia({
  // audio: true,
  video: true
}, function (mediaStream) { // 成功时回调函数
  video.src = window.URL.createObjectURL(mediaStream);
  video.play();
}, function (error) { // 失败时回调函数
  alert('video error: ' + err);
});
var context = canvas.getContext('2d');
//捕获并保存帧内容
function captureAndSaveFrame() {
  context.drawImage(video, 0, 0, 300, 300);
  console.log(canvas.toDataURL()); //转为base64并保存
}
//定时捕获
function timer(delta) {
  setTimeout(function () {
    captureAndSaveFrame();
    timer(delta)
  }, delta || 500);
}
timer();


// js 模拟 $选择器
window.$ = HTMLElement.prototype.$ = function (selector) {
  var r = (this == window ? document : this).querySelectorAll(selector);
  return r.length == 0 ? null : r.length == 1 ? r[0] : r;
}