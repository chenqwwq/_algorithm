package top.chenqwwq.leetcode.daily._2026._20260103;

/**
 * @author chenqwwq
 * @date 2026/1/6
 **/
public class Solution {
    public int repeatedNTimes(int[] nums) {
        int[] hash = new int[100001];
        for (int num : nums) {
            if (++hash[num] > 1) return num;
        }
        return -1;
    }
}