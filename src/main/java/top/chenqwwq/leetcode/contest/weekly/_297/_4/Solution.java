package top.chenqwwq.leetcode.contest.weekly._297._4;

/**
 * @author chenqwwq
 * @date 2022/6/12
 **/
public class Solution {
    class Node {
        Node[] next = new Node[26];
        boolean end;

    }

    Node root = new Node();

    private void insert(String idea) {
        Node node = root;
        for (int i = idea.length() - 1; i >= 0; i--) {
            char c = idea.charAt(i);
            if (node.next[c - 'a'] == null) {
                node.next[c - 'a'] = new Node();
            }
            node = node.next[c - 'a'];
        }
        node.end = true;
    }

    boolean[] empty = new boolean[26];

    private Node find(String idea) {
        Node node = root;
        for (int i = idea.length() - 1; i > 0; i--) {
            char c = idea.charAt(i);
            if (node.next[c - 'a'] == null) {
                return null;
            }
            node = node.next[c - 'a'];
        }
        return node;
//            exist[i] = node.next[i] != null && node.next[i].end;
    }

    public long distinctNames(String[] ideas) {
        int n = ideas.length;
        int[] cs = new int[26];
        for (String idea : ideas) {
            insert(idea);
            cs[idea.charAt(0) - 'a']++;
        }
        long ans = (long) n * (n - 1);

        for (String idea : ideas) {
            Node node = find(idea);
            for (int i = 0; i < 26; i++) {
                if (node.next[i] != null && node.next[i].end) {
                    ans -= 2L * (i == idea.charAt(0) - 'a' ? cs[i] - 1 : cs[i]);
                    node.next[i].end = false;
                }
            }
        }
        return ans;
    }
}