package top.chenqwwq.leetcode.contest.biweek._127._2;

/**
 * @author chenqwwq
 * @date 2024/3/30
 **/
public class Solution {
    public int minimumLevels(int[] possible) {
        final int n = possible.length;
        int a = 0, b = 0, c = 0, d = 0;
        for (int j : possible) {
            if (j == 0) a++;
            else b++;
        }
        for (int i = 0; i < n - 1; i++) {
            if (possible[i] == 0) {
                c++;
                a--;
            } else {
                d++;
                b--;
            }
            if (d - c > b - a) return i + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        new Solution().minimumLevels(new int[]{1, 0, 1, 0});
    }
}