$(function(){
	
	/**
	 * 统一评论接口
	 * url: base_url/用户ID/文章ID/文章类型/评论内容
	 */
	function commit(userId, articleId, inputId){
		var content = $("#"+inputId).val();
		$.ajax({
			url: base_url + "/commit",
			dataType: "json",
			type: "post",
			data: {
				"userId": userId,
				"articleId": articleId,
				"content": content
			},
			success: function(result) {
				
			}
		});
	}
	
	
});