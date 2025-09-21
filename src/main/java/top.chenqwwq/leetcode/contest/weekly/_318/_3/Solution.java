package top.chenqwwq.leetcode.contest.weekly._318._3;

import java.util.PriorityQueue;

/**
 * @author chenqwwq
 * @date 2022/11/7
 **/
public class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        final int n = costs.length;
        PriorityQueue<Integer> front = new PriorityQueue<>(), back = new PriorityQueue<>();
        int i = 0, j = n - 1;
        for (; i < Math.min(candidates, n); i++) front.add(costs[i]);
        for (; j >= Math.max(n - candidates, 0) && j >= i; j--) back.add(costs[j]);
        long ans = 0;
        while (k-- > 0) {
            if (front.isEmpty() && back.isEmpty()) break;
            else if (front.isEmpty()) ans += back.poll();
            else if (back.isEmpty()) ans += front.poll();
            else {
                if (front.peek() <= back.peek()) {
                    ans += front.poll();
                    if (i <= j ) front.add(costs[i++]);
                } else {
                    ans += back.poll();
                    if (j >= i) back.add(costs[j--]);
                }
            }
        }
        return ans;
    }
}