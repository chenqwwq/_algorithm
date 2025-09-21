package top.chenqwwq.leetcode.contest.weekly._417._2;

/**
 * @author chenqwwq
 * @date 2024/9/29
 **/
public class Solution {
    char[] cs = {'a', 'e', 'i', 'o', 'u'};

    public int countOfSubstrings(String word, int k) {
        final int n = word.length();
        final int[] hash = new int[26];
        int cnt = 0, ans = 0;
        for (int l = 0, r = 0; r < n; r++) {
            char c = word.charAt(r);
            if (isAeiou(c)) hash[c - 'a']++;
            else cnt++;

            while (cnt > k) {
                char c1 = word.charAt(l);
                if (isAeiou(c1)) hash[c1 - 'a']--;
                else cnt--;
                l++;
            }
            if (cnt == k) {
                int q = l;
                while (check(hash)) {
                    ans++;
                    final char c1 = word.charAt(q++);
                    if (!isAeiou(c1)) break;
                    hash[c1 - 'a']--;
                }
                for (int i = l; i < q; i++) {
                    final char c1 = word.charAt(i);
                    if (isAeiou(c1)) hash[c1 - 'a']++;
                }
            }
        }
        return ans;
    }

    public boolean isAeiou(char c) {
        for (char c1 : cs) {
            if (c == c1) return true;
        }
        return false;
    }

    public boolean check(int[] hash) {
        for (char c : cs) {
            if (hash[c - 'a'] < 1) return false;
        }
        return true;
    }
}