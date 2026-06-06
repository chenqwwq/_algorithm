package top.chenqwwq.leetcode.contest.weekly._311._4;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenqwwq
 * @date 2022/9/18
 **/
public class Solution {
    Node root = new Node();

    static class Node {
        Node[] child = new Node[26];
        int cnt = 0;

    }

    public void insert(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            if (node.child[c - 'a'] == null) node.child[c - 'a'] = new Node();
            node = node.child[c - 'a'];
            node.cnt++;
        }
    }

    public int cnt(String word) {
        Node node = root;
        int cnt = 0;
        for (int i = 0; i < word.length() && node != null; i++) {
            node = node.child[word.charAt(i) - 'a'];
            cnt += node.cnt;
        }
        return cnt;
    }

    Map<String, Integer> memo = new HashMap<>();

    public int[] sumPrefixScores(String[] words) {
        final int n = words.length;
        for (String word : words) insert(word);
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) ans[i] = cnt(words[i]);
        return ans;
    }
}