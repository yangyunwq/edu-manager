﻿<!DOCTYPE html>
<html>
<head>
<meta content="郭永峰IT教育系统" name="keywords" />
<meta content="郭永峰IT教育系统" name="description" />
<title>教育后台管理系统</title>
<link rel="Stylesheet" type="text/css" href="${request.contextPath}/assets/Styles/bridging.css"/>
<script type="text/javascript" src="${request.contextPath}/assets/Scripts/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${request.contextPath}/assets/Scripts/common.js"></script>
    <script type="text/javascript">
		function logout() {
			$("#logout").html("登录");
        }
	</script>
</head>

<body>
	<form id="form1" >
		<!--====这里放主导航====-->
		<div class="header">
			<div class="header_top">
				<header>
					<div class="header_logo">
						<h1>IT教育后台系统</h1>
					</div>
					<div class="header_tab">
						<ul>
							<li><h2 class="version"></h2></li>
							<li><span class="header_hi">Hi,</span><span
								class="header_usename">${user.username?default("无")}</span>！</li>
							<li><a href="${request.contextPath}/user/login">注销</a></li>
							<li class="rel"><a href="#" class="system_infor"
								id="system_infor" onclick="showMessageList();">系统消息(0)</a>
								<div id="Div1" class="dn"></div></li>
							<li class="password_nav"><a href="#"
								class="change_password nav_current otherNavigation">修改密码</a></li>
							<li><a href="#">帮助中心</a></li>
						</ul>
						<div class="cf"></div>
					</div>
					<div class="cf"></div>
				</header>
			</div>
			<div class="header_nav">
				<nav>
					<ul id="showMainNav" class="fix">
						<li class="navContent nav_current">
							<a href="#" class="showNav" id="user" data-name="main_iframe"
							onclick="Common.switchNavigation(this);"
							data-url="${request.contextPath}/user/userManager">用户管理</a>
						</li>
						<li class="navContent">
							<a href="#" class="showNav" id="finance" data-name="main_iframe"
							onclick="Common.switchNavigation(this);"
							data-url="${request.contextPath}/user/userManager">工资管理</a>
						</li>
					</ul>
				</nav>
			</div>
		</div>
		
		<!--====下面是主要内容区域====-->
		<div id="main_iframe"
			class="index_mainIfram_position  mainIfram_position">
			<iframe class="main_iframe" id="home_iframe" frameborder="0"
				border="0" src="${request.contextPath}/user/userManager"></iframe>
		</div>
		
		<!--====下面是页脚====-->
		<div class="footer">
			<footer>
				<p>  版权所有 @ 2018 IT教育工作室 </p>
			</footer>
		</div>
	</form>
</body>
</html>
