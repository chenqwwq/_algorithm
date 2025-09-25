package top.chenqwwq.leetcode.contest.weekly._468._2;

/**
 * @author chenqwwq
 * @date 2025/9/23
 **/
public class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int min = Integer.MAX_VALUE,max = Integer.MIN_VALUE;
        for(int num : nums){
            min = Math.min(min,num);
            max = Math.max(max,num);
        }
        return (long) k * (max - min);
    }
}