package top.chenqwwq.leetcode.contest.weekly._371._3;

/**
 * @author chenqwwq
 * @date 2023/11/12
 **/
public class Solution {
    private int n;

    public int minOperations(int[] nums1, int[] nums2) {
        n = nums1.length;
        return Math.min(f(nums1, nums2, nums1[n - 1], nums2[n - 1]), f(nums1, nums2, nums2[n - 1], nums1[n - 1])+1);
    }

    int f(int[] n1, int[] n2, int x, int y) {
        int c = 0;
        for (int i = 0; i < n - 1; i++) {
            if (x >= n1[i] && y >= n2[i]) continue;
            if (x >= n2[i] && y >= n1[i]) c++;
            else return -1;
        }
        return c;
    }
}