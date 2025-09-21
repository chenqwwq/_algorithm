package top.chenqwwq.leetcode.contest.weekly._415._3;

/**
 * @author chenqwwq
 * @date 2024/9/21
 **/
public class Solution {

    static final class Node {
        Node[] child;
        boolean end = false;

        public Node() {
            child = new Node[26];
        }
    }

    void put(Node cur, String s) {
        for (char c : s.toCharArray()) {
            final int idx = c - 'a';
            if (cur.child[idx] == null) {
                cur.child[idx] = new Node();
            }
            cur = cur.child[idx];
        }
        cur.end = true;
    }

    public int minValidStrings(String[] words, String target) {
        final Node root = new Node();
        for (String word : words) {
            put(root, word);
        }

        final char[] cs = target.toCharArray();
        int n = cs.length;
        int[] dp = new int[n + 1];

        for (int i = 0; i < n; i++) {

        }
        return 1; // todo:
    }
}