package top.chenqwwq.leetcode.daily._20210503;

import java.util.Map;

/**
 * 7. Reverse Integer
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 * <p>
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: x = 123
 * Output: 321
 * Example 2:
 * <p>
 * Input: x = -123
 * Output: -321
 * Example 3:
 * <p>
 * Input: x = 120
 * Output: 21
 * Example 4:
 * <p>
 * Input: x = 0
 * Output: 0
 * <p>
 * <p>
 * Constraints:
 * <p>
 * -231 <= x <= 231 - 1
 *
 * @author chen
 * @date 2021/5/3
 **/
public class Solution {
    public int reverse(int x) {
        long r = 0;
        while(x != 0) {
            r = x % 10 + r * 10;
            x = x / 10;
        }
        return (int) r == r ? (int)r : 0;
    }
}