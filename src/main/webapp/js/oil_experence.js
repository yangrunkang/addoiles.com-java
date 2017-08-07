$(function() {

	var experenceTitle = "无标题:题主很任性,经历很精彩";
	var content = "";

	$("#experenceBtn").click(function() {
		//1.改变按钮文字
		var btnText = $("#experenceBtn").html();
		if(btnText == '开始书写我的经历') {
			//1.改变文字为"保存"
			$("#experenceBtn").html("保存");
			//2.初始化编辑器
			$('#summernote').summernote({
				height: 400, // set editor height
				minHeight: 500, // set minimum height of editor
				maxHeight: 600, // set maximum height of editor
				focus: true // set focus to editable area after initializing summernote
			});
		} else if(btnText == '保存') {
			//1.验证内容
			content = $('#summernote').summernote('code');
			if(content == null || content == undefined || content == '' || content == '<p><br></p>') {
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
			//2.填写经历标题
			var experenceName = "题主很任性,精力很精彩"
			$.confirm({
				title: '总结下吧',
				content: '' +
					'<form action="" class="formName">' +
					'<div class="form-group">' +
					'<label>为你的经历添加一个标题吧</label>' +
					'<input type="text" placeholder="刻骨铭心的标题" class="name form-control" required />' +
					'</div>' +
					'</form>',
				buttons: {
					formSubmit: {
						text: '我写好了',
						btnClass: 'btn-blue',
						action: function() {
							var name = this.$content.find('.name').val();
							if(!name) {
								$.alert('呜呜呜,没有名字啊,我读书少,不要骗我啊');
								return false;
							}
							//3.调用接口保存文章并追加到下面
							experenceTitle = name;
							saveExperence();
						}
					},
					cancel: {
						text: '不想写,就这样保存吧',
						btnClass: 'btn-blue',
						action: function() {
							//close
							saveExperence();
						}
					}
				},
				onContentReady: function() {
					// bind to events
					var jc = this;
					this.$content.find('form').on('submit', function(e) {
						// if the user submits the form by pressing enter in the field.
						e.preventDefault();
						jc.$$formSubmit.trigger('click'); // reference the button and click it
					});
				}
			});

		}
	});

	/**
	 * 保存经历到服务器
	 */
	function saveExperence() {
		console.log("content:" + content + ",experenceTitle:" + experenceTitle);
		$.ajax({
			url: base_url + "/addExperence",
			dataType: "json",
			type: "post",
			data: {
				"content": content,
				"title": experenceTitle
			},
			success: function(result) {
				if(result.code == 0) {
					$(".experences:first").before("<div class='experences panel panel-default'>" +
						"<div class='panel-heading'>" + experenceTitle + "</div>"+
						"<div class='panel-body'>" + content + "</div></div>");
					//2.销毁编辑器和改变按钮文字为'开始书写我的经历' {后期做，继续书写我的另一段奇妙的经历}
					$("#experenceBtn").html("开始书写我的经历");
					//3.清空内容并销毁编辑器
					$('#summernote').summernote('code', '');
					experenceTitle = "无标题:题主很任性,经历很精彩";
					content = "";
					$('#summernote').summernote('destroy');
				} else {
					alert("保存失败");
				}
			}
		});
	}

});