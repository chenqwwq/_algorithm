package top.chenqwwq.leetcode.daily._2022._20220527;

import java.util.Objects;

/**
 * @author chenqwwq
 * @date 2022/5/27
 **/
public class Solution {
    public int findClosest(String[] words, String word1, String word2) {
        int a = -1, b = -1;
        int dis = Integer.MAX_VALUE;
        int n = words.length;
        for (int i = 0; i < n; i++) {
            if (Objects.equals(words[i], word1)) {
                a = i;
                if (b != -1) {
                    dis = Math.min(dis, Math.abs(a - b));
                }
            } else if (Objects.equals(words[i], word2)) {
                b = i;
                if (a != -1) {
                    dis = Math.min(dis, Math.abs(a - b));
                }
            }
        }
        return dis == Integer.MAX_VALUE ? n : dis;
    }
}