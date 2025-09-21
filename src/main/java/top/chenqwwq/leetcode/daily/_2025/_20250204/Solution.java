package top.chenqwwq.leetcode.daily._2025._20250204;

/**
 * @author chenqwwq
 * @date 2025/2/4
 **/
public class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        final int n = nums.length, m = n >> 1;
        int[] even = new int[m], odd = new int[m];
        for (int i = 0, x = 0, y = 0; i < n; i++) {
            if ((nums[i] & 1) == 1) odd[x++] = nums[i];
            else even[y++] = nums[i];
        }
        int[] ans = new int[n];
        for (int i = 0, x = 0, y = 0; i < n;) {
            ans[i++] = even[x++];
            ans[i++] = odd[y++];
        }
        return ans;
    }
}