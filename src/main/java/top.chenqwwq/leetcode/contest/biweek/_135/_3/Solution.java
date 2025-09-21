package top.chenqwwq.leetcode.contest.biweek._135._3;

/**
 * @author chenqwwq
 * @date 2024/7/21
 **/
public class Solution {
    public int minChanges(int[] nums, int k) {
        final int n = nums.length;
        // 差分数组
        final int[] f = new int[k+2];
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            // 1 3
            int dif = Math.abs(nums[i] - nums[j]);
            int mx = max(nums[i], nums[j], k - nums[i], k - nums[j]);
            // x >= 0 && x <= diff 都只需要变一次
            // 如果 dif = 0,那 0就不需要变
            f[0]++;f[dif]--;
            // x >= dif + 1 || x <= mx 都需要变一次
            f[dif + 1]++;f[mx]--;
            // 大于 mx 需要变两次
            f[mx+1]+=2;
        }
        int ans = n;
        for(int i = 0,now = 0;i <= k;i++){
            now+=f[i];
            ans += Math.min(ans,now);
        }
        return ans;
    }

    public int max(int... nums) {
        int ans = Integer.MIN_VALUE;
        for (int num : nums) {
            ans = Math.max(ans, num);
        }
        return ans;
    }
}
