	<#include "header.ftl">
	<section class="dexp-section" id="section-main-content">
	<div class="container">
		<div class="row">
		<#include "sidebar.ftl">
		<!-- .region-content-->
		<div class="region region-content col-xs-12 col-sm-12 col-md-9 col-lg-9">
			<div class="tabs"></div>
			<div id="block-system-main" class="block block-system">
  				<div class="inner"></div>
  				<div class="content">
    				<div class="view view-blogs view-id-blogs view-display-id-page view-dom-id-3fc26074e7705ece83d90b58e838ca4e jquery-once-2-processed">
      					<div class="view-content">
      					
      						<#list pageList.getList() as article>
        					<div class="views-row views-row-${article_index+1} <#if article_index%2==0>views-row-odd<#else>views-row-even</#if>">
  								<div class="views-field views-field-name-2">        
  									<span class="field-content">${article.folder.name}</a></span>  
  								</div>  
  								<div class="views-field views-field-field-picture">        
  									<div class="field-content">
  										<a href="${BASE_PATH}/${article.folder.ename}/${article.articleId}.htm">
  											<img typeof="foaf:Image" src="${BASE_PATH}/${article.picture}" alt="" style="height:250px;">
  										</a>
  									</div>  
  								</div>  
								<div class="views-field views-field-ops">        
									<span class="field-content"></span>  
								</div>  
								<div class="views-field views-field-created">        
									<span class="field-content">${article.updateTime?string('yyyy,MM-dd')}</span>  
								</div>  
								<div class="views-field views-field-title">        
									<span class="field-content">
										<a href="${BASE_PATH}/${article.folder.ename}/${article.articleId}.htm">${article.title}</a>
									</span>  
								</div>  
								<div class="views-field views-field-name">    
									<span class="views-label views-label-name">——</span> 
									<span class="field-content">
										<a href="${BASE_PATH}/user/${article.admin.adminId}.htm" title="View user profile." class="username" xml:lang="" typeof="sioc:UserAccount" property="foaf:name" datatype="">${article.admin.name}</a>
									</span> 
								</div>  
								<div class="views-field views-field-ops-1">        
									<span class="field-content">
										<span class="flag-wrapper flag-blog-flag-c flag-blog-flag-c-231">
      										<span class="flag flag-action flag-link-toggle">
      											<a href="${BASE_PATH}/sign-in">F</a>
      										</span>
    									</span>
									</span>  
								</div>  
  								<div class="views-field views-field-count">        
  									<span class="field-content">${article.viewCount}</span>  
  								</div>  
  								<div class="views-field views-field-comment-count">        
  									<span class="field-content">${article.commentCount}</span>  
  								</div>  
  								<div class="views-field views-field-nothing">        
  									<span class="field-content">
  										<a href="${BASE_PATH}/${article.folder.ename}/${article.articleId}.htm" class="blur">b</a>
  									</span>  
  								</div>  
  							</div>
  							</#list>
  							<div id="article_more_display"></div>
    				</div>
		     				 <div class="item-list">
		     				 	<ul class="pager pager-load-more" id="artilce_last">
		     				 		<#if pageList.isLastPage()==false>
		     				 		
		     				 		<li class="pager-next first last">
		     				 		<a href="javascript:void(0);" id="article_more" pages="${pageList.pageNum+1}">加载更多</a>
		     				 		</li>
		     				 		<#else>
		     				 		<li class="icon-chevron-up">已经到底了</li>
		     				 		</#if>
		     				 		
								</ul>
							</div>  
						</div>    
		  			</div>
				</div>
			</div>
			<!-- END .region-content-->
		</div>
	</div>
	</section>
	<#include "footer.ftl">
</div>	

<script>
$(function(){
	$('#article_more').click(function(){
		var pages = $(this).attr('pages');
		var rows = ${pageList.rows};
		$.post("${BASE_PATH}/article/article_more.json", 
				{"pages": pages,"rows":rows},
				function(data){
					if(data.result){
						
						var articlelist = data.t.list;
						var textHtml="";
						var item=(pages-1)*rows+1;
						var i=0;
						
						for(i=0;i<articlelist.length;i++){
							item=i+item;
							textHtml+="<div class=\"views-row views-row-"+item;
							var date = new Date(articlelist[i].updateTime);
							var year = date.getFullYear();
							var month = (date.getMonth()+1)>9?date.getMonth()+1:"0"+(date.getMonth()+1);
							var day = date.getDate()>9?date.getDate():"0"+date.getDate();
							var tm = year+","+month+"-"+day;
							if(i%2==0){
								textHtml+= "views-row-odd"
							}else{
								textHtml+="views-row-even";
							}
							
							textHtml+="\">";
							textHtml+="<div class=\"views-field views-field-name-2\">"        
											+"<span class=\"field-content\">"+articlelist[i].folder.name+"</span>"  
										+"</div>"  
										+"<div class=\"views-field views-field-field-picture\">"        
											+"<div class=\"field-content\">"
												+"<a href=\"${BASE_PATH}/"+articlelist[i].folder.ename+"/"+articlelist[i].articleId+".htm\">"
													+"<img typeof=\"foaf:Image\" src=\"${BASE_PATH}/"+articlelist[i].picture+"\" style=\"height:250px;\">"
												+"</a>"
											+"</div>"  
										+"</div>" 
										+"<div class=\"views-field views-field-ops\">"        
											+"<span class=\"field-content\"></span>"  
										+"</div>"  
										+"<div class=\"views-field views-field-created\">"       
											+"<span class=\"field-content\">"+tm+"</span>"  
										+"</div>"  
										+"<div class=\"views-field views-field-title\">"        
											+"<span class=\"field-content\">"
											+"<a href=\"${BASE_PATH}/"+articlelist[i].folder.ename+"/"+articlelist[i].articleId+".htm\">"+articlelist[i].title+"</a>"
											+"</span>"  
										+"</div>"  
										+"<div class=\"views-field views-field-name\">"    
											+"<span class=\"views-label views-label-name\">——</span>"
											+"<span class=\"field-content\">"
												+"<a href=\"${BASE_PATH}/user/"+articlelist[i].admin.adminId+" title=\"View user profile.\" class=\"username\" xml:lang=\"\"  typeof=\"sioc:UserAccount\" property=\"foaf:name\" datatype=\"\">"+articlelist[i].admin.name+"</a>"
											+"</span>" 
										+"</div>"  
										+"<div class=\"views-field views-field-ops-1\">"     
											+"<span class=\"field-content\">"
												+"<span class=\"flag-wrapper flag-blog-flag-c flag-blog-flag-c-231\">"
  													+"<span class=\"flag flag-controller flag-link-toggle\">"
  														+"<a href=\"${BASE_PATH}/sign-in\">F</a>"
  													+"</span>"
												+"</span>"
											+"</span>"  
										+"</div>"  
										+"<div class=\"views-field views-field-count\">"     
											+"<span class=\"field-content\">"+articlelist[i].viewCount+"</span>"  
										+"</div>"  
										+"<div class=\"views-field views-field-comment-count\">"        
											+"<span class=\"field-content\">"+articlelist[i].commentCount+"</span>"  
										+"</div>"  
										+"<div class=\"views-field views-field-nothing\">"        
											+"<span class=\"field-content\">"
												+"<a href=\"${BASE_PATH}/"+articlelist[i].folder.ename+"/"+articlelist[i].articleId+".htm\" class=\"blur\">b</a>"
											+"</span>"  
										+"</div>"  
									+"</div>"
						}
						
						textHtml+="<div id=\"article_more_display\"></div>";
						document.getElementById("article_more_display").outerHTML=textHtml;
						if(data.t.lastPage==true){
							document.getElementById("artilce_last").innerHTML="<li class=\"icon-chevron-up\">已经到底了</li>";
						}else{
							$(this).attr('pages',pages+1);
						}
						
					}
	        },"json");  	
	    });		
	});	
</script>
	
<div id="lightbox2-overlay" style="display: none;"></div>      
<div id="lightbox" style="display: none;" class="lightbox2-orig-layout">        
	<div style="background-color: rgb(255, 255, 255); color: rgb(0, 0, 0);" id="outerImageContainer">
		<div id="modalContainer" style="display: none; padding: 10px;"></div>
		<div id="frameContainer" style="display: none; padding: 10px;"></div>
		<div id="imageContainer" style="display: none; padding: 10px;">
			<img id="lightboxImage" alt="">
			<div id="hoverNav">
				<a style="padding-top: 10px;" id="prevLink" title="Previous" href="#"></a>
				<a style="padding-top: 10px;" id="nextLink" title="Next" href="#"></a>
			</div>
		</div>
		<div id="loading">
			<a href="#" id="loadingLink"></a>
		</div>
	</div>        
	<div style="background-color: rgb(255, 255, 255); color: rgb(0, 0, 0);" id="imageDataContainer" class="clearfix">          
		<div id="imageData">
			<div id="imageDetails">
				<span id="caption"></span>
				<span id="numberDisplay"></span>
			</div>
			<div id="bottomNav">
				<div id="frameHoverNav">
					<a style="padding-top: 10px;" id="framePrevLink" title="Previous" href="#"></a>
					<a style="padding-top: 10px;" id="frameNextLink" title="Next" href="#"></a>
				</div>
				<a style="background-color: rgb(255, 255, 255); color: rgb(0, 0, 0);" id="bottomNavClose" title="Close" href="#"></a>
				<a id="bottomNavZoom" href="#"></a>
				<a id="bottomNavZoomOut" href="#"></a>
				<a id="lightshowPause" title="Pause Slideshow" href="#" style="display: none;"></a>
				<a id="lightshowPlay" title="Play Slideshow" href="#" style="display: none;"></a>
			</div>
		</div>        
	</div>      
</div>
<div style="display: none;" id="cboxOverlay"></div>
<div style="display: none;" tabindex="-1" role="dialog" class="" id="colorbox">
	<div id="cboxWrapper">
		<div>
			<div style="float: left;" id="cboxTopLeft"></div>
			<div style="float: left;" id="cboxTopCenter"></div>
			<div style="float: left;" id="cboxTopRight"></div>
		</div>
		<div style="clear: left;">
			<div style="float: left;" id="cboxMiddleLeft"></div>
			<div style="float: left;" id="cboxContent">
				<div style="float: left;" id="cboxTitle"></div>
				<div style="float: left;" id="cboxCurrent"></div>
				<button id="cboxPrevious" type="button"></button>
				<button id="cboxNext" type="button"></button>
				<button id="cboxSlideshow"></button>
				<div style="float: left;" id="cboxLoadingOverlay"></div>
				<div style="float: left;" id="cboxLoadingGraphic"></div>
			</div>
			<div style="float: left;" id="cboxMiddleRight"></div>
		</div>
		<div style="clear: left;">
			<div style="float: left;" id="cboxBottomLeft"></div>
			<div style="float: left;" id="cboxBottomCenter"></div>
			<div style="float: left;" id="cboxBottomRight"></div>
		</div>
	</div>
	<div style="position: absolute; width: 9999px; visibility: hidden; display: none; max-width: none;"></div>
</div>
</body>
</html>