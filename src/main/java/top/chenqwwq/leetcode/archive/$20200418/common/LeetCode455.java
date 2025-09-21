package top.chenqwwq.leetcode.archive.$20200418.common;

import java.util.Arrays;

/**
 * @author CheNbXxx
 * @description
 * @email chenbxxx@gmail.con
 * @date 2019/1/31 10:37
 */
public class LeetCode455 {
    static class Solution {
        public int findContentChildren(int[] g, int[] s) {
            // 对孩子的胃口和饼干大小做排序
            Arrays.sort(g);
            Arrays.sort(s);
            int i = 0, j = 0;
            for (; i < g.length && j < s.length; j++) {
                // 先满足胃口最小的孩子，用小饼干开始试验
                if (g[i] <= s[j]) {
                    i++;
                }
            }
            return i;
        }
    }
}
