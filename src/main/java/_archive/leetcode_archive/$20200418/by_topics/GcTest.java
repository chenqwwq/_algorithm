package top.chenqwwq.leetcode.archive.$20200418.by_topics;

/**
 * @author bingxin.chen
 * @date 2019/10/17 10:01
 */
public class GcTest {

    private static final int SIZE = 1024 * 1024 * 60;

    public static void main(String[] args) {
        // -XX:+PrintHeapAtGC
        // 对象大小,10mb多点
        // 对象头8 + oop指针4 + 数组长度4
        // 一共是10 * 1024 * 1024 + 8 + 4 + 4个字节
        // -Xms200m -XX:+UseSerialGC -XX:NewRatio=1 -XX:+PrintGC -XX:PretenureSizeThreshold=900000000000

        byte[] k = new byte[SIZE];
        k = null;
        // s区分配60m
        byte[] k1 = new byte[SIZE];
        // 一次ygc
        // ygc一次,60m进入老年代 60m进入新生代
        byte[] k2 = new byte[SIZE];
        // 一次ygc
        // 帮助GC,避免爆堆,fgc后被清除
        k1 = null;
        // ygc,60m进入老年代,老年代空间不足触发fgc
        byte[] k3 = new byte[SIZE];
        k2 = null;
        byte[] k4 = new byte[SIZE];
        k3 = null;
        byte[] k5 = new byte[SIZE];
        k5 = null;
        byte[] k6 = new byte[SIZE];
        k6 = null;
        byte[] k7 = new byte[SIZE];
        k7 = null;
        byte[] k8 = new byte[SIZE];

    }
}
