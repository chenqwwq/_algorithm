package top.chenqwwq.leetcode.topic.backtrack._140;

import java.util.*;

/**
 * 140. 单词拆分 II
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 * <p>
 * 说明：
 * <p>
 * 分隔时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 * <p>
 * 输入:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * 输出:
 * [
 * "cats and dog",
 * "cat sand dog"
 * ]
 * 示例 2：
 * <p>
 * 输入:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * 输出:
 * [
 * "pine apple pen apple",
 * "pineapple pen apple",
 * "pine applepen apple"
 * ]
 * 解释: 注意你可以重复使用字典中的单词。
 * 示例 3：
 * <p>
 * 输入:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出:
 * []
 *
 * @author chen
 * @date 2020-11-02
 **/
public class Solution {
    public static void main(String[] args) {
        new Solution().wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog")).forEach(System.out::println);
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        if (wordDict == null || wordDict.size() == 0) {
            return new ArrayList<>();
        }
        List<String> ans = new ArrayList<>();
        backTrace(s, 0, new HashSet<>(wordDict), ans, new ArrayList<>(), "");
        return ans;
    }


    // 回溯的主方法
    // 每个字母都可以属于前面或者后面
    // 假设wordDice中不包含重复的单词
    // last必须是在wordDice的单词
    public void backTrace(String s, int l, Set<String> wordDice, List<String> ans, List<String> history, String last) {
        // 退出条件
        if (l == s.length()) {
            StringBuilder tmp = new StringBuilder();
            for (String t : history) {
                tmp.append(t);
                tmp.append(" ");
            }
            ans.add(tmp.toString() + last);
            return;
        }

        // 1. 以l为开头，记录新的单词
        // 先找到以l开头的包含在wordDice的单词
        String c = null;
        int i = l + 1;
        for (; i <= s.length(); i++) {
            final String substring = s.substring(l, i);
            if (wordDice.contains(substring)) {
                c = substring;
                break;
            }
        }
        // 在以c开头存在单词的时候进入下一步
        if (c != null) {
            if (!last.equals("")) {
                history.add(last);
            }
            backTrace(s, i, wordDice, ans, history, c);
            // 删除历史中的单词
            if (!last.equals("")) {
                history.remove(history.size() - 1);
            }
        }

        // 2. 将l的字母合并到前一个单词
        // 合并后的单词在wordDice中,就开启下一轮循环
        if (!last.equals("")) {
            String str2 = null;
            int k = l + 1;
            for (; l <= s.length(); k++) {
                final String substring = last + s.substring(l, k);
                if (wordDice.contains(substring)) {
                    str2 = substring;
                    break;
                }
            }
            if (str2 != null) {
                // 开始判断下一个单词
                backTrace(s, k, wordDice, ans, history, str2);
            }
        }
    }

}




























