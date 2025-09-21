package top.chenqwwq.leetcode.daily._2022._20220612;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenqwwq
 * @date 2022/6/12
 **/
public class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        for (String word : words){
            if(check(word,pattern)){
                ans.add(word);
            }
        }
        return ans;
    }

    private boolean check(String word, String pattern) {
        int[] hash = new int[26];
        boolean[] vis = new boolean[26];
        Arrays.fill(hash, -1);
        for (int i = 0; i < word.length(); i++) {
            int pos = word.charAt(i) - 'a';
            if (hash[pos] != -1) {
                if (hash[pos] != pattern.charAt(i)) {
                    return false;
                }
            } else {
                int idx = pattern.charAt(i) - 'a';
                if (vis[idx]) {
                    return false;
                }
                hash[pos] = pattern.charAt(i);
                vis[idx] = true;
            }
        }
        return true;
    }
}