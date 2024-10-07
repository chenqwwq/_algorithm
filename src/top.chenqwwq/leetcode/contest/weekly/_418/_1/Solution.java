package top.chenqwwq.leetcode.contest.weekly._418._1;

/**
 * @author chenqwwq
 * @date 2024/10/6
 **/
public class Solution {
    public int maxGoodNumber(int[] nums) {
        String a = Integer.toBinaryString(nums[0]), b = Integer.toBinaryString(nums[1]), c = Integer.toBinaryString(nums[2]);
        return max(convert(a + b + c), convert(a + c + b), convert(b + a + c), convert(b + c + a), convert(c + a + b), convert(c + b + a));
    }

    public int max(int... nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        return max;
    }

    public int convert(String num) {
        long base = 1, ans = 0;
        for (int i = num.length() - 1; i >= 0; i--) {
            ans += (base * (num.charAt(i) - '0'));
            base <<= 1;
        }
        return (int) ans;
    }
}