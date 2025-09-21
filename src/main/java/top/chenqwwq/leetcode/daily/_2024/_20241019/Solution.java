package top.chenqwwq.leetcode.daily._2024._20241019;

/**
 * @author chenqwwq
 * @date 2024/10/19
 **/
public class Solution {
    public int minOperations(int[] nums) {
        int k = 0;
        for (int x : nums) {
            if (x == k % 2) { // 必须操作
                k++;
            }
        }
        return k;
    }
}