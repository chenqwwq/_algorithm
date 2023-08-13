package top.chenqwwq.leetcode.daily._2023._20230813;

/**
 * @author chenqwwq
 * @date 2023/8/13
 **/
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums1, 0, nums1, n, m);
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (nums1[n+i] <= nums2[j]) nums1[k++] = nums1[n + i++];
            else nums1[k++] = nums2[j++];
        }
        while (i < m) nums1[k++] = nums1[n + i++];
        while (j < n) nums1[k++] = nums2[j++];
    }

}