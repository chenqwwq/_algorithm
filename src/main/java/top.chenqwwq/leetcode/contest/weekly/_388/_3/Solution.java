package top.chenqwwq.leetcode.contest.weekly._388._3;

import top.chenqwwq.leetcode.common.Node;
import top.chenqwwq.leetcode.common.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chenqwwq
 * @date 2024/3/10
 **/
public class Solution {

    private static final int inf = 0x3f3f3f3f;

    static class TreeNode {
        TreeNode[] childs;
        Set<Integer> set;

        public TreeNode() {
            this.childs = new TreeNode[26];
            this.set = new HashSet<>();
        }

        public int find(String s, int i) {
            // 如果是最后一位直接判断是否存在
            // 存在则返回当前的下标
            if (i == s.length()) {
                return this.set.size() == 1 ? i : inf;
            }
            // 确定下标
            final int idx = s.charAt(i) - 'a';
            // 目标节点
            final TreeNode target = childs[idx];
            // 当前节点的计数等于1说明当前也是有效子字符串
            // 当前节点和后续节点取最大值
            return Math.min(target.set.size() == 1 ? i : inf, target.find(s, i + 1));
        }

        public void load(String s, int i, int j) {
            if (i >= s.length()) return;
            final int idx = s.charAt(i) - 'a';
            if (childs[idx] == null) childs[idx] = new TreeNode();
            childs[idx].set.add(j);
            childs[idx].load(s, i + 1, j);
        }
    }

    public String[] shortestSubstrings(String[] arr) {
        final int n = arr.length;
        final TreeNode root = new TreeNode();
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < arr[j].length(); i++) {
                root.load(arr[j], i, j);
            }
        }
        final String[] ans = new String[n];
        for (int j = 0; j < n; j++) {
            final String s = arr[j];
            String t = "";
            for (int i = 0; i < s.length(); i++) {
                final int r = root.find(s, i);
                if (r != inf) {
                    final String tt = s.substring(i, r + 1);
                    if (t.isEmpty() || tt.length() < t.length() || (tt.length() == t.length() && tt.compareTo(t) < 1))
                        t = tt;
                }
            }
            ans[j] = t;
        }
        return ans;
    }
}