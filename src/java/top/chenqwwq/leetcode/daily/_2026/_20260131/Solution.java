package top.chenqwwq.leetcode.daily._2026._20260131;

/**
 * @author chenqwwq
 * @date 2026/1/31
 **/
public class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        final int n = letters.length;
        if (letters[n - 1] <= target) {
            return letters[0];
        }

        int l = 0, r = n - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (letters[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return letters[l];
    }
}