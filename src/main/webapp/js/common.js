//*********************工具类js,不要用$(function(){});把函数包起来**********************//

/**
 * 网站确认
 * @param {Object} title 提示标题 主题提示信息,醒目
 * @param {Object} content 内容,小字内容,详细说明
 */
function oilConfirm(title, content) {
	$.confirm({
		icon: 'fa fa-question',
		theme: 'modern',
		closeIcon: true,
		animation: 'scale',
		type: 'blue',
		title: title,
		content: content,
	});
}
/**
 * 警告框 
 * @param {Object} content 警告内容
 */
function oilAlert(content) {
	$.alert(content);
}

/**
 * 参数检查,提示内容
 * TODO: 后期改进提示方式，更加友好点
 * @param {Object} data 需要检验的参数
 * @param {Object} msg 提示的主题信息
 * @param {Object} content 信息信息
 */
function checkParam(data, msg, content) {
	if(data == null || data == undefined || data == '') {
		oilConfirm(msg, content);
		return false;
	}
	return true;
}


/**
 * 格式化时间戳
 * @param {Object} fmt
 */
Date.prototype.Format = function(fmt) { //author: meizz 
	var o = {
		"M+": this.getMonth() + 1, //月份 
		"d+": this.getDate(), //日 
		"h+": this.getHours(), //小时 
		"m+": this.getMinutes(), //分 
		"s+": this.getSeconds(), //秒 
		"q+": Math.floor((this.getMonth() + 3) / 3), //季度 
		"S": this.getMilliseconds() //毫秒 
	};
	if(/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
	for(var k in o)
		if(new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
	return fmt;
}