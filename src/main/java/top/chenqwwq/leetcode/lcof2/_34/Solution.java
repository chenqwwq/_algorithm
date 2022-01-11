package top.chenqwwq.leetcode.lcof2._34;

import java.sql.PreparedStatement;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author chenbingxin
 * @date 2021/12/30
 **/
public class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        final int n = words.length;
        if(n < 2){
            return true;
        }
        final int[] idx = new int[26];
        for (int i = 0; i < 26; i++) {
            idx[order.charAt(i) - 'a'] = i;
        }

        final Comparator<String> c = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                final int n = o1.length(), m = o2.length();
                final int max = Math.min(n, m);
                for (int i = 0; i < max; i++) {
                    final char c1 = o1.charAt(i),c2 = o2.charAt(i);
                    if(c1 != c2){
                        return Integer.compare(idx[c1 - 'a'],idx[c2 - 'a']);
                    }
                }
                return Integer.compare(n,m);
            }
        };

        for (int i = 0; i < n - 1; i++) {
            if(c.compare(words[i],words[i+1]) > 0){
                return false;
            }
        }

        return true;
    }
}
