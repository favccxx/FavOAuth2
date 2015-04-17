package com.favccxx.favauth.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.oltu.oauth2.common.OAuth;
import org.apache.oltu.oauth2.common.token.BasicOAuthToken;
import org.apache.oltu.oauth2.common.token.OAuthToken;
import org.springframework.web.filter.OncePerRequestFilter;

public class OAuth2LoginFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		//创建令牌
		String accessToken = request.getParameter(OAuth.OAUTH_CODE);
		BasicOAuthToken oAuthToken = new BasicOAuthToken(accessToken);
		
	}

	

}
