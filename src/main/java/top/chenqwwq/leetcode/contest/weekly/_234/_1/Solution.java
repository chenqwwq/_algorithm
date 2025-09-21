package top.chenqwwq.leetcode.contest.weekly._234._1;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chen
 * @date 2021/3/28
 **/
public class Solution {
    public int numDifferentIntegers(String word) {
        if (word == null || word.length() == 0) {
            return 0;
        }
        final char[] chars = word.toCharArray();
        Set<String> set = new HashSet<>();
        int idx = 0;
        while (idx < chars.length) {
            // 表示数字
            if (chars[idx] < 97) {
                int start = idx++;
                while (idx < chars.length && chars[idx] < 97) {
                    idx++;
                }
                String substring = word.substring(start, idx);
                while (substring.startsWith("0")) {
                    substring = substring.substring(1);
                }
                set.add(substring);
            }
            idx++;
        }

        return set.size();
    }
}