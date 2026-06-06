package top.chenqwwq.leetcode.archive.$20200418.lcof;

/**
 * 面试题07. 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * <p>
 * <p>
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 5000
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 * @author chen
 * @date 2020/3/6 下午3:16
 */
public class $07 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            /**
             * 从前序和中序遍历中恢复一个二叉树
             */

            // 排除异常
            if (preorder == null
                    || inorder == null
                    || inorder.length == 0
                    || inorder.length != preorder.length) {
                return null;
            }

            // 递归调用
            return rebuild(preorder, inorder, 0, 0, inorder.length - 1);
        }

        /**
         * @param pre   前序遍历数组
         * @param in    中序遍历数组
         * @param preSt 前序起始
         * @param inSt  中序起始
         * @param inEnd 中序终止
         * @return 返回根节点
         */
        public TreeNode rebuild(int[] pre, int[] in, int preSt, int inSt, int inEnd) {
            // 判断
            if (inSt > inEnd || preSt >= pre.length) {
                return null;
            }
            TreeNode root = new TreeNode(pre[preSt]);
            // 中序遍历和前序遍历的数组都拆成两个数组
            // inSt:mid-1,mid+1:inEnd
            int tempStart = inSt;
            int mid = inSt;
            while (tempStart <= inEnd) {
                if (pre[preSt] == in[tempStart]) {
                    mid = tempStart;
                    break;
                }
                tempStart++;
            }
            // 递归

            root.left = rebuild(pre, in, preSt + 1, inSt, mid - 1);
            root.right = rebuild(pre, in, preSt + mid - inSt + 1, mid + 1, inEnd);

            return root;
        }
    }
}
