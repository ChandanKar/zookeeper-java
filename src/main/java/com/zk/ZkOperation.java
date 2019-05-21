package com.zk;

import java.util.List;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

public class ZkOperation {

	private static ZooKeeper zk;

	private static ZkConnector zkc;

	ZkOperation(String zkAddress) {
		zkc = new ZkConnector();
		try {
			zk = zkc.connect(zkAddress);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void create(String path, byte[] data) throws KeeperException, InterruptedException {
		zk.create(path, data, Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
	}

	public byte[] read(String path) throws KeeperException, InterruptedException {
		return zk.getData(path, true, zk.exists(path, true));
	}

	public void update(String path, byte[] data) throws KeeperException, InterruptedException {
		zk.setData(path, data, zk.exists(path, true).getVersion());
	}

	public void delete(String path) throws KeeperException, InterruptedException {
		zk.delete(path, zk.exists(path, true).getVersion());
	}

	public List<String> getClildNodes(String path) throws KeeperException, InterruptedException {
		return zk.getChildren(path, true);
	}

}
