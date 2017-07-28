<!--导航栏-->
<nav class="navbar navbar-default navbar-inverse" role="navigation">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
            <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span
                class="icon-bar"></span><span class="icon-bar"></span></button>
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

		<#if oilUser != null >
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#"><span class="glyphicon glyphicon-user"></span> ${oilUser.userName}</a>
				</li>
        	</ul>
    	<#else>
        	<ul class="nav navbar-nav navbar-right">
            	<li><a href="#" data-toggle="modal" data-target="#myModal"><span class="glyphicon glyphicon-user"></span> 注册</a>
				</li>
				<li>
					<a href="${base_url}/login"><span class="glyphicon glyphicon-log-in"></span> 登录</a>
				</li>
			</ul>
		</#if>

	</div>
</nav>