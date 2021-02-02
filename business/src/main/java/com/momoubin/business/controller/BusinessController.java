package com.momoubin.business.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author moubin.mo
 * @date: 2021/2/2 14:42
 */
@RestController
@RequestMapping("/mmb/business")
public class BusinessController {

	private Logger LOGGER = LoggerFactory.getLogger(BusinessController.class);

	@RequestMapping("test")
	public void test(String flag){
		LOGGER.debug(flag);
	}
}
