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
 * @param {any} sourceId 
 * @param {any} imgFormat 
 * @param {any} callback 
 */
function convertImgToBase64(sourceId, imgFormat, callback) {
	var canvas = document.createElement('CANVAS'),
		ctx = canvas.getContext('2d'),
		img = new Image();
	img.crossOrigin = 'Anonymous';
	img.src = getFileUrl(sourceId);
	img.onload = function () {
		canvas.height = img.height;
		canvas.width = img.width;
		ctx.drawImage(img, 0, 0);
		var dataURL = canvas.toDataURL(imgFormat || 'image/png');
		callback.call(this, dataURL);
		canvas = null;
	};
}
/**
 * 
 */
document.querySelector("#submit").onclick = function () {
	convertImgToBase64("myfile", '', function (base64Img) {
		console.log(base64Img);
		// Base64DataURL
	});
};

// 示例:
(function () {
	function convertImgToBase64(sourceId, imgFormat, callback) {
		var canvas = document.createElement('CANVAS'),
			ctx = canvas.getContext('2d'),
			img = new Image();
		img.crossOrigin = 'Anonymous';
		img.src = getFileUrl(sourceId);
		img.onload = function () {
			canvas.height = img.height;
			canvas.width = img.width;
			ctx.drawImage(img, 0, 0);
			var dataURL = canvas.toDataURL(imgFormat || 'image/png');
			callback.call(this, dataURL);
			canvas = null;
		};
	}

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
})()