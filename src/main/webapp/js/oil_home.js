$(function() {
	console.log(base_url);
	/**
	 * 发表热门功能
	 */
	$("#share_btn").click(function() {
		var title = $("input[name='title']").val();
		var content = $("textarea[name='content']").val();

		if(checkParam(title, "请输入动弹标题",null) && checkParam(content, "请输入动弹内容",null)) {
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
					}else{
						oilAlert("发布动弹失败了，呜呜")
					}
				}
			});
		}

	});
});