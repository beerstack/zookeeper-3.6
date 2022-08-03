package org.apache.zookeeper.learn;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.List;

/**
 * @author 杨康
 * @date 2022-08-01 09:51
 * @since 1.0.0
 */
public class SubClient {

    static ZooKeeper zk;
    static String server = "/servers";

    public static void main(String[] args) throws InterruptedException, IOException, KeeperException {
        String hosts = "127.0.0.1:2181";
        zk = new ZooKeeper(hosts, 30000, event -> {
            System.out.println("收到一条watch数据, 类型=" + event.getType()+",path="+event.getPath());
        });
        List<String> subList = zk.getChildren(server, true);
        System.out.println(subList);
        Thread.sleep(Integer.MAX_VALUE);
    }

}
