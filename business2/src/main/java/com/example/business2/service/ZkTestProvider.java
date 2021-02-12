package com.example.business2.service;

import com.example.business2.zk.ZkProvider;

/**
 * @author moubin.mo
 * @date: 2021/2/12 17:41
 */

public interface ZkTestProvider extends ZkProvider {

	void registeCallbackUrl(String className, String url);
}
