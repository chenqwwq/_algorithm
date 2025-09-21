package top.chenqwwq.leetcode.contest.weekly._197._2;

import java.util.ArrayList;
import java.util.List;

/**
 * 仅含 1 的子串数
 * 题目难度Medium
 * 给你一个二进制字符串 s（仅由 '0' 和 '1' 组成的字符串）。
 * <p>
 * 返回所有字符都为 1 的子字符串的数目。
 * <p>
 * 由于答案可能很大，请你将它对 10^9 + 7 取模后返回。
 * <p>
 * 提示：
 * <p>
 * s[i] == '0' 或 s[i] == '1'
 * 1 <= s.length <= 10^5
 *
 * @author chen
 * @date 2020/7/12 上午10:28
 */
public class Solution {
    private static final double MOD = 1e9 + 7;

    public int numSub(String s) {
        List<Integer> size = new ArrayList<>();
        final char[] chars = s.toCharArray();
        int start = 0, end = 0;
        while (start <= end && end < chars.length) {
            if (chars[end] == '0') {
                if (end > start) {
                    size.add(end - start);
                }
                start = ++end;
            } else {
                end++;
            }
        }

        if (end > start) {
            size.add(end - start);
        }

        long res = 0;
        for (int i : size) {
            res += ((i + 1) * (i / 2.0));
        }
        return (int) (res % MOD);
    }

}