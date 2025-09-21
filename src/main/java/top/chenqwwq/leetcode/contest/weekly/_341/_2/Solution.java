package top.chenqwwq.leetcode.contest.weekly._341._2;

/**
 * @author chenqwwq
 * @date 2023/4/16
 **/
public class Solution {
    public int maxDivScore(int[] nums, int[] divisors) {
        final int n = nums.length, m = divisors.length;
        int ans = -1, max = -1;
        for (int divisor : divisors) {
            int div = divisor, cnt = 0;
            for (int num : nums) {
                if (num % div == 0) {
                    cnt++;
                }
            }
            if (cnt > max || (cnt == max && divisor < ans)) {
                max = cnt;
                ans = divisor;
            }
        }
       return ans;
    }
}