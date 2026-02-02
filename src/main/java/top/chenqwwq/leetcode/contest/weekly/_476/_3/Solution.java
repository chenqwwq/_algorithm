package top.chenqwwq.leetcode.contest.weekly._476._3;

import java.util.Arrays;

/**
 * @author chenqwwq
 * @date 2025/11/16
 **/
public class Solution {
    public long countDistinct(long n) {
        // 枚举小于 n 的所有不包含 0的数字
        if (n <= 1) return n;
        // 数位长度
        final char[] nums = String.valueOf(n).toCharArray();
        final int m = nums.length;
        long[][][] memo = new long[m][2][2];
        for (long[][] rows : memo) {
            for (long[] row : rows) {
                Arrays.fill(row, -1);
            }
        }
        final long dfs = dfs(0, true, true, nums, memo);
        return dfs;
    }

    // tight 表示是否受上限约束,如果前驱小于目标值 ,那么当前就可以取到 9
    public long dfs(int pos, boolean tight, boolean head, char[] nums, long[][][] memo) {
        if (pos == nums.length) {
            return 1;       // 遍历到底了
        }
        final int idx = tight ? 0 : 1;
        final int idx2 = head ? 0 : 1;
        if (memo[pos][idx][idx2] != -1) return memo[pos][idx][idx2];


        int up = tight ? (nums[pos] - '0') : 9;
        long cnt = 0;
        // 前置可以
        for (int i = head && pos != nums.length - 1 ? 0 : 1; i <= up; i++) {
            cnt += dfs(pos + 1, tight && i == up, head && i == 0, nums, memo);
        }
        return memo[pos][idx][idx2] = cnt;
    }


    public static void main(String[] args) {
        final long l = new Solution().countDistinct(200);
        System.out.println(l);
    }
}