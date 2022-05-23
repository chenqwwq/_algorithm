package top.chenqwwq.leetcode.weekly._293._1;

import java.util.*;

/**
 * @author chenqwwq
 * @date 2022/5/15
 **/
public class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> ans = new ArrayList<>();
        Collections.addAll(ans, words);
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 1; i < ans.size(); i++) {
                if (eq(ans.get(i), ans.get(i - 1))) {
                    flag = true;
                    ans.remove(i);
                    break;
                }
            }
        }
        return ans;
    }

    private boolean eq(String a, String b) {
        int[] h1 = new int[26];
        int[] h2 = new int[26];
        for (char c : a.toCharArray()) {
            h1[c - 'a']++;
        }
        for (char c : b.toCharArray()) {
            h2[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (h1[i] != h2[i]) {
                return false;
            }
        }
        return true;
    }
}