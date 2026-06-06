package top.chenqwwq.leetcode.contest.weekly._295._3;

/**
 * @author chenqwwq
 * @date 2022/5/29
 **/
public class Solution {
    public int totalSteps(int[] nums) {
        final int n = nums.length;
        // a 表示当前左端点下标
        // b 表示当前左端点需要删除的轮次
        // c 表示当前递减的
        int a = 0, b = 0, c = 0, d = 1;
        int ans = 0;
        for (int i = 1; i < n; i++) {
            // 需要删除的
            if (nums[i] < nums[a]) {
                // 5 4 3 2 1
                // 5 3 1
                // 5 3
                // 5
                // 4 3 2 1
                if (nums[i] < nums[i - 1]) {
                    c++;
                    b = Math.max(b, d);
                } else {
                    d = Math.max(d+1,2);
                    b = Math.max(b, (c + 1) >> 1);
                    c = 1;
                }
            } else {
                ans = Math.max(ans, Math.max(b, Math.max((c + 1) >> 1, d)));
                b = 0;
                c = 0;
                d = 1;
                a = i;
            }
        }
        return Math.max(ans, Math.max(b, Math.max((c + 1) >> 1, d)));
    }

    public static void main(String[] args) {
        new Solution().totalSteps(new int[]{7, 14, 4, 14, 13, 2, 6, 13});
    }
}