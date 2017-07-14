<#assign menu="folder">
<#assign submenu="folder_list">
<#include "../head.ftl">
<style type="text/css">
.pagination {
	border-radius: 4px;
	display: inline-block;
	margin: 0;
	padding-left: 0;
}
</style>
<!--main content start-->
<section id="main-content">
	<section class="wrapper">
		<!-- page start-->
		<div class="row">
			<div class="col-lg-12">
				<!--breadcrumbs start -->
				
				<!--breadcrumbs end -->
			</div>
		</div>
		<div class="row">
			<div class="col-lg-5">
				<section class="panel">
                          <header class="panel-heading">
                            	 网站设置
                          </header>
                          <div class="panel-body">
                              <form id="addFolder_form" method="post" class="form-horizontal" autocomplete="off" action="${BASE_PATH}/manage/config/update.json">
                              	<fieldset>
                                  <div class="form-group">
                                      <label class="col-xs-3 control-label">运行网站</label>
                                      <div class="col-xs-9">
				 						<select class="form-control input-lg m-bot15" style="font-size:15px;width: 200px;" name="webId">
			                   						<#list webList as webs>
				                        						<option value="${webs.folderId}" <#if webs.folderId == webId>selected</#if>>${webs.name}</option>
			                        				</#list>							
	                           	 		</select>                                        
                                      </div>
                                  </div>                                                                 
                                  <div class="form-group">
                                      <label class="col-xs-3 control-label">是否静态</label>
                                      <div class="col-xs-9">
                                      	<label class="radio-inline">
                                    		<input type="radio" name="ifstatic" value="false" checked/>否
                                  		</label>
                                  		<label class="radio-inline">
                                    		<input type="radio" name="ifstatic" value="true"/> 是
                                  		</label>
                                      </div>
                                  </div>
                                  <div class="form-group">
                                  	  <div class="col-lg-offset-3 col-xs-9">
                                      <button class="btn btn-danger" type="submit">保存</button>
                                      </div>
                                  </div>
                                 </fieldset>
                              </form>
                          </div>
                      </section>
			</div>
			<div class="col-lg-7">
				<section class="panel">
					<header class="panel-heading"> 所有网站列表 </header>
					<div class="panel-body">
						<div class="adv-table">
							<div role="grid" class="dataTables_wrapper"
								id="hidden-table-info_wrapper">
								<table class="table table-striped table-advance table-hover">
									<thead>
										<tr>
											<th>网站名称</th>
											<th>网站根目录名称</th>
											<th>状态</th>
											<th>操作</th>
										</tr>
									</thead>
									<tbody role="alert" aria-live="polite" aria-relevant="all">
										<#list webList as webs>
										<tr class="gradeA_firstFolder">
											<td>${webs.title}</td>
											<td>
												<a
												href="${BASE_PATH}/manage/folder/list.htm?folderId=${webs.folderId}">${webs.name}</a></td>
											<td>
												<#if webs.folderId== webId>
													运行
												<#else>
													禁用
												</#if>
											</td>
											<td>
												<!-- Icons -->
											<!--	<a href="${BASE_PATH}/manage/folder/list.htm?folderId=${folder.folderId}" title="修改">
													子目录
												</a>
												 |  -->
												<a href="${BASE_PATH}/manage/config/edit.htm?folderId=${webs.folderId}" title="修改">
													修改
												</a>
												|
												<a class="js_folder_delete" folderId="${webs.folderId}" href="javascript:void(0);" title="删除">
													删除
												</a>
											</td>
										</tr>
										</#list>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</section>
			</div>
			<!-- page end-->
	</section>
</section>
<!--main content end-->
<script type="text/javascript">
var pageFolderId = ${folder.folderId};
$(function() {
    $('.js_folder_delete').click(function() {
        var folderId = $(this).attr('folderId');
        bootbox.dialog({
            message: "是否" + $(this).attr('title') + "文件夹",
            title: "提示",
            buttons: {
                "delete": {
                    label: "删除",
                    className: "btn-success",
                    callback: function() {
                        $.post("${BASE_PATH}/manage/folder/delete.json", {
                            "folderId": folderId
                        },
                        function(data) {
                            if (data.result) {
                                bootbox.alert("删除成功",
                                function() {
                                    window.location.href = "${BASE_PATH}/manage/folder/list.htm?folderId=" + pageFolderId;
                                });
                            } else {
                                bootbox.alert(data.msg,
                                function() {});
                            }
                        },
                        "json");
                    }
                },
                "cancel": {
                    label: "取消",
                    className: "btn-primary",
                    callback: function() {}
                }
            }
        });
    });
    $('#addFolder_form').ajaxForm({
			dataType : 'json',
			success : function(data) {
				if (data.result) {
					bootbox.alert("保存成功",function() {
						window.location.reload();
					});
				}else{
					showErrors($('#addFolder_form'),data.errors);
				}
			}
		});
});
</script>
<#include "../foot.ftl">
