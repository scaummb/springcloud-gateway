package com.example.business2.service;

import com.example.business2.zk.ZooKeeperClientSession;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author moubin.mo
 * @date: 2021/2/12 17:40
 */
@Component
public class ZkTestProviderImpl implements ZkTestProvider {

	private static final String ROOT_PATH = "/momoubin";

	@Autowired(required = false)
	private ZooKeeper zooKeeper;

	@PostConstruct
	public void init(){
		if (zooKeeper != null){
			try {
				Stat stat = zooKeeper.exists(ROOT_PATH, false);
				if (stat == null){
					zooKeeper.create(ROOT_PATH, "momoubin".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (KeeperException e) {
				e.printStackTrace();
			}
		} else {
			try {
				zooKeeper = new ZooKeeper("0.0.0.0:2182", 10000, new ZooKeeperClientSession());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void registeCallbackUrl(String className, String url) {
		synchronized (ZkTestProviderImpl.class){
			try {
				Stat stat = zooKeeper.exists(ROOT_PATH, false);
				if (stat == null){
					zooKeeper.create(ROOT_PATH, url.getBytes(StandardCharsets.UTF_8), ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
				} else {
					zooKeeper.delete(ROOT_PATH, -1);
					zooKeeper.create(ROOT_PATH, url.getBytes(StandardCharsets.UTF_8), ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
				}
			} catch (KeeperException | InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public ZooKeeper getZkClient() {
		return zooKeeper;
	}

	@Override
	public String getRootPath() {
		return ROOT_PATH;
	}
}
