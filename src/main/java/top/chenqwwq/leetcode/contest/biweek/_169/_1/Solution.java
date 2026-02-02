package top.chenqwwq.leetcode.contest.biweek._169._1;

/**
 * @author chenqwwq
 * @date 2025/11/10
 **/
public class Solution {
    public int minMoves(int[] nums) {
        int max = -1, total = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            total += num;
        }
        return max * nums.length - total;
    }
}