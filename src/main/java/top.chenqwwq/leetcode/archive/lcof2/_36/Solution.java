package top.chenqwwq.leetcode.archive.lcof2._36;

import java.util.Stack;

/**
 * @author chenbingxin
 * @date 2022/1/1
 **/
public class Solution {
    public int evalRPN(String[] tokens) {
        final int n = tokens.length;
        final Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (isCom(token)) {
                stack.push(calculate(stack.pop(), stack.pop(), token));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    public int calculate(int n1, int n2, String cal) {
        switch (cal) {
            case "*":
                return n1 * n2;
            case "-":
                return n2 - n1;
            case "+":
                return n1 + n2;
            case "/":
                return n2 / n1;
        }
        throw new IllegalArgumentException();
    }

    public boolean isCom(String s) {
        return "+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s);
    }
}