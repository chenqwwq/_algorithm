package top.chenqwwq.leetcode.archive.$20200418.common;

/**
 * 965. 单值二叉树
 * 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
 * <p>
 * 只有给定的树是单值二叉树时，才返回 true；否则返回 false。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,1,1,1,1,null,1]
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：[2,2,2,5,2]
 * 输出：false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/univalued-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chen
 * @date 19-7-20 下午10:26
 */
public class LeetCode965 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public boolean isUnivalTree(TreeNode root) {
            return root == null || check(root, root.val);
        }

        public boolean check(TreeNode node, int val) {
            if (node == null) {
                return true;
            }

            return node.val == val && check(node.left, val) && check(node.right, val);
        }
    }
}
