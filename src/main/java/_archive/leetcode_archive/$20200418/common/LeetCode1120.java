package top.chenqwwq.leetcode.archive.$20200418.common;

/**
 * @author chen
 * @date 19-7-13 下午10:43
 */
public class LeetCode1120 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2);
        treeNode.right = new TreeNode(1);

        System.out.println(new LeetCode1120().new Solution().maximumAverageSubtree(treeNode));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        double res = Double.MIN_VALUE;

        public double maximumAverageSubtree(TreeNode root) {
            if (root == null) {
                return 0;
            }
            handle(root);

            return res;
        }

        public int[] handle(TreeNode root) {
            if (root != null && root.left == null && root.right == null) {
                res = Math.max(root.val, res);
                return new int[]{1, root.val};
            }
            int[] nums1 = new int[]{0, 0}, nums2 = new int[]{0, 0};
            if (root.right != null) {
                nums1 = handle(root.right);
            }
            if (root.left != null) {
                nums2 = handle(root.left);
            }

            int i = nums1[0] + nums2[0] + 1;
            int sum = nums2[1] + nums1[1] + root.val;
            res = Math.max((double) sum / (double) i, res);
            return new int[]{i, sum};

        }
    }
}
