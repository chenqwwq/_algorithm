package top.chenqwwq.leetcode.daily._2024._20241020;

/**
 * @author chenqwwq
 * @date 2024/10/20
 **/
public class Solution {
    public int smallestRangeI(int[] nums, int k) {
        int mn = nums[0], mx = nums[0];
        for (int x : nums) {
            mn = Math.min(mn, x);
            mx = Math.max(mx, x);
        }
        return Math.max(mx - mn - 2 * k, 0);
    }
    public static void main(String[] args) {
        System.err.println("");
    }
}