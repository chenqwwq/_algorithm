package top.chenqwwq.leetcode.weekly._301._2;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author chenqwwq
 * @date 2022/7/10
 **/
public class SmallestInfiniteSet {
    private int min = 1;
    private PriorityQueue<Integer> remain;
    private Set<Integer> remainSet;

    public SmallestInfiniteSet() {
        remain = new PriorityQueue<>();
        remainSet = new HashSet<>();
    }

    public int popSmallest() {
        if (!remain.isEmpty()) {
            Integer ret = remain.poll();
            remainSet.remove(ret);
            return ret;
        }
        return min++;
    }

    public void addBack(int num) {
        if (num < min && !remainSet.contains(num)) {
            remainSet.add(num);
            remain.add(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */