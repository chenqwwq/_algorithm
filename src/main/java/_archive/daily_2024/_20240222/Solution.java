package top.chenqwwq.leetcode.daily._2024._20240222;

import top.chenqwwq.leetcode.common.TreeNode;

/**
 * @author chenqwwq
 * @date 2024/2/22
 **/
public class Solution {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return dfs(preorder, postorder, 0, preorder.length - 1, 0, postorder.length - 1);
    }

    public TreeNode dfs(int[] pre, int[] post, int l1, int r1, int l2, int r2) {
        if (l1 > r1) return null;
        if (l1 == r1) return new TreeNode(pre[l1]);
        int i = l2, val = pre[l1 + 1];
        while (i < r2 && val != post[i]) i++;
        final int ls = i - l2 + 1;
        return new TreeNode(pre[l1],
                dfs(pre, post, l1 + 1, l1 + ls, l2, i),
                dfs(pre, post, l1 + ls + 1, r1, i + 1, r2 - 1));
    }
}