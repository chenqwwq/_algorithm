package top.chenqwwq.leetcode.contest.biweek._88._1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenqwwq
 * @date 2022/10/7
 **/
public class Solution {
    public boolean equalFrequency(String word) {
        final int n = word.length();
        int[] hash = new int[26];       // 统计每个字母的个数
        for (char c : word.toCharArray()) hash[c - 'a']++;
        int[] cnt = new int[101];
        for (int c : hash) cnt[c]++;
        // 只能存在两个个数
        int k1 = -1, c1 = -1, k2 = -1, c2 = -1;
        for (int i = 1; i <= 100; i++) {
            if (cnt[i] == 0) continue;
            if (k1 == -1) {
                k1 = i;
                c1 = cnt[i];
            } else if (k2 == -1) {
                k2 = i;
                c2 = cnt[i];
            } else return false;
        }
        // 你妈的，这个边界条件是真的多
        if (k2 == -1 && (k1 == 1 || c1 == 1)) return true;
        if (c1 == 1 && k1 == 1) return true;
        return c2 == 1 && k1 == k2 - 1;
    }

    public static void main(String[] args) {
        new Solution().equalFrequency("aazz");
    }
}