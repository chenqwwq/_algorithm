package top.chenqwwq.leetcode.archive.$20200418.common;

import java.util.Stack;

/**
 * 682. Baseball Game
 *
 * @author bingxin.chen
 * @date 2019/4/4 09:50
 */
public class LeetCode682 {
    class Solution {
        public int calPoints(String[] ops) {
            if (ops == null || ops.length == 0) {
                return 0;
            }
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < ops.length; i++) {
                switch (ops[i]) {
                    case "+":
                        final Integer pop = stack.pop();
                        int temp = stack.peek() + pop;
                        stack.push(pop);
                        stack.push(temp);
                        break;
                    case "C":
                        stack.pop();
                        break;
                    case "D":
                        stack.push(2 * stack.peek());
                        break;
                    default:
                        stack.push(Integer.valueOf(ops[i]));
                        break;
                }
            }
            int sum = 0;
            while (!stack.isEmpty()) {
                sum += stack.pop();
            }

            return sum;
        }
    }
}
