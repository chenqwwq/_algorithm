package top.chenqwwq.leetcode.archive.$20200418.common;

/**
 * 344. Reverse String
 *
 * @author chen
 * @date 19-6-12
 */
public class LeetCode344 {
    class Solution {
        public void reverseString(char[] s) {
            int left = 0, right = s.length - 1;

            while (left < right) {
                s[left] ^= s[right];
                s[right] ^= s[left];
                s[left] ^= s[right];

                left++;
                right--;
            }
        }
    }
}
