package com.momoubin.business.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author moubin.mo
 * @date: 2021/2/21 00:12
 */
@RestController
@RequestMapping("/redirect")
public class RedirectController {
	@RequestMapping("test")
	public Object test(HttpServletRequest servletRequest, HttpServletResponse servletResponse) throws URISyntaxException {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setLocation(new URI("http://www.baidu.com"));
		//303，重定向到location
		return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);
	}
}
