package top.chenqwwq.leetcode.contest.weekly._236._3;

/**
 * @author chen
 * @date 2021/4/11
 **/
public class Solution {
    public int minSideJumps(int[] obstacles) {
        // 数组太长，dp应该会超时
        int[] curr = new int[]{1, 0, 1};
        for (int i = 1; i < obstacles.length; i++) {

            // 没有石头阻断
            if (obstacles[i] == 0) {
                int a0 = min(curr[0], curr[1] + 1, curr[2] + 1);
                int a1 = min(curr[1], curr[0] + 1, curr[2] + 1);
                int a2 = min(curr[2], curr[0] + 1, curr[1] + 1);
                curr[0] = a0;
                curr[1] = a1;
                curr[2] = a2;
            } else if (obstacles[i] == 1) {
                int a1 = min(curr[1], curr[2] + 1);
                int a2 = min(curr[2], curr[1] + 1);
                curr[0] = Integer.MAX_VALUE - 1;
                curr[1] = a1;
                curr[2] = a2;
            } else if (obstacles[i] == 2) {
                int a0 = min(curr[0], curr[2] + 1);
                int a2 = min(curr[2], curr[0] + 1);
                curr[0] = a0;
                curr[1] = Integer.MAX_VALUE - 1;
                curr[2] = a2;
            } else {
                int a0 = min(curr[0], curr[1] + 1);
                int a1 = min(curr[1], curr[0] + 1);
                curr[0] = a0;
                curr[1] = a1;
                curr[2] = Integer.MAX_VALUE - 1;
            }
        }

        return min(curr[0], curr[1], curr[2]);
    }

    public static int min(int a, int b) {
        return Math.min(a, b);
    }

    public static int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}
