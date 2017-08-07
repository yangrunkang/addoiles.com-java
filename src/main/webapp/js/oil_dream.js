$(function() {
	console.log('oil_dreams');
	
	$("#showDreamBtn").click(function() {
				
		var dreamTitle = $("#dreamTitle").val();
		var dreamContent = $("#dreamContent").val();
		
		if(checkParam(dreamTitle, "写下你疯狂的梦想") && checkParam(dreamContent, "你的梦想是啥?丢失了吗?")) {
			$.ajax({
				url: base_url + "/addDream",
				dataType: "json",
				type: "post",
				data: {
					"dreamTitle": dreamTitle,
					"dreamContent": dreamContent
				},
				success: function(result) {
					if(result.code == 0) {
						var data = result.data;
						var dreamHtml = "<div class='panel panel-success'>"+
											"<div class='panel-heading text-info'><h3><strong>" + data.title + "</strong></h3></div>"+
											"<div class='panel-body'>" + data.content + "</div>"+
											"<div class='panel-footer panel-success text-right'>创建时间:<span class='text-light' title='${leftDream.createTime}'>"+ new Date().Format('yyyy-MM-dd hh:mm:ss')+"</span></div>"+
										"</div>";
						
						//追加内容
						$(".panel.panel-success:first").before(dreamHtml);
						initDream();
						
					}
				}
			});
		}
	});
	
	/**
	 * 初始化梦想墙相关元素
	 */
	function initDream(){
		//清空输入框内容
		$("#dreamTitle").val('');
		$("#dreamContent").val('');
	}
	
	/**
	 * 参数检查,提示内容
	 * TODO: 后期改进提示方式，更加友好点
	 * @param {Object} data
	 * @param {Object} msg
	 */
	function checkParam(data, msg) {
		if(data == null || data == undefined || data == '') {
			$.confirm({
				icon: 'fa fa-question',
				theme: 'modern',
				closeIcon: true,
				animation: 'scale',
				type: 'blue',
				title: msg,
				content: "不放弃,不抛弃,追梦之路,不孤单",
			});
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
	
	
	
});