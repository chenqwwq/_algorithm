package top.chenqwwq.leetcode.daily._2023._20230615;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 沽酒
 * @since 2023/06/15
 */
public class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        final int n = s.length();
        boolean[][] hash = new boolean[n][26];

        hash[0][s.charAt(0) - 'a'] = true;
        for (int i = 1; i < n; i++) {
            System.arraycopy(hash[i - 1], 0, hash[i], 0, 26);
            hash[i][s.charAt(i) - 'a'] = !hash[i][s.charAt(i) - 'a'];
        }


        List<Boolean> ans = new ArrayList<>(queries.length);
        for (int[] query : queries) {
            int l = query[0], r = query[1], c = query[2];
            int k = 0;
            for (int i = 0; i < 26; i++) {
                k += ((l > 0 ? hash[r][i] ^ hash[l - 1][i] : hash[r][i]) ? 1 : 0);
            }
            ans.add(k >> 1 <= c);
        }
        return ans;
    }
}