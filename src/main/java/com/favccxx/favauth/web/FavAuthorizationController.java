package com.favccxx.favauth.web;

import java.net.URI;
import java.net.URISyntaxException;

import javax.security.auth.Subject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.security.SecurityUtil;
import org.apache.oltu.oauth2.as.issuer.MD5Generator;
import org.apache.oltu.oauth2.as.issuer.OAuthIssuer;
import org.apache.oltu.oauth2.as.issuer.OAuthIssuerImpl;
import org.apache.oltu.oauth2.as.request.OAuthAuthzRequest;
import org.apache.oltu.oauth2.as.response.OAuthASResponse;
import org.apache.oltu.oauth2.client.response.OAuthAuthzResponse;
import org.apache.oltu.oauth2.common.OAuth;
import org.apache.oltu.oauth2.common.error.OAuthError;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.OAuthResponse;
import org.apache.oltu.oauth2.common.message.types.ResponseType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.favccxx.favauth.service.IFavAuthService;

@Controller
public class FavAuthorizationController {

	@Autowired
	IFavAuthService favAuthService;
	
//	@RequestMapping("favauthorize")
	public Object authorization(HttpServletRequest request) throws OAuthSystemException, OAuthProblemException{
		//构建OAuth请求
		OAuthAuthzRequest oAuthzRequest = new OAuthAuthzRequest(request);
		//获取OAuth客户端Id
		String clientId = oAuthzRequest.getClientId();
		//校验客户端Id是否正确
		if(!favAuthService.checkClientId(clientId)){
			OAuthResponse oAuthResponse = OAuthASResponse
					.errorResponse(HttpServletResponse.SC_BAD_REQUEST)
					.setError(OAuthError.TokenResponse.INVALID_CLIENT)
					.setErrorDescription("无效的客户端Id")
					.buildJSONMessage();
			return new ResponseEntity(oAuthResponse.getBody(), HttpStatus.valueOf(oAuthResponse.getResponseStatus()));
		}
		
//		Subject subject = org.apache.catalina.security.SecurityUtil.
		//校验用户是否登陆，没有登陆的话，跳转到登陆页
		
		String username = "admin";
		
		//生成授权码
		String authCode = null;
		String responseType = oAuthzRequest.getParam(OAuth.OAUTH_RESPONSE_TYPE);
		//ResponseType仅支持CODE和TOKEN
		if(responseType.equals(ResponseType.CODE.toString())){
			OAuthIssuerImpl oAuthIssuerImpl = new OAuthIssuerImpl(new MD5Generator());
			authCode = oAuthIssuerImpl.authorizationCode();
			favAuthService.addAuthCode(authCode, username);
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
			return new ResponseEntity<>(headers, HttpStatus.valueOf(response.getResponseStatus()));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}
}
