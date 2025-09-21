package top.chenqwwq.leetcode.daily._2022._20220809;

/**
 * @author chenqwwq
 * @date 2022/8/9
 **/
public class Solution {
    public int minStartValue(int[] nums) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            min = Math.min(sum, min);
        }
        return Math.max(1 - min,1);
    }
}