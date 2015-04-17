<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/commonInclude.jsp"%>
<!DOCTYPE html>
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
  <script type="text/javascript" src="<%=basePath %>assets/js/jquery-1.11.1.js"></script>
  
  <script type="text/javascript">
  	function saveSiteApply(){  
  		$.ajax({
			type:'POST',
			url:'<%=basePath%>applysite/addwebsite',
			data:$("#webAppForm").serialize(),
			dataType:'json',
			timeout: 50000,
			cache: false,
			async: false,
			success: function(json){
				alert("申請成功！");
			},
			error: function(request) {
                alert("Connection error");
            }
		});
  	}
  	
  	function closeDialog(){
  		parent.location.reload();
  	}
  </script>

</head>
<body>
	<div class="admin-content" style="width:850px;">	    
	    <div class="am-g">
	      <div class="am-u-sm-12">
	        <form id="webAppForm" class="am-form am-form-horizontal" method="post">
	          <hr/>
	          <input type="hidden" name="webKey" value="${webKey }">
	          <div class="am-form-group">
	            <label for="webName" class="am-u-sm-3 am-form-label">网站名称</label>
	            <div class="am-u-sm-9">
	              <input type="text" id="webName" name="webName" placeholder="请输入你的网站名称">	             
	            </div>
	          </div>
	          <div class="am-form-group">
	            <label for="webUrl" class="am-u-sm-3 am-form-label">网站URL</label>
	            <div class="am-u-sm-9">
	              <input type="text" id="webUrl" name="webUrl" placeholder="请输入你的网站URL">	              
	            </div>
	          </div>
	
	          <div class="am-form-group">
	            <label for="webCategory" class="am-u-sm-3 am-form-label">网站分类</label>
	            <div class="am-u-sm-9">
	              <select id="webCategory" name="webCategory">	            		
          		  	<option value="1">门户</option>	 
          		  	<option value="2">社交</option>	
          		  	<option value="3">视频</option>	
          		  	<option value="4">娱乐</option>
          		  	<option value="5">工具</option>	            		
	              </select>	 	             
	            </div>
	          </div>
	
	          <div class="am-form-group">
	            <label for="webProfile" class="am-u-sm-3 am-form-label">网站简介</label>
	            <div class="am-u-sm-9">
	              <textarea class="" rows="5" id="webProfile" name="webProfile" placeholder="请输入你的网站简介"></textarea>	             
	            </div>
	          </div>
	
	          <div class="am-form-group">
	            <div class="am-u-sm-9 am-u-sm-push-3">
	              <button type="button" class="am-btn am-btn-primary" onclick="saveSiteApply();">保存</button>
	            </div>
	          </div>
	        </form>	
	      </div>
	     </div>
	    </div>
	   <script src="<%=basePath %>lhgdialog/_demo/jquery-1.7.2.min.js"></script>
  	   <script type="text/javascript" src="<%=basePath %>lhgdialog/lhgdialog/lhgdialog.min.js"></script>
</body>
</html>