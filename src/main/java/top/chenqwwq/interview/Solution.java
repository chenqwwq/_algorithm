package top.chenqwwq.interview;

/**
 * @author chenqwwq
 * @date 2026/3/16
 **/
public class Solution {
    public class Node {
        Node[] cs;
        int cnt = 0;

        public Node() {
            cs = new Node[26];
        }
    }

    int n;
    String ans = "";

    public void insert(Node root, String s) {
        Node cur = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (cur.cs[c - 'a'] == null) {
                final Node node = new Node();
                cur.cs[c - 'a'] = node;
                cur = node;
                cur.cnt++;
            } else {
                cur = cur.cs[c - 'a'];
                if (++cur.cnt == n) {
                    ans = s.substring(0, i + 1);
                }
            }
        }
    }

    public String find(String[] ss) {
        this.n = ss.length;

        Node root = new Node();
        for (String s : ss) {
            insert(root, s);
        }
        return ans;
    }
}
