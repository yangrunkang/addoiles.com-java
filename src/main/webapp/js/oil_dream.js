$(function() {
	console.log('oil_dreams');
	
	$("#showDreamBtn").click(function() {
				
		var dreamTitle = $("#dreamTitle").val();
		var dreamContent = $("#dreamContent").val();
		
		if(checkParam(dreamTitle, "写下你疯狂的梦想",null) && checkParam(dreamContent, "你的梦想是啥?丢失了吗?",null)) {
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
					}else{
						oilAlert("抱歉,服务器故障,给您带来麻烦了")
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

});