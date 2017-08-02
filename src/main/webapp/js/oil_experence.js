$(function() {
	$("#saveContent").click(function(){
		console.log("Experence点击保存按钮");
		var content = $("textarea[name='content']").val();
		console.log($(editor.textarea.element.innerHTML));
		console.log($(editor.textareaElement).val());
		console.log($(editor.textareaElement));
		console.log($(editor.textarea));
	});
	$("#saveTempContent").click(function(){
		console.log("Experence点击临时保存按钮");
	});
	
});