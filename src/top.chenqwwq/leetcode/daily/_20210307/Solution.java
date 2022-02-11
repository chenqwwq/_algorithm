package top.chenqwwq.leetcode.daily._20210307;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chen
 * @date 2021/3/7
 * <p>
 * 131. 分割回文串
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * <p>
 * 返回 s 所有可能的分割方案。
 * <p>
 * 示例:
 * <p>
 * 输入: "aab"
 * 输出:
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 **/
public class Solution {
    /**
     * answer
     **/
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> partition(String s) {
        return null;
    }

    public List<List<String>> dfs(int start, String s, List<String> list) {
        // 回溯
        for (int i = start; i < s.length(); i++) {
            String s1 = String.valueOf(s.charAt(i));
            list.add(s1);


        }
        return null;
    }

}