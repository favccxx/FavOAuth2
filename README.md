# FavOAuth2
1. OAuth 2.0 是什么？

    OAuth 2.0是在2006年底创建的下一代OAuth协议。OAuth 2.0为客户端开发者开发Web应用，桌面端应用程序，移动应用及客厅设备提供特定的授权流程。该规范是IETF OAuth WG工作组下基于OAuth WRAP协议制定的。

2. OAuth 2.0 能做什么？

    OAuth 2.0 授权框架允许第三方应用通过代表拥有编排批准交互的资源所有者和HTTP服务的资源或者通过允许第三方应用程序获得代表自己访问受限的HTTP服务。

3. OAuth 2.0有哪些角色？

    资源拥有者（resource owner）：能够授权访问被保护资源的一个实体。当它指的一个人时，就是称之为终端用户。

    资源服务器（resource server）：管理受保护资源的服务器。当使用访问令牌访问资源时，它决定是否接受该令牌并输出受保护的资源。

    客户端（client）：应用程序本身不存储任何受保护的资源，而是资源所有者授权通过后，使用它的授权访问受保护的资源，然后客户端把响应的数据展示/提交给服务器。
使受保护的资源请求资源所有者的代表和授权。

    授权服务器（authorization server）：客户端成功验证资源所有者并获取授权后，授权服务器发放访问令牌给客户端。

4. OAuth 2.0授权流程

    4.1 客户端向资源拥有者发起授权请求，这种授权请求可以直接向资源拥有者发起（如图），也可以间接通过授权服务器作为中介发起。

    4.2 客户端接收授权许可，这是一个代表资源所有者的授权凭证。授权类型可以OAuth 2.0规范中四种的任意一种，也可以是扩展授权类型。授权类型取决于方法所使用的客户端请求授权和授权服务器所支持的类型。

    4.3 客户端通过私有证书和授权许可请求授权服务器授权。

    4.4 授权服务器对客户端进行验证。验证通过后，返回访问令牌。

    4.5 客户端使用访问令牌向资源服务器请求受保护资源。

    4.6 资源服务器验证令牌的有效性，验证成功后，下发受保护的资源。
    
# FavOAuth2 开发技术及环境搭建说明

5. 主要开发组件

- Jdk 1.8
- Spring 4.x
- Hibernate 5.x
- Oracle 11g
- Apache oltu 1.x
- Ehcache 2.x     
- Httpclient 4.x
- Tomcat 9.x

6. 开发环境搭建说明

6.1 修改数据库配置文件：database.properties，将其指向真实存在的数据库地址

6.2 如果数据库为MySQL，则需要更改com.favccxx.favauth.model包下的实体类的主键生成策略

6.3 如果用户修改项目名称或Tomcat的端口号，则需AuthCodeClientController和AuthResourceClientController Java类以及oauth2_login.jsp文件

由于本项目采用Hibernate可以在运行动态创建数据库，故没有提供数据库运行脚本。


# OAuth2 的主要实现类

7. 客户端

7.1 申请授权代码

- 为了让页面效果显示更流畅，申请授权代码的功能是在WEB页面发起的。

7.2 申请访问令牌

```java  
  
package com.favccxx.favauth.controller.client;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.oltu.oauth2.common.OAuth;
import org.apache.oltu.oauth2.common.message.types.GrantType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.favccxx.favauth.service.IAuthVerifyService;
import com.favccxx.favauth.util.HttpClientUtils;

/**
 * 模拟构建客户端访问请求
 * @author favccxx
 *
 */
@Controller
@RequestMapping("client")
public class AuthCodeClientController {

	@Autowired
	IAuthVerifyService authVerifyService;

	/**
	 * 根据服务器端的授权许可构造申请访问令牌请求
	 * @param request
	 * @return
	 */
	@RequestMapping("authCodeRequest")
	public ModelAndView authCodeRequest(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		String authCode = request.getParameter(OAuth.OAUTH_CODE);
		String clientId = request.getParameter(OAuth.OAUTH_CLIENT_ID);
		String clientSecret = request.getParameter(OAuth.OAUTH_CLIENT_SECRET);
//		String accessTokenUrl = "http://localhost:8080/FavOAuth2/server/applyAccessToken";
		String redirectUrl = "http://localhost:8080/FavOAuth2/client/";
		
		if (StringUtils.isEmpty(authCode)) {
			mav.setViewName("client/home_client");
			return mav;
		}
		
		// 使用授权码去服务端获取令牌
		if (authVerifyService.checkAuthCode(authCode)) {
			// 此处应采用XXX方法调用FavAccessTokenController获取返回的值
			String userName = authVerifyService.getUsernameByAuthCode(authCode);
			
			String url = "http://localhost:8080/FavOAuth2/server/applyAccessToken";
			Map<String, String> paramMap = new HashMap<String, String>();
			paramMap.put(OAuth.OAUTH_STATE, "123");	
			paramMap.put(OAuth.OAUTH_SCOPE, "RRR");
			paramMap.put(OAuth.OAUTH_REDIRECT_URI, "ding.com");
			paramMap.put(OAuth.OAUTH_GRANT_TYPE, String.valueOf(GrantType.AUTHORIZATION_CODE));
			paramMap.put(OAuth.OAUTH_CLIENT_ID, clientId);
			paramMap.put(OAuth.OAUTH_CODE, authCode);
			paramMap.put(OAuth.OAUTH_CLIENT_SECRET, clientSecret);
			paramMap.put(OAuth.OAUTH_REDIRECT_URI, redirectUrl);
			paramMap.put(OAuth.OAUTH_USERNAME, userName);
			
			String accessToken = HttpClientUtils.doPost(url, paramMap);

			mav.addObject("accessToken", accessToken);
			mav.setViewName("redirect:http://localhost:8080/FavOAuth2/client/applyAuthUser");

		}

		return mav;
	}

}

  
```

7.3 根据访问令牌申请获取用户信息

```java  
  
package com.favccxx.favauth.controller.client;

import org.apache.oltu.oauth2.client.OAuthClient;
import org.apache.oltu.oauth2.client.URLConnectionClient;
import org.apache.oltu.oauth2.client.request.OAuthBearerClientRequest;
import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import org.apache.oltu.oauth2.client.response.OAuthResourceResponse;
import org.apache.oltu.oauth2.common.OAuth;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 根据访问令牌获取登录用户信息
 * 
 * @author favccxx
 *
 */
@Controller
@RequestMapping("client")
public class AuthResourceClientController {

	@RequestMapping(value="/applyAuthUser", produces = "text/html;charset=UTF-8")
	public ModelAndView applyAuthUser(String accessToken) {
		ModelAndView mav = new ModelAndView();
		// 资源认证服务器
		String authResourceServer = "http://localhost:8080/FavOAuth2/server/authUserInfo";
		OAuthClient oAuthClient = new OAuthClient(new URLConnectionClient());
		OAuthClientRequest authUserRequest;
		try {
			authUserRequest = new OAuthBearerClientRequest(authResourceServer).setAccessToken(accessToken).buildQueryMessage();
			
			OAuthResourceResponse resourceResponse = oAuthClient.resource(authUserRequest, OAuth.HttpMethod.GET,
					OAuthResourceResponse.class);
	
			String userName = resourceResponse.getBody();
			System.out.println(userName);
			

			mav.addObject("userName", userName);
			mav.setViewName("client/auth_user");
			
		} catch (OAuthSystemException e) {
			
			e.printStackTrace();
		} catch (OAuthProblemException e) {
			e.printStackTrace();
		}		

		return mav;
	}
}

  
```

8、 服务端

8.1 提供授权代码

```java  
  
package com.favccxx.favauth.controller.server;

import java.net.URI;
import java.net.URISyntaxException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.oltu.oauth2.as.issuer.MD5Generator;
import org.apache.oltu.oauth2.as.issuer.OAuthIssuerImpl;
import org.apache.oltu.oauth2.as.request.OAuthAuthzRequest;
import org.apache.oltu.oauth2.as.response.OAuthASResponse;
import org.apache.oltu.oauth2.common.OAuth;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.OAuthResponse;
import org.apache.oltu.oauth2.common.message.types.ResponseType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.favccxx.favauth.constants.OAuth2Constants;
import com.favccxx.favauth.model.AuthClient;
import com.favccxx.favauth.service.IAuthClientService;
import com.favccxx.favauth.service.IAuthVerifyService;



@Controller
@RequestMapping("/server")
public class AuthorizationController {
	
	@Autowired
	IAuthClientService authClientService;
	@Autowired
	IAuthVerifyService authVerifyService;
	
	@RequestMapping("applyAuthorize")
	public ModelAndView applyAuthorize(HttpServletRequest request) throws OAuthSystemException, OAuthProblemException{
		ModelAndView mav = new ModelAndView();
//		String username, String webKey, String scope, String state,String display
		//构建OAuth请求
		OAuthAuthzRequest oAuthzRequest = new OAuthAuthzRequest(request);
		//获取OAuth客户端Id
		String clientId = oAuthzRequest.getClientId();
		//校验客户端Id是否正确
		AuthClient authClient = authClientService.findByClientId(clientId);
		if(authClient==null) {
//			OAuthResponse oAuthResponse = OAuthASResponse
//					.errorResponse(HttpServletResponse.SC_BAD_REQUEST)
//					.setError(OAuthError.TokenResponse.INVALID_CLIENT)
//					.setErrorDescription("无效的客户端Id")
//					.buildJSONMessage();
			mav.addObject(OAuth2Constants.OAUTH_AUTHORIZE_FAILED_KEY, "无效的客户端Id");
			mav.setViewName("forward:/server/authorizeFailed");
			return mav;
		}
		

		
		String username = authClient.getClientName();
		
		//生成授权码
		String authCode = null;
		String responseType = oAuthzRequest.getParam(OAuth.OAUTH_RESPONSE_TYPE);
		//ResponseType仅支持CODE和TOKEN
		if(responseType.equals(ResponseType.CODE.toString())){
			OAuthIssuerImpl oAuthIssuerImpl = new OAuthIssuerImpl(new MD5Generator());
			authCode = oAuthIssuerImpl.authorizationCode();
			authVerifyService.addAuthCode(authCode, username);
		}
		
		//构建OAuth响应
		OAuthASResponse.OAuthAuthorizationResponseBuilder builder = OAuthASResponse.authorizationResponse(request, HttpServletResponse.SC_FOUND);
		
		//设置授权码
		builder.setCode(authCode);
		
		//获取客户端重定向地址
		String redirectURI = oAuthzRequest.getParam(OAuth.OAUTH_REDIRECT_URI);
		
		//构建响应
		OAuthResponse response = builder.location(redirectURI).buildBodyMessage();
		//根据OAuthResponse返回ResponseEntity响应
		HttpHeaders headers = new HttpHeaders();
		try {
			headers.setLocation(new URI(response.getLocationUri()));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		
		mav.addObject(OAuth.OAUTH_CLIENT_ID, clientId);
		mav.addObject(OAuth.OAUTH_CLIENT_SECRET, authClient.getClientSecret());

		
		
		mav.addObject(OAuth.OAUTH_CODE, authCode);
		mav.setViewName("redirect:"+redirectURI);
		return mav;
	}

}

  
```

8.2 提供访问令牌

```java  
package com.favccxx.favauth.controller.server;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.oltu.oauth2.as.issuer.MD5Generator;
import org.apache.oltu.oauth2.as.issuer.OAuthIssuerImpl;
import org.apache.oltu.oauth2.as.request.OAuthTokenRequest;
import org.apache.oltu.oauth2.as.response.OAuthASResponse;
import org.apache.oltu.oauth2.common.OAuth;
import org.apache.oltu.oauth2.common.error.OAuthError;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.OAuthResponse;
import org.apache.oltu.oauth2.common.message.types.GrantType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.favccxx.favauth.model.AuthClient;
import com.favccxx.favauth.service.IAuthClientService;
import com.favccxx.favauth.service.IAuthVerifyService;

@Controller
@RequestMapping("/server")
public class AccessTokenController {
	
	@Autowired
	IAuthClientService authClientService;
	@Autowired
	IAuthVerifyService authVerifyService;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="applyAccessToken", method= {RequestMethod.POST})
	public HttpEntity applyAccessToken(HttpServletRequest request) throws OAuthSystemException, OAuthProblemException{
		//构建OAuth请求
		OAuthTokenRequest tokenRequest = new OAuthTokenRequest(request);
		//获取OAuth客户端Id
		String clientId = tokenRequest.getClientId();
		//校验客户端Id是否正确
		AuthClient authClient = authClientService.findByClientId(clientId);
		if(authClient==null) {
			OAuthResponse oAuthResponse = OAuthASResponse
					.errorResponse(HttpServletResponse.SC_BAD_REQUEST)
					.setError(OAuthError.TokenResponse.INVALID_CLIENT)
					.setErrorDescription("无效的客户端Id")
					.buildJSONMessage();
			return new ResponseEntity(oAuthResponse.getBody(), HttpStatus.valueOf(oAuthResponse.getResponseStatus()));
		}
				
		
		//检查客户端安全KEY是否正确
		if(!authVerifyService.checkClientSecret(tokenRequest.getClientSecret())){
			OAuthResponse response = OAuthResponse.errorResponse(HttpServletResponse.SC_UNAUTHORIZED)
						.setError(OAuthError.TokenResponse.UNAUTHORIZED_CLIENT)
						.setErrorDescription("客户端安全KEY认证失败！")
						.buildJSONMessage();
			return new ResponseEntity(response.getBody(), HttpStatus.valueOf(response.getResponseStatus()));
		}
		
		
		String authCode = tokenRequest.getParam(OAuth.OAUTH_CODE);
		//验证类型，有AUTHORIZATION_CODE/PASSWORD/REFRESH_TOKEN/CLIENT_CREDENTIALS
		if(tokenRequest.getParam(OAuth.OAUTH_GRANT_TYPE).equals(GrantType.AUTHORIZATION_CODE.toString())){
			if(!authVerifyService.checkAuthCode(authCode)){
				OAuthResponse response = OAuthResponse.errorResponse(HttpServletResponse.SC_BAD_REQUEST)
						.setError(OAuthError.TokenResponse.INVALID_GRANT)
		                .setErrorDescription("错误的授权码")  
		                .buildJSONMessage();
				return new ResponseEntity(response.getBody(), HttpStatus.valueOf(response.getResponseStatus()));
			}
		}
		
		//生成访问令牌
		OAuthIssuerImpl authIssuerImpl = new OAuthIssuerImpl(new MD5Generator());
		String accessToken = authIssuerImpl.accessToken();
		authVerifyService.addAccessToken(accessToken, authVerifyService.getUsernameByAuthCode(authCode));
		
		//生成OAuth响应
		OAuthResponse response = OAuthASResponse
				.tokenResponse(HttpServletResponse.SC_OK)
				.setAccessToken(accessToken)
				.setExpiresIn(String.valueOf(authVerifyService.getExpireIn()))
				.buildJSONMessage();
		return new ResponseEntity(response.getBody(), HttpStatus.valueOf(response.getResponseStatus()));
	}

}  

  
```

8.3 提供授权资源（用户信息）

```java  
  
package com.favccxx.favauth.controller.server;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.oltu.oauth2.common.OAuth;
import org.apache.oltu.oauth2.common.error.OAuthError;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.OAuthResponse;
import org.apache.oltu.oauth2.common.message.types.ParameterStyle;
import org.apache.oltu.oauth2.common.utils.OAuthUtils;
import org.apache.oltu.oauth2.rs.request.OAuthAccessResourceRequest;
import org.apache.oltu.oauth2.rs.response.OAuthRSResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.favccxx.favauth.service.IAuthUserService;
import com.favccxx.favauth.service.IAuthVerifyService;

@Controller
@RequestMapping("/server")
public class AuthUserController {

	@Autowired
	IAuthUserService authUserService;
	@Autowired
	IAuthVerifyService authVerifyService;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/authUserInfo", produces = "text/html;charset=UTF-8")
	public HttpEntity authUserInfo(HttpServletRequest request) throws OAuthSystemException {
		try {
			// 构建OAuth资源请求
			OAuthAccessResourceRequest oauthRequest = new OAuthAccessResourceRequest(request, ParameterStyle.QUERY);			
			String accessToken = oauthRequest.getAccessToken();

			Object resp = JSON.parse(accessToken);    
	        Map map = (Map)resp;  
	        String accessTokenKey = "";
	        if(map.containsKey(OAuth.OAUTH_ACCESS_TOKEN)) {
	        	accessTokenKey = (String)map.get(OAuth.OAUTH_ACCESS_TOKEN);
	        }
			
			// 验证访问令牌
			if (!authVerifyService.checkAccessToken(accessTokenKey)) {
				// 如果不存在/过期了，返回未验证错误，需重新验证
				OAuthResponse oauthResponse = OAuthRSResponse.errorResponse(HttpServletResponse.SC_UNAUTHORIZED)
						.setRealm("Apache Oltu").setError(OAuthError.ResourceResponse.INVALID_TOKEN)
						.buildHeaderMessage();

				HttpHeaders headers = new HttpHeaders();
				headers.add(OAuth.HeaderType.WWW_AUTHENTICATE,
						oauthResponse.getHeader(OAuth.HeaderType.WWW_AUTHENTICATE));
				return new ResponseEntity(headers, HttpStatus.UNAUTHORIZED);
			}
			
			// 返回用户名
			
			
			
			String username = authVerifyService.getUsernameByAccessToken(accessTokenKey);
			return new ResponseEntity(username, HttpStatus.OK);
		} catch (OAuthProblemException e) {
			e.printStackTrace();

			// 检查是否设置了错误码
			String errorCode = e.getError();
			if (OAuthUtils.isEmpty(errorCode)) {
				OAuthResponse oauthResponse = OAuthRSResponse.errorResponse(HttpServletResponse.SC_UNAUTHORIZED)
						.buildHeaderMessage();

				HttpHeaders headers = new HttpHeaders();
				headers.add(OAuth.HeaderType.WWW_AUTHENTICATE,
						oauthResponse.getHeader(OAuth.HeaderType.WWW_AUTHENTICATE));

				return new ResponseEntity(headers, HttpStatus.UNAUTHORIZED);
			}

			OAuthResponse oauthResponse = OAuthRSResponse
					.errorResponse(HttpServletResponse.SC_UNAUTHORIZED)
					.setError(e.getError())
					.setErrorDescription(e.getDescription())
					.setErrorUri(e.getUri())
					.buildHeaderMessage();

			HttpHeaders headers = new HttpHeaders();
			headers.add(OAuth.HeaderType.WWW_AUTHENTICATE,
			oauthResponse.getHeader(OAuth.HeaderType.WWW_AUTHENTICATE));

			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}

}

```

# FavOAuth2 示例页面


9.1 项目主页

![image](https://github.com/favccxx/FavOAuth2/tree/raw/src/main/webapp/assets/images/examples/OAuth_home.png)
  

9.2 第三方应用程序的网站管理员申请使用FavOAuth2.0登录

![image](https://github.com/favccxx/FavOAuth2/tree/raw/src/main/webapp/assets/images/examples/OAuth_ApplySite.png)

9.3 FavOAuth2.0服务器的应用管理员进行审批

![image](https://github.com/favccxx/FavOAuth2/tree/raw/src/main/webapp/assets/images/examples/OAuth_ApproveSite.png)

9.4 模拟第三方网站的外部用户登录（为简化操作，这里使用的是第三方网站名称）

![image](https://github.com/favccxx/FavOAuth2/tree/raw/src/main/webapp/assets/images/examples/OAuth_login.png)

9.5 FavOAuth2.0服务器授权用户使用FavOAuth2.0的账号访问第三方网站

![image](https://github.com/favccxx/FavOAuth2/tree/raw/src/main/webapp/assets/images/examples/OAuth_Authorization.png)

9.6 第三方用户登录成功，可以使用FavOAuth2.0的账号访问FavOAuth2.0提供的一些公共接口。

![image](https://github.com/favccxx/FavOAuth2/tree/raw/src/main/webapp/assets/images/examples/OAuth_Success.png)

