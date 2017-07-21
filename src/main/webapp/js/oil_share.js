$(function() {
	var base_url = window.location.origin;
	
	/**
	 * 发表热门功能
	 */
	$("#share_btn").click(function() {
		var title = $("input[name='title']").val();
		var content = $("textarea[name='content']").val();
		
		if(checkParam(title, "请输入标题") && checkParam(content, "请输入内容")) {
			$.ajax({
				url: base_url + "/share",
				dataType: "json",
				type: "post",
				data: {
					"title": title,
					"content": content
				},
				success: function(result) {
					if(result.code == 0) {
						//追加内容
						var oilShare = result.data;
						$(".panel.panel-primary:first").after("<div class='panel panel-primary'><div class='panel-heading'>" +
							"<h3 class='panel-title'>" + oilShare.title + "</h3>" +
							"</div><div class='panel-body'>" + oilShare.content + "</div></div>");
						var length = $(".panel.panel-primary").length;
						//移除最后一个元素
						if(length >= 6) {
							$(".panel.panel-primary:last").remove();
						}
						//清空输入框内容
						$("input[name='title']").val('');
						$("textarea[name='content']").val('')
					}
				}
			});
		}

	});

	/**
	 * 参数检查,提示内容
	 * TODO: 后期改进提示方式，更加友好点
	 * @param {Object} data
	 * @param {Object} msg
	 */
	function checkParam(data, msg) {
		if(data == null || data == undefined || data == '') {
			alert(msg);
			return false;
		}
		return true;
	}
});