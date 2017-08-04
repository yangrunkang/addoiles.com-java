$(function() {
	$("#experenceBtn").click(function(){
		//1.改变按钮文字
		var btnText = $("#experenceBtn").html();
		if(btnText == '开始书写我的经历'){
			//1.改变文字为"保存"
			$("#experenceBtn").html("保存");
			//2.初始化编辑器
			$('#summernote').summernote({
				height: 400, // set editor height
				minHeight: 500, // set minimum height of editor
				maxHeight: 600, // set maximum height of editor
				focus: true // set focus to editable area after initializing summernote
			});
		}else if(btnText == '保存'){
			//1.调用接口保存文章并追加到下面
			var content = $('#summernote').summernote('code');
			if(content == null || content == undefined || content == '' || content =='<p><br></p>'){
				$.confirm({
					icon: 'fa fa-question',
					theme: 'modern',
					closeIcon: true,
					animation: 'scale',
					type: 'blue',
					title: "我想知道你的精彩经历",
					content: "不放弃,不抛弃,追梦之路,不孤单",
				});
				return;
			}
			
			
			$.ajax({
				url: base_url + "/addExperence",
				dataType: "json",
				type: "post",
				data: {
					"content": content
				},
				success: function(result) {
					if(result.code == 0) {
						$(".experences:first").before("<div class='experences panel panel-default'><div class='panel-heading'>" + content + "</div></div>");
						//2.销毁编辑器和改变按钮文字为'开始书写我的经历' {后期做，继续书写我的另一段奇妙的经历}
						$("#experenceBtn").html("开始书写我的经历");
						//3.清空内容并销毁编辑器
						$('#summernote').summernote('code', '');
						$('#summernote').summernote('destroy');
					}else{
						alert("保存失败");
					}
				}
			});
			
			

		}
	});

});