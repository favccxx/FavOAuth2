<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="common/commonInclude.jsp"%>
<!doctype html>
<html class="no-js">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>OAuth 2.0授权管理系统</title>
  <meta name="description" content="这是一个 index 页面">
  <meta name="keywords" content="index">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <meta name="apple-mobile-web-app-title" content="Amaze UI" />
  <link rel="icon" href="<%=basePath %>assets/images/oauth-2-sm.png" mce_href="/favicon.ico" type="image/x-icon">  
  <link rel="icon" type="image/png" href="<%=basePath %>assets/images/favicon.ico">
  <link rel="apple-touch-icon-precomposed" href="<%=basePath %>AmazeUI-2.1.0/assets/i/app-icon72x72@2x.png">
  
  <link rel="stylesheet" href="<%=basePath %>AmazeUI-2.1.0/assets/css/amazeui.min.css"/>
  <link rel="stylesheet" href="<%=basePath %>AmazeUI-2.1.0/assets/css/admin.css">
  <script type="text/javascript" src="<%=basePath %>assets/js/jquery-1.11.1.js"></script>

  <script type="text/javascript">
  	function changeIframe(url){
  		if(url!="" && url!=undefined){
  			$("#mainFrame").attr("src", url);
  		}
  	}
  	
  	function closeDialog(){
  		var list = $.dialog.list;
	   	list[0].close();
	   	for( var i in list ){
	   	    list[i].close();
	   	}
  	}
  </script>
</head>
<body>
<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，Amaze UI 暂不支持。 请 <a href="http://browsehappy.com/" target="_blank">升级浏览器</a>
  以获得更好的体验！</p>
<![endif]-->
 
	<div class="favHeader">
		<%@ include file="common/header.jsp"%>
	</div>
	<div class="am-cf admin-main">
		<div class="favMenu">
			<%@ include file="common/commonMenu.jsp"%>  
		</div>
		<div class="favBody">
			<iframe id="mainFrame" name="mainFrame" src="welcome/welcome" style="width:1050px;height:1500px;" scrolling="no"></iframe>
		</div>
	</div>
	<div class="favFooter">
		<%@ include file="common/footer.jsp"%>
	</div>




<!--[if lt IE 9]>
<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="assets/js/polyfill/rem.min.js"></script>
<script src="assets/js/polyfill/respond.min.js"></script>
<script src="assets/js/amazeui.legacy.js"></script>
<![endif]-->

<!--[if (gte IE 9)|!(IE)]><!-->
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/amazeui.min.js"></script>
<!--<![endif]-->
<script src="assets/js/app.js"></script>
</body>
</html>