package top.chenqwwq.leetcode.daily._2025._20250116;

/**
 * @author chenqwwq
 * @date 2025/1/18
 **/
public class Solution {

    final int INF = 0x3f3f3f3f;

    public int minimumSubarrayLength(int[] nums, int k) {
        final int n = nums.length;
        int cur = 0;    // 当前值
        int[] hash = new int[32];       // 记录每一位的1的个数

        int l = 0, r = 0;
        int ans = INF;
        while (r < n) {
            cur |= nums[r];
            h(hash, nums[r++], true);
            while (cur >= k && l < r) {
                ans = Math.min(ans, r - l);
                cur -= h(hash, nums[l++], false);
            }
        }
        return ans == INF ? -1 : ans;
    }

    public int h(int[] hash, int num, boolean add) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if ((num & (1 << i)) != 0) {
                if (add) hash[i]++;
                else hash[i]--;
                if (hash[i] == 0) ans |= 1 << i;
            }
        }
        return ans;
    }
}