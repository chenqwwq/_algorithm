package top.chenqwwq.leetcode.daily._2026._20260224;

import top.chenqwwq.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenqwwq
 * @date 2026/2/24
 **/
public class Solution {
    public int sumRootToLeaf(TreeNode root) {
        if (root == null) return 0;
        final List<int[]> dfs = dfs(root);
        int ans = 0;
        for (int[] d : dfs) {
            ans += d[1];
        }
        return ans;
    }

    public List<int[]> dfs(TreeNode node) {
        List<int[]> ret = new ArrayList<>();
        if (node == null) {
            ret.add(new int[]{-1, 0});
            return ret;
        }
        if (node.left == null && node.right == null) {
            ret.add(new int[]{0, node.val});
            return ret;
        }
        final List<int[]> l = dfs(node.left), r = dfs(node.right);

        if (node.left != null) {
            for (int[] x : l) {
                ret.add(new int[]{x[0] + 1, x[1] + (node.val << (x[0] + 1))});
            }
        }
        if (node.right != null) {
            for (int[] x : r) {
                ret.add(new int[]{x[0] + 1, x[1] + (node.val << (x[0] + 1))});
            }
        }

        return ret;
    }
}