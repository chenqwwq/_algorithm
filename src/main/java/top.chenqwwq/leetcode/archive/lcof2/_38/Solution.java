package top.chenqwwq.leetcode.archive.lcof2._38;

/**
 * @author chenbingxin
 * @date 2022/1/1
 **/
public class Solution {
//    public int[] dailyTemperatures(int[] temperatures) {
//        final int n = temperatures.length;
//        final int[] ans = new int[n];
//        final Stack<Integer> stack = new Stack<>();
//        for (int i = 1; i < n; i++) {
//            if (stack.isEmpty() || temperatures[i] <= temperatures[stack.peek()]) {
//                stack.push(i);
//            } else {
//                while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
//                    final Integer idx = stack.pop();
//                    ans[idx] = i - idx;
//                }
//                stack.push(i);
//            }
//        }
//        return ans;
//    }

    public int[] dailyTemperatures(int[] temperatures) {
        final int n = temperatures.length;
        final int[] ans = new int[n], stack = new int[n];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (idx == 0 || temperatures[stack[idx - 1]] >= temperatures[i]) {
                stack[idx++] = i;
            } else {
                while (idx != 0 && temperatures[stack[idx - 1]] < temperatures[i]) {
                    ans[stack[--idx]] = i - stack[idx];
                }
                stack[idx++] = i;
            }
        }
        return ans;
    }
}
