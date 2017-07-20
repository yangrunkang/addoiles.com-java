$(function() {

	var base_url = window.location.origin;
	$("#share_btn").click(function() {
		console.log("share btn click");
		var title = $("input[name='title']").val();
		var content = $("textarea[name='content']").val();
		$.ajax({
			url: base_url + "/share",
			dataType: "json",
			type: "post",
			data:{
				"title": title,
				"content": content
			}, 
			success: function(result) {
				if(result.code == 0){
					var oilShare = result.data;
					$(".panel panel-primary").each(function(data){
						console.log(data);
					});
				}
			}
		});
	});
});