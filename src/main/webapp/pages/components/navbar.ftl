<!--导航栏-->
<nav class="navbar navbar-default navbar-inverse" role="navigation">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button>
		<a class="navbar-brand" href="${base_url}/home"> AddOiles</a>
	</div>

	<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		<ul class="nav navbar-nav">
			<li>
                <a href="${base_url}/home">主页</a>
			</li>
			<li>
				<a href="${base_url}/fourm">论坛</a>
			</li>
			<li>
				<a href="${base_url}/dreams">梦想墙</a>
			</li>
			<li>
				<a href="${base_url}/experence">经历分享</a>
			</li>
			<li>
				<a href="${base_url}/addoil">鼓劲打气</a>
			</li>
			<li>
				<a href="${base_url}/difficult">最近难点</a>
			</li>
			<li>
				<a href="${base_url}/complaint">抱怨一下</a>
			</li>
		</ul>

        <form class="navbar-form navbar-right" role="search">
            <div class="input-group input-group-sm">
                <input type="text" class="form-control" placeholder="搜索..">
                <span class="input-group-btn">
                    <button class="btn btn-default" type="button">Go!</button>
                </span>
            </div>
        </form>

		<ul class="nav navbar-nav navbar-right">
			<li><a href="#" data-toggle="modal" data-target="#register"><span class="glyphicon glyphicon-user"></span> 注册</a></li>
			<li><a href="#" data-toggle="modal" data-target="#login"><span class="glyphicon glyphicon-log-in"></span> 登录</a></li>
		</ul>
	</div>
    <!-- 注册窗口 -->
    <div id="register" class="modal fade" tabindex="-1">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-body">
                    <button class="close" data-dismiss="modal">
                        <span>&times;</span>
                    </button>
                </div>
                <div class="modal-title">
                    <h1 class="text-center">注册</h1>
                </div>
                <div class="modal-body">
                    <form class="form-group" action="">
                        <div class="form-group">
                            <label for="">用户名</label>
                            <input class="form-control" type="text" placeholder="6-15位字母或数字">
                        </div>
                        <div class="form-group">
                            <label for="">密码</label>
                            <input class="form-control" type="password" placeholder="至少6位字母或数字">
                        </div>
                        <div class="form-group">
                            <label for="">再次输入密码</label>
                            <input class="form-control" type="password" placeholder="至少6位字母或数字">
                        </div>
                        <div class="form-group">
                            <label for="">邮箱</label>
                            <input class="form-control" type="email" placeholder="例如:123@123.com">
                        </div>
                        <div class="text-right">
                            <button class="btn btn-primary" type="submit">提交</button>
                            <button class="btn btn-danger" data-dismiss="modal">取消</button>
                        </div>
                        <a href="" data-toggle="modal" data-dismiss="modal" data-target="#login">已有账号？点我登录</a>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <!-- 登录窗口 -->
    <div id="login" class="modal fade">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-body">
                    <button class="close" data-dismiss="modal">
                        <span>&times;</span>
                    </button>
                </div>
                <div class="modal-title">
                    <h1 class="text-center">登录</h1>
                </div>
                <div class="modal-body">
                    <form class="form-group" action="">
                        <div class="form-group">
                            <label for="">用户名</label>
                            <input class="form-control" type="text" placeholder="">
                        </div>
                        <div class="form-group">
                            <label for="">密码</label>
                            <input class="form-control" type="password" placeholder="">
                        </div>
                        <div class="text-right">
                            <button class="btn btn-primary" type="submit">登录</button>
                            <button class="btn btn-danger" data-dismiss="modal">取消</button>
                        </div>
                        <a href="" data-toggle="modal" data-dismiss="modal" data-target="#register">还没有账号？点我注册</a>
                    </form>
                </div>
            </div>
        </div>
    </div>
</nav>