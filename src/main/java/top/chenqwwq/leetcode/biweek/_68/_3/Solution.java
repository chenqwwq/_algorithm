package top.chenqwwq.leetcode.biweek._68._3;

import java.util.Stack;

/**
 * @author chenbingxin
 * @date 2021/12/26
 **/
public class Solution {
    public boolean canBeValid(String s, String locked) {
        final int n = s.length();
        if ((n & 1) == 1) {
            return false;
        }
        final Stack<Integer> lb = new Stack<>(), star = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (locked.charAt(i) == '0') {
                star.push(i);
            } else if (s.charAt(i) == '(') {
                lb.push(i);
            } else {
                if (!lb.isEmpty()) {
                    lb.pop();
                } else if (!star.isEmpty()) {
                    star.pop();
                } else {
                    return false;
                }
            }
        }
        while (!lb.isEmpty() && !star.isEmpty()) {
            if (lb.pop() > star.pop()) {
                return false;
            }
        }
        return lb.isEmpty() && (star.size() & 1) == 0;
    }
}