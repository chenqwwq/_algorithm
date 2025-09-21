package top.chenqwwq.leetcode.archive.$20200418.common;

import lombok.extern.slf4j.Slf4j;

/**
 * @author chen
 * @description
 * @email ai654778@vip.qq.com
 * @date 19-1-11
 */
@Slf4j
public class LeetCode925 {
    public static void main(String[] args) {
        log.info((4 >>> 3) + "");
        log.info(Runtime.getRuntime().availableProcessors() + "");
        log.info("" + new Solution().isLongPressedName("leelee", "lleeelee"));
    }

    static class Solution {
        public boolean isLongPressedName(String name, String typed) {
            if (typed.length() == 0 || name.length() > typed.length()) {
                return false;
            }
            char[] nameChars = name.toCharArray(), typedChars = typed.toCharArray();
            int nameLen = name.length(), typedLen = typed.length();

            int i = 0;
            for (int j = 0; i < nameLen && j < typedLen; ) {
                if (nameChars[i] == typedChars[j]) {
                    // 如果一样直接对比下一个
                    i++;
                    j++;
                } else {
                    if (j > 0 && typedChars[j] == typedChars[j - 1]) {
                        j++;
                    } else {
                        return false;
                    }
                }
            }
            return i == nameLen;
        }
    }
}
