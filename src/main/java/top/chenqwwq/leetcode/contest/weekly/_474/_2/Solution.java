package top.chenqwwq.leetcode.contest.weekly._474._2;

/**
 * @author chenqwwq
 * @date 2025/11/2
 **/
public class Solution {
    int MAXN = 100000;

    public long maxProduct(int[] nums) {
        int m1 = -1, m2 = -1, m3 = -1;
        for (int num : nums) {
            num = Math.abs(num);
            if (num > m1) {
                m3 = m2;
                m2 = m1;
                m1 = num;
            } else if (num > m2) {
                m3 = m2;
                m2 = num;
            } else if (num > m3) {
                m3 = num;
            }
        }

        return (long) m1 * m2 * MAXN;

    }
}