package top.chenqwwq.leetcode.archive.$20200418.common;

import java.util.Stack;

/**
 * 1047. remove all adjacent duplicates in string
 *
 * @author chen
 * @date 19-6-14
 */
public class LeetCode1047 {
    class Solution {
        public String removeDuplicates(String S) {
            if (S == null || S.length() == 0) {
                return "";
            }

            Stack<Character> stack = new Stack<>();
            for (char c : S.toCharArray()) {
                if (!stack.isEmpty() && stack.peek() == c) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }

            StringBuilder string = new StringBuilder();
            while (!stack.isEmpty()) {
                string.append(stack.pop());
            }
            return string.reverse().toString();
        }
    }
}
