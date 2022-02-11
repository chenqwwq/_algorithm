package top.chenqwwq.leetcode.lcof2._42;

import java.util.LinkedList;

/**
 * @author chenbingxin
 * @date 2022/1/4
 **/
public class RecentCounter {

    LinkedList<Integer> recent = new LinkedList<>();

    public RecentCounter() {
        // NOOP
    }

    public int ping(int t) {
        recent.addLast(t);
        final int start = t - 3000;
        while (!recent.isEmpty() && recent.peek() < start){
            recent.removeFirst();
        }
        return recent.size();
    }
}
