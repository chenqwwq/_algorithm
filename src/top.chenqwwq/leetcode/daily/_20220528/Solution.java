package top.chenqwwq.leetcode.daily._20220528;

import java.util.Stack;

/**
 * @author chenqwwq
 * @date 2022/5/28
 **/
public class Solution {
    public String removeOuterParentheses(String s) {
        int score = 0;
        StringBuilder ans = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ')') {
                score--;
            }
            if (score > 0) {
                ans.append(c);
            }
            if (c == '(') {
                score++;
            }
        }
        return ans.toString();
    }
}