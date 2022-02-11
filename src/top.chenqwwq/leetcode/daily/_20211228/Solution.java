package top.chenqwwq.leetcode.daily._20211228;

import java.util.*;

/**
 * @author chenbingxin
 * @date 2021/12/28
 **/
public class Solution {


    static class TreeNode {
        Map<Character, TreeNode> child;
        boolean end;

        public TreeNode() {
            this.child = new HashMap<>();
            this.end = false;
        }

        public void init(String word) {
            TreeNode node = this;
            for (char c : word.toCharArray()) {
                node = node.child.computeIfAbsent(c, character -> new TreeNode());
            }
            node.end = true;
        }

        public boolean dfs(String word, int i) {
            if (word.length() == i) {
                return true;
            }
            final int n = word.length();
            TreeNode node = this;
            for (; i < n; i++) {
                node = node.child.get(word.charAt(i));
                if (Objects.isNull(node)) {
                    return false;
                }
                if (node.end && dfs(word, i + 1)) {
                    return true;
                }
            }
            return false;
        }
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        TreeNode root = new TreeNode();
        if (words.length < 3) {
            return new ArrayList<>();
        }

        List<String> ans = new ArrayList<>();
        Arrays.sort(words, Comparator.comparingInt(String::length));
        for (String word : words) {
            if (word.length() == 0) {
                continue;
            }
            if (root.dfs(word, 0)) {
                ans.add(word);
            } else {
                root.init(word);
            }
        }

        return ans;
    }
}