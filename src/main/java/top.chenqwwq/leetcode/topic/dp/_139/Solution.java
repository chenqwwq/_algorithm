package top.chenqwwq.leetcode.topic.dp._139;


import java.util.*;

/**
 * @author chen
 * @date 2020-11-02
 **/
public class Solution {
    class Trie {
        Trie[] child;
        boolean end;

        public Trie() {
            this.child = new Trie[26];
        }

        public void insert(String s) {
            Trie node = this;
            for (char c : s.toCharArray()) {
                if (node.child[c - 'a'] == null) {
                    node.child[c - 'a'] = new Trie();
                }
                node = node.child[c - 'a'];
            }
            node.end = true;
        }

        public boolean exist(String s, int l, int r) {
            Trie node = this;
            while (l <= r) {
                char c = s.charAt(l++);
                if (node.child[c - 'a'] == null) {
                    return false;
                }
                node = node.child[c - 'a'];
            }
            return node.end;
        }
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        final int n = s.length();
        boolean[] dp = new boolean[n];
        Trie root = new Trie();
        for (String word : wordDict) {
            root.insert(word);
        }

        dp[0] = root.exist(s, 0, 0);
        for (int i = 1; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                if (root.exist(s, j, i)) {
                    dp[i] |= j <= 0 || dp[j - 1];
                }
            }
        }
        return dp[n - 1];
    }
}