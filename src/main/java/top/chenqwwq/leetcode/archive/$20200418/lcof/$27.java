package top.chenqwwq.leetcode.archive.$20200418.lcof;

/**
 * 面试题27. 二叉树的镜像
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * 例如输入：
 * <p>
 * 4
 * /   \
 * 2     7
 * / \   / \
 * 1   3 6   9
 * 镜像输出：
 * <p>
 * 4
 * /   \
 * 7     2
 * / \   / \
 * 9   6 3   1
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 1000
 *
 * @author chen
 * @date 2020/4/11 下午1:17
 */
public class $27 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public TreeNode mirrorTree(TreeNode root) {
            if (root == null) {
                return null;
            }
            if (root.left == null && root.right == null) {
                return root;
            }
            // 处理所有子节点
            mirrorTree(root.right);
            mirrorTree(root.left);

            // 替换当前节点左右子树
            TreeNode treeNode = root.left;
            root.left = root.right;
            root.right = treeNode;

            return root;
        }
    }
}
