package top.chenqwwq.leetcode.daily._2022._20220831;

import java.util.Stack;

/**
 * @author chenqwwq
 * @date 2022/8/31
 **/
public class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        final int n = popped.length;
        Stack<Integer> stack = new Stack<>();
        int i = 0, j = 0;
        while (j < n){
            while ((stack.isEmpty() || stack.peek() != popped[j]) && i < n){
                stack.push(pushed[i++]);
            }
            if(stack.pop() != popped[j++]){
                return false;
            }
        }
        return j == n;
    }
}