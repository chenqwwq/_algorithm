package top.chenqwwq.leetcode.daily._2023._20231115;

/**
 * @author chenqwwq
 * @date 2023/11/15
 **/
public class Solution {
    public int maximizeSum(int[] nums, int k) {
        int max = -1;
        for (int num : nums) max = Math.max(num, max);
        int sum = 0;
        for (int i = 0; i < k; i++) sum += max + i;
        return sum;
    }
}