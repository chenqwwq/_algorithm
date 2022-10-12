package top.chenqwwq.leetcode.daily._20221009;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author chenqwwq
 * @date 2022/10/9
 **/
public class Solution {
    public int scoreOfParentheses(String s) {
        Deque<Integer> d = new ArrayDeque<>();
        d.addLast(0);
        for (char c : s.toCharArray()) {
            if (c == '(') d.addLast(0);
            else {
                int cur = d.pollLast();
                d.addLast(d.pollLast() + Math.max(cur * 2 , 1));
            }
        }
        return d.peekLast();
    }
}