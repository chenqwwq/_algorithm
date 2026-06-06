package top.chenqwwq.leetcode.contest.weekly._503._3;

/**
 * @author chenqwwq
 * @date 2026/5/24
 **/
public class Solution {
    public static void main(String[] args) {
        new Solution().minOperations(new int[]{0, 2, 1});
    }

    public int minOperations(int[] nums) {
        final int n = nums.length;
        int idx = 0;
        for (; idx < n; idx++) {
            if (nums[idx] == 0) break;
        }

        // 左右
        int c1 = idx, c2 = (idx + 1) % n;
        while (c2 != idx) {
            if (nums[c1] + 1 == nums[c2]) {
                c2 = (c2 + 1) % n;
                c1 = (c1 + 1) % n;
            } else {
                break;
            }
        }

        if (c2 == idx) return idx;
        int c3 = idx, c4 = (idx - 1) % n;
        while (c4 != idx) {
            if (nums[c3] + 1 == nums[c4]) {
                c4 = (c4 - 1 + n) % n;
                c3 = (c3 - 1 + n) % n;
            } else {
                break;
            }
        }

        if (c4 == idx) return n - idx;
        return -1;
    }

}