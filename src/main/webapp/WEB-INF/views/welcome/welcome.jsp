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

</head>
<body>
	<div class="admin-content">
    <div class="am-cf am-padding">
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">OAuth 2.0</strong> / <small>使用說明</small></div>
    </div>

    <hr/>

    <div class="am-g">
      <div class="am-u-sm-12 am-u-sm-centered">
        <h2>OAuth 2.0 是什么？</h2>
        <p>OAuth 2.0是在2006年底创建的下一代OAuth协议。OAuth 2.0为客户端开发者开发Web应用，桌面端应用程序，移动应用及客厅设备提供特定的授权流程。该规范是IETF OAuth WG工作组下基于OAuth WRAP协议制定的。</p>       
        <hr/>
      </div>

      <div class="am-u-sm-12 am-u-sm-centered">
      	<h2>OAuth 2.0 能做什么?</h2>
        <p> OAuth 2.0 授权框架允许第三方应用通过代表拥有编排批准交互的资源所有者和HTTP服务的资源或者通过允许第三方应用程序获得代表自己访问受限的HTTP服务。</p>
        <hr/>
      </div>
      <div class="am-u-sm-12 am-u-sm-centered">
      	<h2>OAuth 2.0有哪些角色?</h2>
        <p> 资源拥有者（resource owner）：能够授权访问被保护资源的一个实体。当它指的一个人时，就是称之为终端用户。</p>
        <p> 资源服务器（resource server）：管理受保护资源的服务器。当使用访问令牌访问资源时，它决定是否接受该令牌并输出受保护的资源。</p>
        <p> 客户端（client）：应用程序本身不存储任何受保护的资源，而是资源所有者授权通过后，使用它的授权访问受保护的资源，然后客户端把响应的数据展示/提交给服务器。</p>
        <p> 授权服务器（authorization server）：客户端成功验证资源所有者并获取授权后，授权服务器发放访问令牌给客户端。</p>
        <hr/>
      </div>
      <div class="am-u-sm-12 am-u-sm-centered">
      	<h2>OAuth 2.0授权流程?</h2>
        <p> 1 客户端向资源拥有者发起授权请求，这种授权请求可以直接向资源拥有者发起（如图），也可以间接通过授权服务器作为中介发起。</p>
        <p> 2 客户端接收授权许可，这是一个代表资源所有者的授权凭证。授权类型可以OAuth 2.0规范中四种的任意一种，也可以是扩展授权类型。授权类型取决于方法所使用的客户端请求授权和授权服务器所支持的类型。</p>
        <p> 3 客户端通过私有证书和授权许可请求授权服务器授权。</p>
        <p> 4 授权服务器对客户端进行验证。验证通过后，返回访问令牌。</p>
        <p> 5 客户端使用访问令牌向资源服务器请求受保护资源。</p>
        <p> 6 资源服务器验证令牌的有效性，验证成功后，下发受保护的资源。</p>
        <img alt="" src="<%=basePath %>assets/images/oauth2-process.png">
        <hr/>
      </div>
      
    </div>
  </div>
</body>
</html>