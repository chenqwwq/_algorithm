package top.chenqwwq.leetcode.contest.cnunionpay2022._2;

/**
 * @author chenqwwq
 * @date 2022/9/19
 **/
public class Solution {
    int[] nums;

    public int[] explorationSupply(int[] station, int[] pos) {
        final int n = pos.length, m = station.length;
        this.nums = station;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int x = find(pos[i]);
            if (x < m && Math.abs(station[x + 1] - pos[i]) < Math.abs(station[x] - pos[i])) ans[i] = x + 1;
            else ans[i] = x;
        }
        return ans;
    }

    int find(int x) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (nums[mid] >= x) r = mid - 1;
            else l = mid;
        }
        return l;
    }

    public static void main(String[] args) {
        new Solution().explorationSupply(new int[]{2, 7, 8, 10}, new int[]{4, 9});
    }
}