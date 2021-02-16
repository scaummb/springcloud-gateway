package com.example.business2.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author moubin.mo
 * @date: 2021/2/13 10:53
 */
@Component
public class TestEventListener implements ApplicationListener<TestEvent> {
	@Override
	public void onApplicationEvent(TestEvent event) {
		TestInfo testInfo = (TestInfo) event.getSource();
		System.out.println("testInfo = " + testInfo);
	}
}
