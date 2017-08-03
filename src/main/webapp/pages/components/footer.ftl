<!-- 在bootstrap.min.js 之前引入 -->
<script src="${base_url}/static/bootstrap-3.3.7/js/jquery.min.js"></script>
<!-- Bootstrap 核心 JavaScript 文件 -->
<script src="${base_url}/static/bootstrap-3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">
    //修复nginx 代理后无法发送post请求问题，主要是projectName是固定的，现在是动态获取
    var base_url = window.location.origin + '${project_name}';
</script>
