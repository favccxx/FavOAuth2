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
