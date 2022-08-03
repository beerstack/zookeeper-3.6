package org.apache.zookeeper.learn;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

/**
 * @author 杨康
 * @date 2022-08-01 09:50
 * @since 1.0.0
 */
public class PubClient {

    static String server = "/servers";

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        String hosts = "127.0.0.1";
        ZooKeeper zk = new ZooKeeper(hosts, 30000, null);
        zk.create(server+"/server1", "beerstack".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        zk.close();
    }

}
