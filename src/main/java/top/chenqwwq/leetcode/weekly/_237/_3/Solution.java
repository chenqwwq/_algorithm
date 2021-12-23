package top.chenqwwq.leetcode.weekly._237._3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author chen
 * @date 2021/4/18
 **/
public class Solution {
    static class Pair {
        int idx;
        int[] task;

        public Pair(int idx, int[] task) {
            this.idx = idx;
            this.task = task;
        }
    }

    public int[] getOrder(int[][] tasks) {
        if (tasks == null || tasks.length == 0) {
            return new int[0];
        }
        int[] ans = new int[tasks.length];
        Pair[] pairs = new Pair[tasks.length];
        for (int i = 0; i < tasks.length; i++) {
            pairs[i] = new Pair(i, tasks[i]);
        }
        // 按照开始时间排序
        Arrays.sort(pairs, Comparator.comparingInt(o -> o.task[0]));
        // 当前正在执行的任务
        // 第一个任务开始执行的时间
        int time = pairs[0].task[0] - 1, taskTime = 0, idx = 0, taskIdx = 0;
        // 等待任务队列
        PriorityQueue<Pair> queue = new PriorityQueue<>(Comparator.comparingInt((Pair o) -> o.task[1]).thenComparingInt(o -> o.idx));

        while (taskIdx < pairs.length || queue.size() != 0) {
            // 先添加任务
            int diff = Integer.min(taskTime == 0 ? Integer.MAX_VALUE : taskTime, taskIdx < pairs.length ? pairs[taskIdx].task[0] - time : Integer.MAX_VALUE);
            time += diff;
            while (taskIdx < pairs.length && pairs[taskIdx].task[0] <= time) {
                queue.offer(pairs[taskIdx++]);
            }
            if (taskTime == 0 || (taskTime -= diff) == 0) {
                final Pair poll = queue.poll();
                if (poll == null) {
                    continue;
                }
                ans[idx++] = poll.idx;
                taskTime = poll.task[1];
            }
        }

        return ans;
    }

}

// [6,1,2,9,4,10,0,11,13,5,3,8,12,7]