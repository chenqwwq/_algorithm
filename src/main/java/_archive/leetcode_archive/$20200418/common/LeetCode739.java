package top.chenqwwq.leetcode.archive.$20200418.common;

import java.util.Stack;

/**
 * 739. Daily Temperatures
 *
 * @author chen
 * @date 19-7-2 上午7:58
 */
public class LeetCode739 {
    class Solution {

        public int[] dailyTemperatures(int[] T) {
            // Hash超时,改用栈
            Stack<Integer> stack = new Stack<>();

            int[] res = new int[T.length];
            // 维护一个栈顶
            for (int i = T.length - 1; i >= 0; --i) {
                // 入栈检查,如果栈顶元素小于当前元素,则弹出
                while (!stack.isEmpty() && T[stack.peek()] < T[i]) {
                    stack.pop();
                }
                // 剩下的要不栈为空,或者当前元素比栈顶元素小
                res[i] = stack.isEmpty() ? 0 : stack.peek() - i;
                stack.push(i);
            }

            return res;

        }
    }
}
