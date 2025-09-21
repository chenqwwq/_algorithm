package top.chenqwwq.leetcode.contest.weekly._342._3;


import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author chenqwwq
 * @date 2023/4/23
 **/
public class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        final int n = nums.length;
        boolean[] lor = new boolean[n];
        // 维护一个大顶堆和小顶堆
        PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2) -> Integer.compare(nums[o2], nums[o1])),
                right = new PriorityQueue<>(Comparator.comparingInt(o -> nums[o]));

        int[] ans = new int[n - k + 1];
        int p = 0;

        for (int i = 0; i < n; i++) {
            if (left.size() < x) {
                left.add(i);
                lor[i] = true;
            } else if (nums[left.peek()] > nums[i]) {
                final Integer poll = left.poll();
                right.add(poll);
                left.add(i);
                lor[poll] = false;
                lor[i] = true;
            } else {
                right.add(i);
                lor[i] = false;
            }
            // 从长度满k开始计数,并删除最前一个值
            if (i >= k - 1) {
                final Integer peek = left.peek();
                ans[p++] = Math.min(nums[peek], 0);
                int num = i - k + 1;
                if (lor[num]) {
                    left.remove(num);
                    if(!right.isEmpty()){
                        final Integer poll = right.poll();
                        left.add(poll);
                        lor[poll] = true;
                    }
                } else right.remove(num);
            }
        }
        return ans;
    }
}