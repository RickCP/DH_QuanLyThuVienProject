package com.quanlythuvien.security.service;

import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

/**
 *
 * @author lvhuy08t2@gmail.com
 *
 */
public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
	private static final String FAILURE_URL = "/tk/dangnhap?error=1";
	public CustomAuthenticationFailureHandler() {
		/**
		 * for keeping ModelAttribute in target model;
		 */
		this.setUseForward(true);
		this.setDefaultFailureUrl(FAILURE_URL);
	}
}
