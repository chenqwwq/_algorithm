package top.chenqwwq.leetcode.daily._20210505;

/**
 * 740. Delete and Earn
 * Given an array nums of integers, you can perform operations on the array.
 * In each operation, you pick any nums[i] and delete it to earn nums[i] points. After, you must delete every element equal to nums[i] - 1 or nums[i] + 1.
 * You start with 0 points. Return the maximum number of points you can earn by applying such operations.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [3,4,2]
 * Output: 6
 * Explanation: Delete 4 to earn 4 points, consequently 3 is also deleted.
 * Then, delete 2 to earn 2 points.
 * 6 total points are earned.
 * Example 2:
 * <p>
 * Input: nums = [2,2,3,3,3,4]
 * Output: 9
 * Explanation: Delete 3 to earn 3 points, deleting both 2's and the 4.
 * Then, delete 3 again to earn 3 points, and 3 again to earn 3 points.
 * 9 total points are earned.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 2 * 104
 * 1 <= nums[i] <= 104
 *
 * @author chen
 * @date 2021/5/5
 **/
public class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] cnt = new int[10001];
        int maxNum = 0;

        for (int i : nums) {
            cnt[i]++;
            maxNum = Math.max(maxNum, i);
        }

//        // dp[i][0] 表示删除当前
//        // dp[i][1] 表示不删除当前
//        int[][] dp = new int[maxNum + 1][2];
//        for (int i = 1; i <= maxNum; i++) {
//            final int max = Math.max(dp[i - 1][0], dp[i - 1][1]);
//            if (cnt[i] == 0) {
//                dp[i][1] = dp[i][0] = max;
//                continue;
//            }
//            // 删除
//            dp[i][0] = dp[i - 1][1] + cnt[i] * i;
//            // 不删除
//            dp[i][1] = max;
//        }
//
//        return Math.max(dp[maxNum][0], dp[maxNum][1]);

        // 能删就删
        int[] dp = new int[maxNum + 1];
        dp[1] = cnt[1];
        for (int i = 2; i <= maxNum; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + cnt[i] * i);
        }
        return dp[maxNum];
    }
}
