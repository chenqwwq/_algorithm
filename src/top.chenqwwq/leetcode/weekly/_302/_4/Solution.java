package top.chenqwwq.leetcode.weekly._302._4;

import java.util.Arrays;

/**
 * @author chenqwwq
 * @date 2022/7/17
 **/
public class Solution {
    public int minOperations(int[] nums, int[] numsDivide) {
        final int n = nums.length;
        Arrays.sort(nums);
        int i = 0;
        outer:
        for (; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int num = nums[i];
            for (int div : numsDivide) {
                if (div % num != 0) {
                    continue outer;
                }
            }
            break;
        }
        return i == n ? -1 : i;
    }
}
