package top.chenqwwq.leetcode.topic.dp._139;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 139. 单词拆分
 * 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * <p>
 * 说明：
 * <p>
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 * <p>
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * 示例 2：
 * <p>
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 * 注意你可以重复使用字典中的单词。
 * 示例 3：
 * <p>
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 *
 * @author chen
 * @date 2020-11-02
 **/
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // 0~i的字符是否可以呗wordDict分割
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        // 取Set
        Set<String> hash = new HashSet<>(wordDict);

        outer:
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (hash.contains(s.substring(j, i)) && dp[j]) {
                    dp[i] = true;
                    continue outer;
                }
            }
        }
        return dp[s.length()];
    }
}