package top.chenqwwq.leetcode.daily._20220727;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author 沽酒
 * @since 2022/07/27
 */
public class Solution {
    public String fractionAddition(String exp) {
        final int n = exp.length();
        int[] nums = new int[]{0, 1, 0, 0};
        boolean positive = true;
        int idx = 2;
        for (int i = 0; i < n; i++) {
            final char c = exp.charAt(i);
            if (c == '+' || c == '-') {
                positive = c != '-';
                idx = 2;
                nums = addition(nums);
            } else if (c == '/') {
                idx = 3;
                if (!positive) {
                    positive = true;
                    nums[2] = -nums[2];
                }
            } else {
                nums[idx] = nums[idx] * 10 + c - '0';
            }
        }
        final int[] addition = addition(nums);
        return addition[0] + "/" + addition[1];
    }

    private int[] addition(int[] nums) {
        int up = nums[0] * nums[3] + nums[2] * nums[1];
        int down = nums[1] * nums[3];
        int t;
        boolean positive = up > 0;
        up = Math.abs(up);
        while ((t = gcd(up, down)) > 1) {
            up /= t;
            down /= t;
        }
        return new int[]{positive ? up : -up, up == 0 ? 1 : down, 0, 0};
    }

    private int gcd(int a, int b) {
        return a > b ? _gcd(a, b) : _gcd(b, a);
    }

    public int _gcd(int a, int b) {
        return b == 0 ? a : _gcd(b, a % b);
    }

    public static void main(String[] args) {
        new Solution().fractionAddition("1/3-5/4+3/10");
    }
}