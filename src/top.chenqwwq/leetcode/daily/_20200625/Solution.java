package top.chenqwwq.leetcode.daily._20200625;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 139. 单词拆分
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * <p>
 * 说明：
 * <p>
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 *
 * @author chen
 * @date 2020/6/25 上午8:52
 */
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return false;
        }

        // dp
        // dp[i]表示0~i-1位置是否可以用wordDict中的字符表示
        boolean[] dp = new boolean[s.length() + 1];

        dp[0] = true;

        // 将wordDict转成Set
        Set<String> set = new HashSet<>(wordDict);

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j >= 0; j--) {
                if (dp[j] && set.contains(s.substring(j, i + 1))) {
                    dp[i + 1] = true;
                    break;
                }
            }
        }

        return dp[s.length()];


    }
}