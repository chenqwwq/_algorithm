package top.chenqwwq.leetcode.archive.$20200418.common;

/**
 * 806. Number of Lines To Write String
 *
 * @author chen
 * @date 19-6-16
 */
public class Leetcode806 {
    public static void main(String[] args) {
        System.out.println(new Leetcode806().new Solution().numberOfLines(new int[]{4, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10}, "bbbcccdddaaa"));
    }

    class Solution {
        public int[] numberOfLines(int[] widths, String S) {
            // 每行最大长度为100
            int lines = 1;

            // 1. 遍历S
            int currLen = 0;
            for (Character c : S.toCharArray()) {
                currLen = currLen + widths[c - 'a'];
                if (currLen > 100) {
                    currLen = widths[c - 'a'];
                    lines++;
                }
            }

            return new int[]{lines, currLen};
        }
    }
}
