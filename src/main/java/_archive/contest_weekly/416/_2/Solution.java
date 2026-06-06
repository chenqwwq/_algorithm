package top.chenqwwq.leetcode.contest.weekly._416._2;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author chenqwwq
 * @date 2024/9/22
 **/
public class Solution {
    class Node {
        int idx;
        long time;

        public Node(int idx, long time) {
            this.idx = idx;
            this.time = time;
        }
    }

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        final int n = workerTimes.length;
        final long[] time = new long[n];
        final int[] cnt = new int[n];
        final PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingLong(o -> time[o.idx] + o.time));
        for (int i = 0; i < n; i++) {
            queue.add(new Node(i, workerTimes[i]));
        }
        long ans = 0;
        for (int i = 0; i < mountainHeight; i++) {
            final Node poll = queue.poll();
            time[poll.idx] += poll.time;
            cnt[poll.idx]++;
            ans = Math.max(ans, time[poll.idx]);
            while (!queue.isEmpty() && queue.peek().time + time[queue.peek().idx] <= time[poll.idx]) {
                final Node p = queue.poll();
                time[p.idx] += p.time;
                cnt[p.idx]++;
                queue.offer(new Node(p.idx, (long) (cnt[p.idx] + 1) * workerTimes[p.idx]));
                i++;
            }
            queue.offer(new Node(poll.idx, (long) (cnt[poll.idx] + 1) * workerTimes[poll.idx]));
        }
        return ans;
    }
}