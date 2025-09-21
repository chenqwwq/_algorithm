package top.chenqwwq.leetcode.topic.dp._140;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenqwwq
 * @date 2022/5/22
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

    public List<String> wordBreak(String s, List<String> wordDict) {
        final int n = s.length();
        Trie root = new Trie();
        for (String word : wordDict) {
            root.insert(word);
        }

        List<String>[] ss = new List[n];
        for (int i = 0; i < n; i++) {
            ss[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                String curr = s.substring(j, i + 1);
                if (root.exist(s, j, i)) {
                    if (j <= 0) {
                        ss[i].add(curr);
                    } else {
                        for (String pre : ss[j - 1]) {
                            ss[i].add(pre + " " + curr);
                        }
                    }

                }
            }
        }
        return ss[n - 1];
    }
}