package top.chenqwwq.leetcode.daily._2024._20240719;

/**
 * @author chenqwwq
 * @date 2024/7/22
 **/
public class Solution {
    public int minimumLevels(int[] possible) {
        final int n = possible.length;
        int a = 0, b = 0; // a 表示简单模式,b 表示困难模式
        for (int num : possible) {
            if (num == 1) a++;
            else b++;
        }

        int x = 0, y = 0;
        // bob 必须完成一个关卡,所以最多做到 n-2
        for (int i = 0; i < n - 1; i++) {
            if (possible[i] == 1) {
                a--;x++;
            } else {
                b--;y++;
            }
            if (a - b < x - y) return i + 1;
        }
        return -1;
    }
}