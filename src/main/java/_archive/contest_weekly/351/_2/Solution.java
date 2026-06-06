package top.chenqwwq.leetcode.contest.weekly._351._2;

/**
 * @author 沽酒
 * @since 2023/06/25
 */
public class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        for (int i = 1; i <= 60; i++) {
            long max = (long)num1 - (long) num2 * i;
            if(max < 0) continue;
            final int min = get(max);    // 获取1的数量
            if(i >= min && i <= max) return i;
        }
        return -1;
    }

    private int get(long num) {
        int cnt = 0;
        while (num != 0) {
            cnt++;
            num &= (num - 1);
        }
        return cnt;
    }
}