package com.example.business2.service;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.nio.charset.StandardCharsets;

/**
 * @author moubin.mo
 * @date: 2021/2/12 17:40
 */
@Component
public class ZkTestProviderImpl implements ZkTestProvider {

	private static final String ROOT_PATH = "/momoubin";
	@Autowired(required = false)
	private ZooKeeper zk;

	@PostConstruct
	public void init(){
		if (zk != null){
			try {
				Stat stat = zk.exists(ROOT_PATH, false);
				if (stat == null){
					zk.create(ROOT_PATH, "momoubin".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (KeeperException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void registeCallbackUrl(String className, String url) {
		synchronized (ZkTestProviderImpl.class){
			try {
				Stat stat = zk.exists(ROOT_PATH, false);
				if (stat == null){
					zk.create(ROOT_PATH, url.getBytes(StandardCharsets.UTF_8), ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.CONTAINER);
				} else {
					zk.delete(ROOT_PATH, -1);
					zk.create(ROOT_PATH, url.getBytes(StandardCharsets.UTF_8), ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.CONTAINER);
				}
			} catch (KeeperException | InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

	@Override
	public ZooKeeper getZkClient() {
		return null;
	}

	@Override
	public String getRootPath() {
		return null;
	}
}
