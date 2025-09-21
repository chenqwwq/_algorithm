package top.chenqwwq.leetcode.contest.biweek._88._3;

/**
 * @author chenqwwq
 * @date 2022/10/7
 **/
public class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        final int n = nums1.length,m = nums2.length;
        if((n & 1) == 0 && (m & 1) == 0) return 0;
        if((m & 1) == 0) return cal(nums2);
        if((n & 1) == 0) return cal(nums1);
        return cal(nums1) ^ cal(nums2);
    }

    public int cal(int[] nums){
        int ans = 0;
        for(int num : nums) ans ^= num;
        return ans;
    }
}
