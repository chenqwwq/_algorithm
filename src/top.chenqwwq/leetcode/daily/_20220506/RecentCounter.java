package top.chenqwwq.leetcode.daily._20220506;

import java.util.*;

/**
 * @author chenqwwq
 * @date 2022/5/6
 **/
public class RecentCounter {

    Deque<Integer> deque;

    public RecentCounter() {
        deque = new LinkedList<>();
    }

    public int ping(int t) {
        deque.addLast(t);
        while (!deque.isEmpty() && deque.peekFirst() < t - 3000) {
            deque.removeFirst();
        }
        return deque.size();
    }
}