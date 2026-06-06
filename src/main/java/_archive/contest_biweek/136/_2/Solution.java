package top.chenqwwq.leetcode.contest.biweek._136._2;

/**
 * @author chenqwwq
 * @date 2024/8/10
 **/
public class Solution {
    public int minFlips(int[][] grid) {
        return -1;
    }

    public int handle(int[] gs) {
        // 01,10,00,11 需要翻转的数量
        int a = 0, b = 0, c = 0, d = 0;
        boolean cur0 = true;
        for (int i = 0; i < gs.length; i++) {
            if(cur0 && gs[i] == 1) a++;
            if(!cur0 && gs[i] ==0) b++;
        }
        return -1;
    }
}