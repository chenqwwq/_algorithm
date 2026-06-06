package top.chenqwwq.leetcode.daily._2024._20241211;

/**
 * @author chenqwwq
 * @date 2024/12/11
 **/
public class Solution {
    public int semiOrderedPermutation(int[] nums) {
        final int n = nums.length;
        int i1 = -1, in = -1;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) i1 = i;
            else if (nums[i] == n) in = i;
        }
        if (i1 == -1 || in == -1) return -1;

        return i1 + n - in - (i1 < in ? 1 : 2);
    }

}