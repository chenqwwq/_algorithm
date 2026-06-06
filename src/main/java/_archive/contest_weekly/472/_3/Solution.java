package top.chenqwwq.leetcode.contest.weekly._472._3;

import java.util.Objects;

/**
 * @author chenqwwq
 * @date 2025/10/20
 **/
public class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int[] hash = new int[26];
        for (char c : s.toCharArray()) {
            hash[c - 'a']++;
        }

        return dfs(new StringBuilder(), target, 0, hash, false);
    }


    private String dfs(StringBuilder s, String t, int pos, int[] hash, boolean isOk) {
        if (pos >= t.length()) {
            return isOk ? s.toString() : "";
        }

        for (int i = isOk ? 0 : (t.charAt(pos) - 'a'); i < 26; i++) {
            if (hash[i] <= 0) continue;
            s.append((char) (i + 'a'));
            hash[i]--;
            String res = dfs(s, t, pos + 1, hash, isOk || i > t.charAt(pos) - 'a');
            if (!Objects.equals(res, "")) {
                return res;
            }
            s.deleteCharAt(s.length() - 1);
            hash[i]++;
        }
        return "";
    }

    public static void main(String[] args) {
        new Solution().lexGreaterPermutation("ab", "ab");
    }
}