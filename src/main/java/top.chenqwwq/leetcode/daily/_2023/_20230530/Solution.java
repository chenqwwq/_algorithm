package top.chenqwwq.leetcode.daily._2023._20230530;

import top.chenqwwq.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 沽酒
 * @since 2023/05/30
 */
public class Solution {
    private List<TreeNode> ans = new ArrayList<>();

    private boolean[] deleted = new boolean[1001];

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if (root == null) return new ArrayList<>();
        for (int idx : to_delete) deleted[idx] = true;
        handle(null,root,true);
        return ans;
    }


    public void handle(TreeNode parent, TreeNode curr, boolean left) {
        if (curr == null) return;
        if (deleted[curr.val]) {
            if(parent != null) {
                if (left) parent.left = null;
                else parent.right = null;
            }
            handle(null, curr.left, true);
            handle(null, curr.right, false);
            return;
        }
        if (parent == null) ans.add(curr);
        handle(curr, curr.left, true);
        handle(curr, curr.right, false);

    }
}