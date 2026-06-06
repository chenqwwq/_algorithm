package top.chenqwwq.leetcode.daily._2022._20221030;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenqwwq
 * @date 2022/10/30
 **/
public class Solution {
    String s;
    int n;
    List<String> ans = new ArrayList<>();

    public List<String> letterCasePermutation(String s) {
        this.s = s;
        this.n = s.length();
        dfs("");
        return ans;
    }

    public void dfs(String curr) {
        if (curr.length() >= n) {
            ans.add(curr);
            return;
        }
        final int i = curr.length();
        final char ch = s.charAt(i);
        dfs(curr + ch);
        if (Character.isLetter(ch)) {
            if (Character.isUpperCase(ch)) dfs(curr + Character.toLowerCase(ch));
            else dfs(curr + Character.toUpperCase(ch));
        }
    }
}