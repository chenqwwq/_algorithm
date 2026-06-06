package top.chenqwwq.leetcode.daily._2022._20220106;

import java.util.Stack;

/**
 * @author chenbingxin
 * @date 2022/1/6
 **/
public class Solution {
    public String simplifyPath(String path) {
        Stack<Character> stack = new Stack<>();
        final int n = path.length();
        int i = 0;
        while (i < n) {
            final char curr = path.charAt(i);
            if (curr == '/') {
                if (stack.isEmpty() || stack.peek() != '/') {
                    stack.push(curr);
                }
                i++;
            } else if (curr == '.') {
                if (i + 1 < n) {
                    final char next = path.charAt(i + 1);
                    if (next == '.') {
                        // 退回上一级
                        if (stack.peek() == '/') {
                            stack.pop();
                        }
                        while (!stack.isEmpty() && stack.peek() != '/') {
                            stack.pop();
                        }
                        i++;
                    } else if (next == '/') {
                        i++;
                    }
                }
                i++;
            } else {
                stack.push(curr);
                while (++i < n && Character.isLetter(path.charAt(i))) {
                    stack.push(path.charAt(i));
                }
            }
        }
        if (!stack.isEmpty() && stack.peek() == '/') {
            stack.pop();
        }

        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) {
            ans.insert(0, stack.pop());
        }
        return ans.length() == 0 ? "/" : ans.toString();
    }
}
