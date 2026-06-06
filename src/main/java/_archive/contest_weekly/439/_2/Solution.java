package top.chenqwwq.leetcode.contest.weekly._439._2;

import top.chenqwwq.leetcode.archive.lcof._2021._41.MedianFinder;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenqwwq
 * @date 2025/3/2
 **/
public class Solution {

    Map<String, Integer> memo = new HashMap<>();


    public static void main(String[] args) {
        final int i = new Solution().longestPalindromicSubsequence("qhpbi", 12);
        System.out.println(i);
//        System.out.println('o' - 'u');
    }

    private static String key(int l, int r, int k) {
        return l + "_" + r + "_" + k;
    }

    public int longestPalindromicSubsequence(String s, int k) {
        if (s.length() == 1) return 1;
        h(s, 0, s.length() - 1, k);
        return memo.get(key(0, s.length() - 1, k));
    }

    public int isConn(String s, int l, int r) {
        char c1 = s.charAt(l), c2 = s.charAt(r);
        if (c1 < c2) return Math.min(c1 + 26 - c2, c2 - c1);
        else return Math.min(c1 - c2, c2 + 26 - c1);
    }


    public int h(String s, int l, int r, int k) {
        if (l > r) return 0;
        if (l == r) return 1;
        final String key = key(l, r, k);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int ret = Math.max(h(s, l + 1, r, k), h(s, l, r - 1, k));
        final int conn = isConn(s, l, r);
        if (k >= conn) {
            ret = Math.max(ret, h(s, l + 1, r - 1, k - conn) + 2);
        }

        memo.put(key, ret);
        return ret;
    }
}