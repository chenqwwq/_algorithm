package top.chenqwwq.leetcode.daily._20220716;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author chenqwwq
 * @date 2022/7/16
 **/
public class MovingAverage {
    Deque<Integer> queue = new LinkedList<>();
    int size;
    long sum = 0L;

    public MovingAverage(int size) {
        this.size = size;
    }

    public double next(int val) {
        while (queue.size() >= size) {
            Integer head = queue.removeFirst();
            sum -= head;
        }
        queue.addLast(val);
        return (double) (sum += val) / queue.size();
    }
}