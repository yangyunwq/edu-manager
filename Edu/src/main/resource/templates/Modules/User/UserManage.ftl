﻿<!DOCTYPE html>
<html>
<head>
	<link rel="Stylesheet" type="text/css" href="${request.contextPath}/assets/Styles/bridging.css"/>
	<script type="text/javascript" src="${request.contextPath}/assets/Scripts/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="${request.contextPath}/static/assets/Scripts/common.js"></script>
</head>
<body>
    <form id="form1">
    <div class="main">
        <div class="sidbar" id="sidbar">
            <div class="sub_nav">
                <h2><p class="systemIcon">用户管理</p></h2>
                <div class="switch_subNav">
                    <ul id="show_iframe" class="switch_nav">
						<li class="nav_current">
							<a href="#" class="subNavigation" id="A001010"
                               data-name="common_iframe" onclick="Common.switchNavigation(this);"
							   data-url="${request.contextPath}user/userInfo">用户信息</a>
						</li>
						<li class="nav_current">
							<a href="#" class="subNavigation" id="A001011"
							   data-name="common_iframe" onclick="Common.switchNavigation(this);"
							   data-url="${request.contextPath}user/userInfo">其它信息</a>
						</li>

                    </ul>
                </div>
            </div>
        </div>
        <!--====这里是弹出层的内容====-->
		<div id="common_iframe" class="maincontent">
			<iframe class="common_iframe" id="A001010_iframe"  frameborder="0" border="0" src="${request.contextPath}/user/userInfo"></iframe>
		</div>
    </div>
    </form>
</body>
</html>

