package top.chenqwwq.leetcode.archive.$20200418.common;

/**
 * 450. 删除二叉搜索树中的节点
 * <p>
 * 提交记录
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 * <p>
 * 一般来说，删除节点可分为两个步骤：
 * <p>
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 * 说明： 要求算法时间复杂度为 O(h)，h 为树的高度。
 * <p>
 * 示例:
 * <p>
 * root = [5,3,6,2,4,null,7]
 * key = 3
 * <p>
 * 5
 * / \
 * 3   6
 * / \   \
 * 2   4   7
 * <p>
 * 给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
 * <p>
 * 一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
 * <p>
 * 5
 * / \
 * 4   6
 * /     \
 * 2       7
 * <p>
 * 另一个正确答案是 [5,2,6,null,4,null,7]。
 * <p>
 * 5
 * / \
 * 2   6
 * \   \
 * 4   7
 *
 * @author bingxin.chen
 * @date 2019/8/26 12:41
 */
public class LeetCode450 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public TreeNode deleteNode(TreeNode root, int key) {

            TreeNode node = root, parent = null;
            // 二叉树相关的首先考虑递归
            // 删除选中的节点，将节点的右子树下挂至左子树的最右端
            while (node != null) {
                if (node.val == key) {
                    return handle(root, parent, node);
                }
                parent = node;
                node = node.val > key ? node.left : node.right;
            }
            return root;
        }

        /**
         * 找到待删除节点后的主要处理方法
         *
         * @param root       root节点
         * @param parentNode 待删除节点的父节点,父节点为空表示根节点为待删除节点
         * @param node       待删除的节点
         * @return 返回值
         */
        private TreeNode handle(TreeNode root, TreeNode parentNode, TreeNode node) {
            // bugs: 忽略了头结点即为待删除节点或者待删除节点左节点未空的情况
            TreeNode mostLeft = node.left;

            // 1. 区分是否有左子树
            // 2. 区分是否为头结点
            if (mostLeft == null) {
                if (parentNode == null) {
                    return root.right;
                }
                // 不为头节点,则继续
            }
            // 找到左节点最右边的节点
            if (mostLeft != null) {
                while (mostLeft.right != null) {
                    mostLeft = mostLeft.right;
                }

                // 被删除节点的右节点挂在左节点的最右节点下
                mostLeft.right = node.right;
            }

            if (parentNode == null) {
                return node.left;
            }

            // 将被删除节点的左节点挂在parent下
            if (parentNode.val > node.val) {
                parentNode.left = node.left;
            } else {
                parentNode.right = node.left;
            }
            return root;
        }

    }
}
