package com.example.business2.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author moubin.mo
 * @date: 2021/2/13 10:53
 */

public class TestEvent extends ApplicationEvent {
	/**
	 * Create a new {@code ApplicationEvent}.
	 *
	 * @param source the object on which the event initially occurred or with
	 *               which the event is associated (never {@code null})
	 */
	public TestEvent(TestInfo source) {
		super(source);
	}
}
