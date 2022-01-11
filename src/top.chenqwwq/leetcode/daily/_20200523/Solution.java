package top.chenqwwq.leetcode.daily._20200523;

/**
 * 76. 最小覆盖子串
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。
 *
 * @author chen
 * @date 2020/5/24 上午8:56
 */
public class Solution {
    public String minWindow(String s, String t) {

        if (s == null || s.length() < t.length()) {
            return "";
        }

        /*
         * 滑动窗口
         * 扩展和收缩窗口以满足S中包含全部的t
         * 主要问题就是记录在字符串S中，t的字符如何标记
         * 假定字符串中只存在大写字符
         * 所以采用两个hash数组的的形式判断
         */

        // hash记录所有需要的字符
        int need = 0;
        int[] template = new int[100];
        for (char c : t.toCharArray()) {
            if (template[c - 'A']++ == 0) {
                need++;
            }
        }
        int[] hash = new int[100];
        // 窗口左右边界
        int left = 0, right = 0;
        // 匹配的位数
        int flag = 0;
        // 匹配的开头和长度
        int start = 0, length = Integer.MAX_VALUE;

        while (right < s.length()) {
            // 当前字符
            final char curr = s.charAt(right);
            // 当前字符对应下标
            final int idx = curr - 'A';
            if (template[idx] <= 0) {
                right++;
                continue;
            }
            if (template[idx] == ++hash[idx]) {
                flag++;
            }

            // 这里用while的原因是因为可能在窗口收缩的时候产生更小的匹配窗口
            while (flag == need) {
                // 修改最小匹配长度
                int currLen = right - left + 1;
                if (currLen < length) {
                    start = left;
                    length = currLen;
                }
                // 收缩窗口
                final char c = s.charAt(left++);
                final int currIdx = c - 'A';
                if (template[currIdx] > 0 && --hash[currIdx] < template[currIdx]) {
                    flag--;
                }
            }

            right++;
        }

        return length == Integer.MAX_VALUE ? "" : s.substring(start, start + length);
    }
}
