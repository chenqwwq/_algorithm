package top.chenqwwq.leetcode.archive.$20200418.by_topics.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 496. Next Greater Element I
 * Easy
 * <p>
 * You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. Find all the next greater numbers for nums1's elements in the corresponding places of nums2.
 * <p>
 * The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist, output -1 for this number.
 * <p>
 * Example 1:
 * Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * Output: [-1,3,-1]
 * Explanation:
 * For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
 * For number 1 in the first array, the next greater number for it in the second array is 3.
 * For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
 * Example 2:
 * Input: nums1 = [2,4], nums2 = [1,2,3,4].
 * Output: [3,-1]
 * Explanation:
 * For number 2 in the first array, the next greater number for it in the second array is 3.
 * For number 4 in the first array, there is no next greater number for it in the second array, so output -1.
 * Note:
 * All elements in nums1 and nums2 are unique.
 * The length of both nums1 and nums2 would not exceed 1000.
 * <p>
 * SB题目还没有答案的讲解容易懂
 *
 * @author chen
 * @date 2019/10/23 上午8:38
 */
public class $496_NextGreaterElementI {
    class Solution {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            // Result
            int[] res = new int[nums1.length];

            // 辅助数据结构
            Stack<Integer> monotonicStack = new Stack<>();
            Map<Integer, Integer> map = new HashMap<>(nums2.length);

            // 遍历构造,单调栈
            for (int i = nums2.length - 1; i >= 0; i++) {
                // 弹出所有比他大的数字
                while (!monotonicStack.isEmpty() && monotonicStack.peek() < nums2[i]) {
                    monotonicStack.pop();
                }

                // 栈顶的就是元素右边大于他的数字
                map.put(nums2[i], monotonicStack.isEmpty() ? -1 : monotonicStack.peek());
                // 推入栈
                monotonicStack.push(nums2[i]);
            }

            // 遍历获取每个元素的下一个大值
            for (int i = 0; i < nums1.length; i++) {
                res[i] = map.get(nums1[i]);
            }

            return res;
        }
    }
}
