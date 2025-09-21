package top.chenqwwq.leetcode.lcp._2022_fall._4;

import top.chenqwwq.leetcode.common.TreeNode;

import javax.swing.plaf.IconUIResource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chenqwwq
 * @date 2022/9/24
 **/
public class Solution {

    Map<String, Integer> cache;

    public int closeLampInTree(TreeNode root) {
        cache = new HashMap<>();
        if (root == null) return 0;
        return dfs(root, 1, false);
    }

    int dfs(TreeNode node, int idx, boolean status) {
        if (node == null) return 0;
        String key = "" + idx + node.val + status;
        if (cache.containsKey(key)) return cache.get(key);
        if ((node.val == 1 && status) || (!status && node.val == 0)) {
            int cnt = dfs(node.left, idx << 1, status) + dfs(node.right, (idx << 1) + 1, status);
            cache.put(key, cnt);
            return cnt;
        }
        // 只改变当前节点
        int c1 = dfs(node.left, idx << 1, status) + dfs(node.right, (idx << 1) + 1, status);
        // 改变全部的节点
        int c2 = dfs(node.left, idx << 1, !status) + dfs(node.right, (idx << 1) + 1, !status);
        // 改变当前和两个子节点
        if (node.left != null) node.left.val = 1 - node.left.val;
        if (node.right != null) node.right.val = 1 - node.right.val;
        int c3 = dfs(node.left, idx << 1, status) + dfs(node.right, (idx << 1) + 1, status);
        if (node.left != null) node.left.val = 1 - node.left.val;
        if (node.right != null) node.right.val = 1 - node.right.val;
        int cnt = Math.min(c1, Math.min(c2, c3)) + 1;
        cache.put(key, cnt);
        return cnt;
    }
}