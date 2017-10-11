/**
 * @param {any} sourceId 
 * @returns String [imgSrc]
 */
function getFileUrl(sourceId) {
	var url;
	if (navigator.userAgent.indexOf("MSIE") >= 1) { // IE
		url = document.getElementById(sourceId).value;
	} else if (navigator.userAgent.indexOf("Firefox") > 0) { // Firefox
		url = window.URL.createObjectURL(document.getElementById(sourceId).files.item(0));
	} else if (navigator.userAgent.indexOf("Chrome") > 0) { // Chrome
		url = window.URL.createObjectURL(document.getElementById(sourceId).files.item(0));
	}
	return url;
}
/**
 * @param {any} url 
 * @param {any} callback 
 * @param {any} outputFormat 
 */
function convertImgToBase64(url, callback, outputFormat) {
	var canvas = document.createElement('CANVAS'),
		ctx = canvas.getContext('2d'),
		img = new Image;
	img.crossOrigin = 'Anonymous';
	img.onload = function () {
		canvas.height = img.height;
		canvas.width = img.width;
		ctx.drawImage(img, 0, 0);
		var dataURL = canvas.toDataURL(outputFormat || 'image/png');
		callback.call(this, dataURL);
		canvas = null;
	};
	img.src = url;
}
/**
 * 
 */
document.querySelector("#submit").onclick = function () {
	var fsrc;
	fsrc = getFileUrl("myfile");
	convertImgToBase64(fsrc, function (base64Img) {
		console.log(base64Img);
		// Base64DataURL
	});
};