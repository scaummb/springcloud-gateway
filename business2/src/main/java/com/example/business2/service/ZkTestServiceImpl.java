package com.example.business2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author moubin.mo
 * @date: 2021/2/12 17:43
 */
@Component
public class ZkTestServiceImpl implements ApplicationListener<ApplicationReadyEvent> {
	@Value("${spring.application.name}")
	private String serviceName;
	@Value("${server.servlet.contextPath}")
	private String contextPath;

	@Autowired
	private ZkTestProvider zkTestProvider;

	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {

	}

	private void init() {
		String clientUrl = "http://".concat(serviceName).concat(contextPath);
		zkTestProvider.registeCallbackUrl("zknode", clientUrl);
	}
}
