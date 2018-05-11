<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/commonInclude.jsp"%>
<!DOCTYPE html>
<html class="no-js">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>OAuth 2.0登陆</title>
  <meta name="description" content="这是一个 index 页面">
  <meta name="keywords" content="index">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <link rel="icon" type="image/png" href="<%=basePath %>AmazeUI-2.1.0/assets/i/favicon.png">
  <link rel="apple-touch-icon-precomposed" href="<%=basePath %>AmazeUI-2.1.0/assets/i/app-icon72x72@2x.png">
  <meta name="apple-mobile-web-app-title" content="Amaze UI" />
  <link rel="stylesheet" href="<%=basePath %>AmazeUI-2.1.0/assets/css/amazeui.min.css"/>
  <link rel="stylesheet" href="<%=basePath %>AmazeUI-2.1.0/assets/css/admin.css">
   <link rel="stylesheet" href="<%=basePath %>assets/css/oauth_error.css"/>
  <script type="text/javascript" src="<%=basePath %>assets/js/jquery-1.11.1.js"></script>
  <style type="text/css">
  	.oauth_main{
  		border: 1px solid #d2d2d2;
	    border-radius: 6px;
	    box-shadow: 0 0 5px #c6c6c6;
  	}
  	.oauth_content {
	    padding: 10px 18px 0 20px;
	}
  </style>

</head>
<body>
	<div class="oauth_wrap">
    	<div class="oauth_header clearfix">
      		<h1 title="微博" class="WB_logo">微博</h1>
      		<p class="login_account"></p>
    	</div>
	    <!-- 无头像  -->
	    <div class="WB_panel oauth_main">
	    	<div class="oauth_error">
	        <div class="oauth_error_content clearfix"> <span class="oauth_error_icon WB_tipB_err"></span>
	        	<dl class="error_content">
	            	<dt>访问出错了！</dt>
	            	<dd>你所访问的站点在高富帅的认证失败，请你联系<a target="_blank" href="http://xxx.com/5140577716"> 系统管理员 </a>或者稍后再试。<br>
	            		(error:redirect_uri_mismatch)${OAuth2FailedMessage }
	            	</dd>
	          	</dl>
	        </div>
	        <div class="oauth_copyright"><a href="#">高富帅</a>版权所有</div>
	     </div>
	</div>
</div>
</body>
</html>