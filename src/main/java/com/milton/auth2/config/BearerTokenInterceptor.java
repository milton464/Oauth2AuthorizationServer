package com.milton.auth2.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class BearerTokenInterceptor implements HandlerInterceptor {

	private BearerTokenWrapper bearerTokenWrapper;

	public BearerTokenInterceptor(BearerTokenWrapper bearerTokenWrapper) {
		this.bearerTokenWrapper = bearerTokenWrapper;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		final String authorizationHeaderValue = request.getHeader("Authorization");
		if (authorizationHeaderValue != null && authorizationHeaderValue.startsWith("Bearer")) {
			String token = authorizationHeaderValue.substring(7, authorizationHeaderValue.length());

			if (bearerTokenWrapper.getToken() == null || !token.equals(bearerTokenWrapper.getToken())) {
				bearerTokenWrapper.setToken(token);
			}
		}

		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
}
