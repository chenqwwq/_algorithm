package top.chenqwwq.leetcode.archive.$20200418.common;

import java.util.Stack;

/**
 * 32. Longest Valid Parentheses
 * Hard
 * <p>
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 * <p>
 * Example 1:
 * <p>
 * Input: "(()"* Output: 2
 * Explanation: The longest valid parentheses substring is "()"
 * Example 2:
 * <p>
 * Input: ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()"
 * <p>
 * 第一眼看到以为是堆栈,但是提示说是DP.
 * 完全想不到公式,用暴力写一遍试试
 * <p>
 * 刚动手写,突然发现说的是子串
 *
 * @author bingxin.chen
 * @date 2019/7/12 13:20
 */
public class LeetCode32 {


    public static void main(String[] args) {
        System.out.println(new LeetCode32().new Solution().longestValidParentheses("(()"));
    }

    class Solution {
        public int longestValidParentheses(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }

            final char[] chars = s.toCharArray();

            // push index
            Stack<Integer> brackets = new Stack<>();

            // result
            int res = 0;

            // traversing
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '(' || brackets.isEmpty()) {
                    brackets.push(i);
                    continue;
                }

                // chars[i] == ')' && brackets.isEmpty() == true
                if (chars[brackets.pop()] == '(') {
                    // 不为空使用i - 前一个的洗标
                    if (!brackets.isEmpty()) {
                        res = Math.max(res, i - brackets.peek());
                    } else {
                        // 为空表示0～i为止都是有效括号
                        res = Math.max(res, i + 1);
                    }
                } else {
                    // 连续))情况,入栈
                    brackets.push(i);
                }
            }

            return res;
        }
    }
}
