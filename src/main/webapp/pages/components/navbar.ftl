				<!--导航栏-->
				<nav class="navbar navbar-default navbar-inverse" role="navigation">
					<div class="navbar-header">
						<a class="navbar-brand" href="${base_url}/home"> AddOiles</a>
					</div>
				
					<div class="collapse navbar-collapse">
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
				
						${user_bar}
				
					</div>
				</nav>