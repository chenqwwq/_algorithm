package top.chenqwwq.leetcode.contest.weekly._396._1;

/**
 * @author chenqwwq
 * @date 2024/5/5
 **/
public class Solution {
    public boolean isValid(String word) {
        final int n = word.length();
        if (n < 3) return false;
        boolean a = false, b = false;
        for (int i = 0; i < n; i++) {
            final char c = word.charAt(i);
            if (c == '@' || c == '#' || c == '$') return false;
            if (Character.isAlphabetic(c)) {
                if (c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'I' || c == 'i' || c == 'o' || c == 'O' || c == 'u' || c == 'U') {
                    a = true;
                } else {
                    b = true;
                }
            }
        }
        return a && b;
    }
}