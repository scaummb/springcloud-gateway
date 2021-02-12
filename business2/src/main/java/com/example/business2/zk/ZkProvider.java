package com.example.business2.zk;

import org.apache.zookeeper.ZooKeeper;

/**
 * <p>
 *     zk操作接口
 * </p>
 */
public interface ZkProvider {
    ZooKeeper getZkClient();
    String getRootPath();
}
