package top.chenqwwq.leetcode.daily._20220717;

/**
 * @author chenqwwq
 * @date 2022/7/17
 **/
public class Solution {
    public int arrayNesting(int[] nums) {
        final int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int j = i, cnt = 0;
            while (nums[j] != -1) {
                cnt++;
                int a = j;
                j = nums[j];
                nums[a] = -1;
            }
            ans = Math.max(ans, cnt);
        }
        return ans;
    }
}