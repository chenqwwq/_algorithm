package top.chenqwwq.leetcode.archive.$20200418.by_topics.stack;

import java.util.Stack;

/**
 * 503. Next Greater Element II
 * Medium
 * <p>
 * Given a circular array (the next element of the last element is the first element of the array), print the Next Greater Number for every element. The Next Greater Number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, output -1 for this number.
 * <p>
 * Example 1:
 * Input: [1,2,1]
 * Output: [2,-1,2]
 * Explanation: The first 1's next greater number is 2;
 * The number 2 can't find next greater number;
 * The second 1's next greater number needs to search circularly, which is also 2.
 * Note: The length of given array won't exceed 10000.
 *
 * @author chen
 * @date 2019/10/24 上午8:31
 */
public class $503_NextGreaterElementII {

    class Solution {
        public int[] nextGreaterElements(int[] nums) {
            // 循环数组的单调栈求法

            int[] res = new int[nums.length];

            // 重新复制一遍数组到原数组后面
            int[] des = new int[nums.length * 2];
            System.arraycopy(nums, 0, des, 0, nums.length);
            System.arraycopy(nums, 0, des, nums.length, nums.length);

            // 求单调数组
            int[] next = new int[nums.length];
            Stack<Integer> monoStack = new Stack<>();

            for (int i = des.length - 1; i >= 0; i--) {
                while (!monoStack.isEmpty() && monoStack.peek() <= des[i]) {
                    monoStack.pop();
                }
                if (i < nums.length) {
                    next[i] = monoStack.isEmpty() ? -1 : monoStack.peek();
                }

                monoStack.push(des[i]);
            }

            return next;
        }
    }
}
