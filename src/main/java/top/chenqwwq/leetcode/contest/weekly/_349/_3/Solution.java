package top.chenqwwq.leetcode.contest.weekly._349._3;

/**
 * @author chenqwwq
 * @date 2023/6/11
 **/
public class Solution {
//    public long minCost(int[] nums, int x) {
//        final int n = nums.length;
//        long ans = 0;
//        int max = 0;
//        for (int i = 0; i < n; i++) {
//            long minCost = nums[i];
//            for (int j = 0; j < n; j++) {
//                if (i == j || nums[j] >= nums[i]) continue;
//
//                final int cc = i > j ? i - j : j + n - i;
//                if (cnt[cc])
//                    long cost = (long) cc * x + nums[j];
//                minCost = Math.min(cost, minCost);
//            }
//            ans += minCost;
//        }
//        return ans;
//    }
//
//    public static void main(String[] args) {
//        new Solution().minCost(new int[]{15, 150, 56, 69, 214, 203}, 42);
//        // 15 56 15 15 15 15
//        // 42 *3 + 15 * 4 + 56 * 2
//        // 126 + 60 + 112
//        // 298
//    }
}