package top.chenqwwq.leetcode.daily._20210428;

import com.sun.webkit.dom.CSSUnknownRuleImpl;

/**
 * 633. Sum of Square Numbers
 * Given a non-negative integer c, decide whether there're two integers a and b such that a2 + b2 = c.
 * <p>
 * Example 1:
 * <p>
 * Input: c = 5
 * Output: true
 * Explanation: 1 * 1 + 2 * 2 = 5
 * Example 2:
 * <p>
 * Input: c = 3
 * Output: false
 * Example 3:
 * <p>
 * Input: c = 4
 * Output: true
 * Example 4:
 * <p>
 * Input: c = 2
 * Output: true
 * Example 5:
 * <p>
 * Input: c = 1
 * Output: true
 * <p>
 * Constraints:
 * <p>
 * 0 <= c <= 231 - 1
 *
 * @author chen
 * @date 2021/4/28
 **/
public class Solution {
    public boolean judgeSquareSum(int c) {
        final double sqrt = Math.sqrt(c);
        int left = 0, right = (int) sqrt;
        // 可以相等
        while (left <= right) {
            final int sum = left * left + right * right;
            if (sum == c) {
                return true;
            } else if (sum < c) {
                left++;
            } else {
                right--;
            }
        }

        return false;
    }
}
