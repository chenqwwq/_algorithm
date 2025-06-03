package top.chenqwwq.leetcode.contest.weekly._437._3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author chenqwwq
 * @date 2025/2/16
 **/
public class Solution {
    public boolean maxSubstringLength(String s, int k) {
        final int n = s.length();
        final char[] cs = s.toCharArray();
        int[][] hash = new int[26][2];
        for (int i = 0; i < 26; i++) {
            hash[i][0] = Integer.MAX_VALUE;
            hash[i][1] = Integer.MIN_VALUE;
        }
        for (int i = 0; i < n; i++) {
            hash[cs[i] - 'a'][0] = Math.min(hash[cs[i] - 'a'][0], i);
            hash[cs[i] - 'a'][1] = Math.max(hash[cs[i] - 'a'][1], i);
        }

        // 按照右端排序
        Arrays.sort(hash, Comparator.comparingInt(a -> a[0]));

        List<int[]> ans = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (hash[i][0] == Integer.MAX_VALUE) continue;
            int l = hash[i][0], r = hash[i][1];
            if (ans.isEmpty() || ans.get(ans.size() - 1)[1] < l) {
                ans.add(new int[]{l, r});
            } else {
                ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], r);
            }
        }

        return ans.size() >= k;
    }

    public static void main(String[] args) {
        new Solution().maxSubstringLength("abcdbaefab", 2);
    }
}