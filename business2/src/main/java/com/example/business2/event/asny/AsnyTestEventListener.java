package com.example.business2.event.asny;

import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executors;

/**
 * <p>
 *     继承 SimpleApplicationEventMulticaster ，实现异步监听器
 *     如下我们看到在以上的判断是否自定义了多播器的代码中，判断在ioc容器中是否包含如下名字的bean作为判断条件的，所以只要我们自定义一个bean命名为applicationEventMulticaster，并把异步支持的executor植入就行了
 * </p>
 */
@Component("applicationEventMulticaster")
public class AsnyTestEventListener extends SimpleApplicationEventMulticaster {
	public AsnyTestEventListener () {
		setTaskExecutor(Executors.newSingleThreadExecutor());
	}
}
