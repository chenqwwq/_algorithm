package top.chenqwwq.leetcode.archive.$20200418.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 821. Shortest distance to a character
 *
 * @author chen
 * @date 19-6-11
 */
public class LeetCode821 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new LeetCode821().new Solution().shortestToChar("abaa", 'b')));
    }

    class Solution {
        public int[] shortestToChar(String S, char C) {
            if (S == null || S.length() == 0) {
                return new int[]{};
            }
            final char[] chars = S.toCharArray();
            int[] res = new int[S.length()];
            Arrays.fill(res, Integer.MAX_VALUE);

            // 1. 先确定C所在的位置
            List<Integer> indexs = new ArrayList<>();
            for (int i = 0; i < S.length(); i++) {
                if (C == chars[i]) {
                    indexs.add(i);
                }
            }

            for (int i : indexs) {
                int temp = i, j = 0;
                // 向左遍历
                while (temp >= 0 && res[temp] != 0) {
                    res[temp] = res[temp] == Integer.MAX_VALUE ? j++ : Math.min(j++, res[temp]);
                    temp--;
                }

                // 向右遍历
                j = 1;
                while (++i < S.length() && res[i] != 0) {
                    res[i] = res[i] == Integer.MAX_VALUE ? j++ : Math.min(j++, res[i]);
                }

            }

            return res;
        }
    }
}
