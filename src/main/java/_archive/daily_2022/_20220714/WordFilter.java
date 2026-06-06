package top.chenqwwq.leetcode.daily._2022._20220714;

import javax.swing.tree.TreeNode;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 沽酒
 * @since 2022/07/14
 */
public class WordFilter {

    static class TreeNode {
        TreeNode[] child;
        List<Integer> data;

        public TreeNode() {
            child = new TreeNode[26];
            data = new ArrayList<>();
        }

        public void insert(String word, int pos) {
            TreeNode node = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (node.child[c - 'a'] == null) {
                    node.child[c - 'a'] = new TreeNode();
                }
                node = node.child[c - 'a'];
                node.data.add(pos);
            }
        }

        public void rInsert(String word, int pos) {
            TreeNode node = this;
            for (int i = word.length() - 1; i >= 0; i--) {
                char c = word.charAt(i);
                if (node.child[c - 'a'] == null) {
                    node.child[c - 'a'] = new TreeNode();
                }
                node = node.child[c - 'a'];
                node.data.add(pos);
            }
        }

        public TreeNode find(String word) {
            TreeNode node = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (node.child[c - 'a'] == null) {
                    return null;
                }
                node = node.child[c - 'a'];
            }
            return node;
        }

        public TreeNode rFind(String word) {
            TreeNode node = this;
            for (int i = word.length() - 1; i >= 0; i--) {
                char c = word.charAt(i);
                if (node.child[c - 'a'] == null) {
                    return null;
                }
                node = node.child[c - 'a'];
            }
            return node;
        }
    }

    TreeNode n1, n2;


    public WordFilter(String[] words) {
        n1 = new TreeNode();
        n2 = new TreeNode();
        for (int i = 0; i < words.length; i++) {
            n1.insert(words[i], i);
            n2.rInsert(words[i], i);
        }
    }

    public int f(String pref, String suff) {
        TreeNode t1 = n1.find(pref), t2 = n2.rFind(suff);
        if (t1 == null || t2 == null) {
            return -1;
        }
        List<Integer> l1 = t1.data, l2 = t2.data;
        int n = l1.size() - 1, m = l2.size() - 1;
        while (n >= 0 && m >= 0) {
            if (l1.get(n) < l2.get(m)) {
                m--;
            } else if (l1.get(n) > l2.get(m)) {
                n--;
            } else {
                return l1.get(n);
            }
        }
        return -1;
    }
}
