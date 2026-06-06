package top.chenqwwq.leetcode.daily._20231124;

/**
 * @author chenqwwq
 * @date 2023/11/21
 **/
public class Solution {
    public int minDeletion(int[] nums) {
        final int n = nums.length;
        if (n <= 1) return 0;
        int cnt = 0;
        for (int i = 0; i < n; ) {
            int j = i + 1;
            while (j < n && nums[i] == nums[j]) {
                cnt++;
                j++;
            }
            i = j+1;
        }
        return (n - cnt) % 2 == 0 ? cnt : cnt+1;
    }

    public static void main(String[] args) {
        new Solution().minDeletion(new int[]{1,1,2,2,3,3});
    }
}