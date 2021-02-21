package com.example.business2.controller;

import com.example.business2.service.ZkTestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author moubin.mo
 * @date: 2021/2/12 21:41
 */
@RestController
@RequestMapping("/zk")
public class ZkTestsController {

	@Autowired
	private ZkTestServiceImpl zkTestService;

	@RequestMapping("zktest")
	public String test(){
		zkTestService.init();
		return "ok";
	}

}
