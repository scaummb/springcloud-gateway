package com.example.business2.redis;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author moubin.mo
 * @date: 2021/2/16 17:33
 */

public class RedisServiceImpl implements ApplicationListener<ApplicationReadyEvent> {
	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		setup();
	}

	private void setup() {
		// 连接redis服务端
		JedisPool jedisPool = new JedisPool(new JedisPoolConfig(), "localhost", 6379);
		//订阅者后台线程
		SubThread subThread = new SubThread(jedisPool);
		subThread.start();
		//发布者后台线程
		Publisher publisher = new Publisher(jedisPool);
		publisher.start();
	}
}
