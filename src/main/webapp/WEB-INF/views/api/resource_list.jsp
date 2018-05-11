<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/commonInclude.jsp"%>
<!DOCTYPE html>
<html class="no-js">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>REST API</title>
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
	<div class="admin-content">
    <div class="am-cf am-padding">
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">REST API</strong> / <small>使用說明</small></div>
    </div>

    <hr/>

    <div class="am-g">
      <div class="am-u-sm-12 am-u-sm-centered">
        <h2>用戶管理接口</h2>
        <p><a href="#">users/behavior_trend</a>获取授权用户行为数据每日变化趋势</p>
        <p><a href="#">friendships/followers/trend_count</a>获取30天授权用户粉丝的变化趋势数据</p>
        <p><a href="#">friendships/followers/active_list</a>获取授权用户活跃或互动粉丝TOP20列表</p>
        <hr/>
      </div>

      <div class="am-u-sm-12 am-u-md-8 am-u-md-pull-4">
        <h3>检索最新数据</h3>
        <p>search/statuses/limited 搜索含某关键词的微博</p>
        <p>search/statuses/limited Search for weibos</p>
        <ol>
          <li>在 GitHub 项目主页提交 <a href="">Issue</a>。</li>
          <li>在 GitHub 项目主页提交 <a href="">Issue</a>。</li>
        </ol>
        <p>反馈注意事项</p>
        <p>为了能最准确的传达所描述的问题， 建议你在反馈时附上演示，方便我们理解。</p>
        <p>下面的几个链接是我们在几个在线调试工具上建的页面， 已经引入了 Amaze UI 样式和脚本，你可以选择你喜欢的工具【Fork】一份， 把要有问题的场景粘在里面，反馈给我们。</p>
        <ol>
          <li><a href="http://jsbin.com/kijiqu/1/edit?html,output" target="_blank">JSBin</a> </li>
          <li><a href="http://jsfiddle.net/hegfirose/W22fV/" target="_blank">JSFiddle</a> </li>
          <li><a href="http://codepen.io/minwe/pen/AEeup" target="_blank">CodePen</a> </li>
        </ol>
      </div>
    </div>
  </div>
</body>
</html>