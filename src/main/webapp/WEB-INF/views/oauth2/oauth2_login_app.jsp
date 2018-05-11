<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/commonInclude.jsp"%>
<!doctype html>
<html class="no-js">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Amaze UI Admin index Examples</title>
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
  <script src="<%=basePath %>AmazeUI-2.1.0/assets/js/jquery.min.js"></script>
  
  <script type="text/javascript">
  	function oauth2Login(){
  		
  		var appId = $('input[name="favAppSiteRadio"]:checked').val();
  		if(appId=="" || appId==undefined){
  			alert("请选择需要登陆的应用！");
  			return;
  		}
  		
  		var data = {
  				appId : appId
  		};
  		
  		
  		window.parent.changeIframe("oauth2/initOAuth2Login?appId=" + appId);
  	}
  	
  	function friendInform(){
  		alert("亲，你想多啦，只能选择OAuth 2.0高富帅账号登陆！");
  	}
  </script>
</head>
<body>
<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，Amaze UI 暂不支持。 请 <a href="http://browsehappy.com/" target="_blank">升级浏览器</a>
  以获得更好的体验！</p>
<![endif]-->

<div class="am-cf admin-main">
  <!-- content start -->
  <div class="admin-content">

    <div class="am-cf am-padding">
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">站点管理</strong> / <small>站点审批</small></div>
    </div>

    <div class="am-g">
      <div class="am-u-sm-12 am-u-md-6">
        <div class="am-btn-toolbar">
          <div class="am-btn-group am-btn-group-xs">
          	<button type="button" class="am-btn am-btn-default" onclick="oauth2Login();"><img alt="" class="am-icon-btn" src="<%=basePath %>assets/images/oauth-2-sm.png"> </button>
     		<button type="button" class="am-btn am-btn-default" onclick="friendInform();"><span class="am-icon-btn am-primary am-icon-qq"></span> </button>          	
          	<button type="button" class="am-btn am-btn-default" onclick="friendInform();"><span class="am-icon-btn am-primary am-icon-github"></span> </button>
          	<button type="button" class="am-btn am-btn-default" onclick="friendInform();"><span class="am-icon-btn am-primary am-icon-youtube"></span> </button>          
          </div>
        </div>
      </div>
      <div class="am-u-sm-12 am-u-md-3">
        <div class="am-form-group">
          <select data-am-selected="{btnSize: 'sm'}">
            	<option value="1">门户</option>	 
       		  	<option value="2">社交</option>	
       		  	<option value="3">视频</option>	
       		  	<option value="4">娱乐</option>
       		  	<option value="5">工具</option>	
          </select>
        </div>
      </div>
      <div class="am-u-sm-12 am-u-md-3">
        <div class="am-input-group am-input-group-sm">
          <input type="text" class="am-form-field">
          <span class="am-input-group-btn">
            <button class="am-btn am-btn-default" type="button">搜索</button>
          </span>
        </div>
      </div>
    </div>

    <div class="am-g">
      <div class="am-u-sm-12">
        <form class="am-form">
          <table class="am-table am-table-striped am-table-hover table-main">
            <thead>
              <tr>
                <th class="table-check"><input type="checkbox" /></th>
                <th class="table-title">网站名称</th>
                <th class="table-type">网站URL</th>
                <th class="table-date">网站分类</th>
                <th class="table-author">网站状态</th>
              </tr>
          </thead>
          <tbody>
          	<c:forEach items="${appList }" var="appItem">
          		<tr>
          			<td><input type="radio" name="favAppSiteRadio" value="${appItem.id }"/></td>
          			<td>${appItem.appName }</td>
          			<td>${appItem.appUrl }</td>
          			<td>
          				<c:if test="${appItem.appCategory=='PORTAL' }">门户</c:if>
          				<c:if test="${appItem.appCategory=='SOCIAL' }">社交</c:if>
          				<c:if test="${appItem.appCategory=='VIDEO' }">视频</c:if>
          				<c:if test="${appItem.appCategory=='GAME' }">娱乐</c:if>
          				<c:if test="${appItem.appCategory=='TOOL' }">工具</c:if>
          			<td>
          				<c:if test="${appItem.appState=='APPLY' }">未审核</c:if>
          				<c:if test="${appItem.appState=='APPROVE' }">审核通过</c:if>
          				<c:if test="${appItem.appState=='REJECT' }">审核不通过</c:if>
          			</td> 
          		</tr>
          	</c:forEach>
          </tbody>
        </table>
          <div class="am-cf">
  共 15 条记录
  <div class="am-fr">
    <ul class="am-pagination">
      <li class="am-disabled"><a href="#">«</a></li>
      <li class="am-active"><a href="#">1</a></li>
      <li><a href="#">2</a></li>
      <li><a href="#">3</a></li>
      <li><a href="#">4</a></li>
      <li><a href="#">5</a></li>
      <li><a href="#">»</a></li>
    </ul>
  </div>
</div>
        
        </form>
      </div>

    </div>
  </div>
  <!-- content end -->
</div>

<a class="am-icon-btn am-icon-th-list am-show-sm-only admin-menu" data-am-offcanvas="{target: '#admin-offcanvas'}"></a>
</body>
</html>