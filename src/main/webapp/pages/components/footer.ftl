		<script type="text/javascript">
		    //修复nginx 代理后无法发送post请求问题，主要是projectName是固定的，现在是动态获取
		    var base_url = window.location.origin + '${project_name}';
		</script>
		<!--引入jquery弹框js,head需要引入css-->
		<script src="${base_url}/static/jquery-confirm-v3.2.3/jquery-confirm.min.js" ></script>