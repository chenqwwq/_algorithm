package top.chenqwwq.leetcode.archive.lcof2._41;

import java.util.LinkedList;

/**
 * @author chenbingxin
 * @date 2022/1/4
 **/
public class MovingAverage {

    LinkedList<Integer> data;
    int size;
    int total;

    /**
     * Initialize your data structure here.
     */
    public MovingAverage(int size) {
        this.data = new LinkedList<>();
        this.size = size;
    }

    public double next(int val) {
        total += val;
        data.addLast(val);
        while (data.size() > size) {
            total -= data.removeFirst();
        }
        return 1d * total / data.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */