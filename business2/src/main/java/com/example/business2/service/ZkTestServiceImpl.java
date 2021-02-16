package com.example.business2.service;

import com.example.business2.event.TestEvent;
import com.example.business2.event.TestInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author moubin.mo
 * @date: 2021/2/12 17:43
 */
@Component
public class ZkTestServiceImpl implements ApplicationListener<ApplicationReadyEvent> {
	@Value("${server.targetserver.name}")
	private String serviceName;
	@Value("${server.servlet.contextPath}")
	private String contextPath;
	@Autowired
	private ZkTestProvider zkTestProvider;
	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;

	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		init();
	}

	private void publishEvent() {
		TestInfo testInfo = new TestInfo();
		testInfo.setInfo("zk-init");
		TestEvent testEvent = new TestEvent(testInfo);
		applicationEventPublisher.publishEvent(testEvent);
	}

	public void init() {
		String clientUrl = "http://".concat(serviceName).concat(contextPath);
		zkTestProvider.registeCallbackUrl("zknode", clientUrl);
		publishEvent();
	}
}
