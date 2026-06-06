package top.chenqwwq.leetcode.archive.$20200418.daily;

/**
 * 543. 二叉树的直径
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
 * <p>
 * 示例 :
 * 给定二叉树
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 * <p>
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 *
 * @author chen
 * @date 2020/3/10 下午1:04
 */
public class $0010 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        private int max = 0;

        public int diameterOfBinaryTree(TreeNode root) {
            dfs(root);
            return max;
        }

        /**
         * 返回的是该节点最深的子树深度
         */
        private int dfs(TreeNode root) {
            // 当前节点为空，深度即为0
            if (root == null) {
                return 0;
            }

            // 返回右边的最大深度
            final int r = dfs(root.right);
            final int l = dfs(root.left);
            max = Math.max(max, r + l);
            return Math.max(r, l) + 1;
        }
    }
}
