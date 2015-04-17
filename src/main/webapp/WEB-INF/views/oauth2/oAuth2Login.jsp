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
   <link rel="stylesheet" href="<%=basePath %>assets/css/oauth_web.css"/>
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
	<div class="WB_xline1 oauth_xline" id="outer">
		<div class="oauth_wrap">
	    	<div class="oauth_header clearfix">
	      		<h1 class="WB_logo" title="微博"><a href="http://weibo.com">微博</a></h1>
	     	 	<p class="login_account"><span class="account_name">${favUser.username }</span><span class="vline">|</span><a href="http://app.weibo.com/my" target="_blank">我的应用</a></span><span class="vline">|</span><a href="#" action-type="logout">换个帐号</a></p>
	    	</div>
	    	<!-- 带头像  -->
	    	<div class="WB_panel oauth_main">
	    		<form name="authZForm" action="<%=basePath %>oauth2/favauthorize" method="post" node-type="form">
	      			<div class="oauth_content">
	        			<div class="oauth_main_content clearfix">
	        				<div class="app_info clearfix">
	        					<div class="app_info_main clearfix">
	        						<div class="app_icon">        				
		        						<img class="app_img" src="<%=basePath %>assets/images/oauth-2-sm.png" alt="app">
		        					</div>
		        					<div class="app_intro">
		        						<h3><a href="http://app.weibo.com/t/feed/KfQVs"  target="_blank">白富美</a></h3>
		        						<div class="app_des"></div>
		        					</div>
	        					</div>
	        					<div class="app_info_plus">
	        						<div class="plus_tit">
	        							http://app.weibo.com/t/feed/KfQVs<br/>有 12 个你关注的人连接
									</div>
	        						<div class="app_user_list">
			        					<ul class="clearfix">
						              		<li><a href="#"><img src="https://upload.api.weibo.com/tp/1666068804/50/5711442138/1" title="西门子"></a></li>
						               		<li><a href="#"><img src="https://upload.api.weibo.com/tp/1159540090/50/5697601196/1" title="R_松鼠大人"></a></li>
						               		<li><a href="#"><img src="https://upload.api.weibo.com/tp/1642471052/50/40021495778/1" title="TechWeb"></a></li>
						               		<li><a href="#"><img src="https://upload.api.weibo.com/tp/2615318523/50/5632103476/1" title="wangyuetingtao"></a></li>
						               		<li><a href="#"><img src="https://upload.api.weibo.com/tp/1753061523/50/5647677368/0" title="莉子Sally"></a></li>
						               	</ul>
			        				</div>
								</div>
	        				</div>
	        				<div class="oauth_info clearfix">
	        					<div class="oauth_list">
	        						<div class="list_tit">将允许<a href="http://app.weibo.com/t/feed/KfQVs"  target="_blank">白富美</a>进行以下操作：</div>
        							<ul class="do_list">
			            				<li>
			              					<i class="am-icon-user-md"></i>获得你的个人信息，好友关系
			            				</li>
			            				<li>
			              					<i class="am-icon-rss"></i>分享内容到你的微博
			            				</li>
			            				<li>
			              					<i class="am-icon-comments"></i>获得你的评论
			            				</li>
		          					</ul>
        						</div>
	        					<div class="oauth_info_plus">
	                				<div class="plus_sele">
	                        			隐私设置：
	                        			<span class="">
	                            			<em node-type="current_status">所有人可见</em>
	                            			<i class="slt_ctrl" node-type="arrow_btn">
	                                			<em class="slt_arr"></em>
	                            			</i>
	                        			</span>
	                    			</div>
				                    <div class="sele_des">
				                    	为了模拟方便，设置所有人都可以看到你在  <em class="sele_des_em">白富美</em> 上的动态
				                    </div>
	                			</div>
	                		</div>
	        			</div>
	           			<!-- 登录 -->
	        			<div class="oauth_login_box01 clearfix">    	
	        	
	        				<input type="hidden" id="grant_type" name="grant_type" value="" />
	        				<input type="hidden" id="client_id" name="client_id" value="${favWebApp.webKey }">
	        				<input type="hidden" id="scope" name="scope"   value="follow_app_official_microblog"/>
	        				<input type="hidden" id="state" name="state" value="20b9ecfda10f843b0f3eb7632ecd3561"/>		          
		          			<input type="hidden" id="display" name="display" value="default"/>
					  		<input type="hidden" id="response_type" name="response_type" value="code"/>
					  		<input type="hidden" name="redirect_uri" value="http://localhost:8086/FAVAUTH/client/clienthome"/>
					  
					  		<div class="oauth_login_submit">
					          	<div class="am-margin">
								    <button type="submit" class="am-btn am-btn-danger am-icon-md" onclick="userAuthorize()">连接</button>
								    <button type="button" class="am-btn am-icon-md">取消</button>
								</div>
<!-- 	              				<p class="oauth_formbtn"><a node-type="submit" href="#" onclick="return false;"  action-type="submit"   class="WB_btn_link formbtn_01"></a><a node-type="cancel" href="javascript:;" action-type="cancel" class="WB_btn_cancel"></a></p> -->
	         				 </div>
	         			</div>
					</div>
				 </form>	
			 </div>  
			 <!-- 根据域名修改文案 -->
	      	<p class="oauth_tiptxt">提示：为保障帐号安全，请认准本页URL地址必须以 api.weibo.com 开头</p>
	    	
	    </div>
	</div>
</body>
</html>