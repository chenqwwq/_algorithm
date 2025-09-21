package top.chenqwwq.leetcode.contest.weekly._417._1;

/**
 * @author chenqwwq
 * @date 2024/9/29
 **/
public class Solution {
    static String s = "a";

    static {
        while (s.length() < 500) {
            StringBuilder ap = new StringBuilder();
            for (char c : s.toCharArray()) {
                if (c == 'z') ap.append('a');
                else ap.append((char) (c + 1));
            }
            s += ap;
        }
    }

    public char kthCharacter(int k) {
        return s.charAt(k - 1);
    }
}