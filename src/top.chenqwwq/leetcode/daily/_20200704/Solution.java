package top.chenqwwq.leetcode.daily._20200704;

import java.util.Stack;

/**
 * 32. 最长有效括号
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * @author chen
 * @date 2020/7/4 下午11:19
 */
public class Solution {
    public int longestValidParentheses(String s) {
        // 异常判断
        if (s == null || s.length() == 0) {
            return 0;
        }

        // 栈的实现
        Stack<Integer> stack = new Stack<>();
        final char[] chars = s.toCharArray();
        int i = 0;

        // 添加第一个(
        while (i < chars.length && chars[i] != '(') {
            i++;
        }
        stack.push(i++);
        int last = -1;

        int res = 0;
        while (i < s.length()) {
            if ('(' == chars[i]) {
                stack.push(i);
            } else {
                if (!stack.isEmpty()) {
                    // (所在的下标
                    final Integer pop = stack.pop();
                    if (chars[pop] == '(') {
                        if (stack.isEmpty()) {
                            res = i + 2;
                        } else {
                            res = Math.max(res, i - stack.peek());

                        }
                    }
                }
            }
            i++;
        }
        return res;
    }
}
