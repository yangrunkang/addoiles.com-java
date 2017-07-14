<#assign menu="folder"> 
<#assign submenu="update_folder"> 
<#include "../head.ftl">
<style type="text/css">
</style>
<!--main content start-->
<section id="main-content">
	<section class="wrapper">
		<!-- page start-->
		<div class="row">
			<form id="edit_config_form" method="post"
				class="form-horizontal" autocomplete="off"
				action="${BASE_PATH}/manage/config/edit.json"
				enctype="multipart/form-data">
				<div class="col-lg-12">
					<input type="hidden" class="form-control" name="folderId" value="${folder.folderId}">
					<section class="panel">
						<header class="panel-heading"> 
						网站修改
						</header>
						<div class="panel-body">
							<div class="form-group">
	                          <label class="col-sm-2 col-sm-2 control-label">网站名</label>
	                          <div class="col-sm-10">
	                              <input type="text" style="font-size:15px;width: 300px;" class="form-control" name="title"
	                              	placeholder="网站名" id="title" value="<#if folder.title??>${folder.title}</#if>">
	                              </input>
	                          </div>
	                        </div>
                        	<div class="form-group">
	                          <label class="col-sm-2 col-sm-2 control-label">网站根目录名</label>
	                          <div class="col-sm-10">
	                              <input type="text" style="font-size:15px;width: 300px;" class="form-control" name="name"
	                              	placeholder="文章标题" id="name" value="${folder.name}">
	                              </input>
	                          </div>
	                        </div>
                        	<div class="form-group">
	                          <label class="col-sm-2 col-sm-2 control-label">网站根目录英文名</label>
	                          <div class="col-sm-10">
	                              <input type="text" style="font-size:15px;width: 300px;" class="form-control" name="ename"
	                              	placeholder="文章标题" id="ename" value="${folder.ename}">
	                              </input>
	                          </div>
	                        </div>
	                       <div class="form-group">
	                          <label class="col-sm-2 col-sm-2 control-label">网站LOGO</label>
	                          <div class="col-sm-10">
	                          	<img src="<#if folder.logo??&&folder.logo!="">${BASE_PATH}/${folder.logo}</#if>"  style="height:120px;">
	                          	<input type="file" name="logo"
	                              	id="file" >
	                          </div>
	                      </div>
	                        <div class="form-group">
	                          <label class="col-sm-2 col-sm-2 control-label">封面高</label>
	                          <div class="col-sm-10">
	                              <input type="text" style="font-size:15px;width: 300px;" class="form-control" name="height"
	                              	placeholder="封面高" id="height" value="${folder.height}">
	                              </input>
	                          </div>
	                        </div>
	                        <div class="form-group">
	                          <label class="col-sm-2 col-sm-2 control-label">封面宽</label>
	                          <div class="col-sm-10">
	                              <input type="text" style="font-size:15px;width: 300px;" class="form-control" name="width"
	                              	placeholder="封面宽" id="width" value="${folder.width}">
	                              </input>
	                          </div>
	                        </div>	                        
	                        <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">网站描述</label>
                              <div class="col-sm-10">
                                  <textarea type="text"   name="content" placeholder="网站描述"  cols="40" rows="10">${folder.content}</textarea>
                              </div>
                        	</div>
	                        <div class="form-group">
	                      	  <div class="col-lg-offset-2 col-lg-10">
	                         	<button class="btn btn-shadow btn-primary" type="submit">更新修改</button>
	                          </div>
	                      </div>
						</div>
					</section>
				</div>
			</form>
		</div>

		<!-- page end-->
	</section>
</section>
<!--main content end-->
<script type="text/javascript">
 	var fatherId = ${folder.fatherId};
 	var kindId = ${folder.folderId};
	var kind = "folder";	
	$(function() {
		$('#edit_config_form').ajaxForm({
			dataType : 'json',		
			success : function(data) {
				if (data.result) {
					bootbox.alert("保存成功，将刷新页面", function() {
						window.location.reload();
					});
				}else{
					showErrors($('#edit_config_form'),data.errors);
				}
			}
		});			
	});	
</script>
<#include "../foot.ftl">
