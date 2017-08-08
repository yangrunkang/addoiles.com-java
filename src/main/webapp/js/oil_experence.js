$(function() {

	var experenceTitle = "无标题:题主很任性,经历很精彩";
	var content = "";

	/**
	 * 保存经历按钮
	 */
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
				oilConfirm("我想知道你的精彩经历","不放弃,不抛弃,追梦之路,不孤单");
				return;
			}
			//2.保存内容(需要填写标题,所以搞个确认框)
			$.confirm({ //插件使用
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
							var name = this.$content.find('.name').val();//经历标题
							if(!name) {
								oilAlert('呜呜呜,没有名字啊,我读书少,不要骗我啊')
								return false;
							}
							//3.调用接口保存文章并追加到下面
							console.log("name:" + name);
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
					var data = result.data;
					var experenceHtml = "<div class='experences panel panel-default'>" +
										"<div class='panel-heading'>" + data.title + "</div>"+
										"<div class='panel-body'>" + data.content + "</div>"+
									    "<div class='panel-footer'>"+
											"<div class='input-group'>"+
												"<input type='text' class='form-control' placeholder='Search for...'>"+
												"<span class='input-group-btn'>"+
											        "<a class='btn btn-default' href='#'>评论</a>"+
										     	"</span>"+
											"</div>"+
										"</div>"+
									"</div>";
					
					//修复网站初始化时,没有数据的Bug
					if($(".experences:first").length == 0){ //TO-DO 可以根据length做不同的背景颜色设置
						$("#exp_guo").after(experenceHtml);
						initExperence();
						return;
					}
					$(".experences:first").before(experenceHtml);
					initExperence();
				} else {
					oilAlert("保存失败")
				}
			}
		});
	}
	/**
	 * 初始化编辑器
	 * 	成员变量初始化
	 *  编辑器初始化
	 */
	function initExperence(){
		//2.销毁编辑器和改变按钮文字为'开始书写我的经历' {后期做，继续书写我的另一段奇妙的经历}
		$("#experenceBtn").html("开始书写我的经历");
		//3.清空内容并销毁编辑器
		$('#summernote').summernote('code', '');
		experenceTitle = "无标题:题主很任性,经历很精彩";
		content = "";
		$('#summernote').summernote('destroy');
	}
	

});