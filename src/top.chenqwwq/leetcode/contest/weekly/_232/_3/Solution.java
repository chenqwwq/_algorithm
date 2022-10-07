package top.chenqwwq.leetcode.contest.weekly._232._3;

import java.math.BigDecimal;
import java.util.PriorityQueue;

/**
 * @author chen
 * @date 2021/3/14
 **/
public class Solution {

    private Float getF(Integer[] o) {
        int i = o[1] - o[0];
        int j = (o[1] + 1) * o[1];

        return ((float) i) / ((float) j);
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<Integer[]> priorityQueue = new PriorityQueue<>((o1, o2) -> getF(o2).compareTo(getF(o1)));

        for (int[] arr : classes) {
            priorityQueue.add(new Integer[]{arr[0], arr[1]});
        }

        while (extraStudents != 0 && !priorityQueue.isEmpty()) {
            Integer[] poll = priorityQueue.poll();
            priorityQueue.offer(new Integer[]{poll[0] + 1, poll[1] + 1});
            extraStudents--;
        }

        double sum = 0.0;
        while (!priorityQueue.isEmpty()) {
            Integer[] poll = priorityQueue.poll();
            sum += ((double) poll[0] / (double) poll[1]);
        }

        return new BigDecimal(sum / classes.length).setScale(5, BigDecimal.ROUND_DOWN).doubleValue();
    }
}
