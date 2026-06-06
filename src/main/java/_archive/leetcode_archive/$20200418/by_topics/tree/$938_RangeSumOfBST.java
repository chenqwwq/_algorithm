package top.chenqwwq.leetcode.archive.$20200418.by_topics.tree;

/**
 * 938. Range Sum of BST
 * Easy
 * <p>
 * Given the root node of a binary search tree, return the sum of values of all nodes with value between L and R (inclusive).
 * <p>
 * The binary search tree is guaranteed to have unique values.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
 * Output: 32
 * Example 2:
 * <p>
 * Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
 * Output: 23
 * <p>
 * <p>
 * Note:
 * <p>
 * The number of nodes in the tree is at most 10000.
 * The final answer is guaranteed to be less than 2^31.
 *
 * @author bingxin.chen
 * @date 2019 /9/4 12:12
 */
public class $938_RangeSumOfBST {
    /**
     * The type Tree node.
     */
    public class TreeNode {
        /**
         * The Val.
         */
        int val;
        /**
         * The Left.
         */
        TreeNode left;
        /**
         * The Right.
         */
        TreeNode right;

        /**
         * Instantiates a new Tree node.
         *
         * @param x the x
         */
        TreeNode(int x) {
            val = x;
        }
    }

//    /**
//     * Beat 17%
//     * 没有考虑二叉搜索树的特性,递归时可以顺便剪枝
//     */
//    class Solution {
//        public int rangeSumBST(TreeNode root, int L, int R) {
//            if(root == null){
//                return 0;
//            }
//            if(root.left == null && root.right == null){
//                return getVal(root.val,L,R);
//            }
//            return rangeSumBST(root.left,L,R) + rangeSumBST(root.right,L,R) + getVal(root.val,L,R);
//        }
//
//        private int getVal(int val,int L,int R){
//            return val >= L && val <= R ? val : 0;
//        }
//    }

    /**
     * beat 100%
     */
    class Solution {

        public int rangeSumBST(TreeNode root, int L, int R) {
            if (root == null) {
                return 0;
            }
            if (root.left == null && root.right == null) {
                return getVal(root.val, L, R);
            }
            if (root.val > R) {
                return rangeSumBST(root.left, L, R);
            }

            if (root.val < L) {
                return rangeSumBST(root.right, L, R);
            }

            return rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R) + root.val;
        }

        private int getVal(int val, int L, int R) {
            return val >= L && val <= R ? val : 0;
        }
    }
}
