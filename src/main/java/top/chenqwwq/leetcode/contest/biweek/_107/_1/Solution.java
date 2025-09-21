package top.chenqwwq.leetcode.contest.biweek._107._1;

/**
 * @author chenqwwq
 * @date 2023/6/24
 **/
public class Solution {
    public int maximumNumberOfStringPairs(String[] words) {
        final int n = words.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (check(words[i], words[j])) ans++;
            }
        }
        return ans;
    }

    private boolean check(String a, String b) {
        return a.charAt(0) == b.charAt(1) && a.charAt(1) == b.charAt(0);
    }
}