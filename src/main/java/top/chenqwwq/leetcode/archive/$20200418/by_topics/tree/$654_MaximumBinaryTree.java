package top.chenqwwq.leetcode.archive.$20200418.by_topics.tree;

/**
 * 654. 最大二叉树
 * <p>
 * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 * <p>
 * 二叉树的根是数组中的最大元素。
 * 左子树是通过数组中最大值左边部分构造出的最大二叉树。
 * 右子树是通过数组中最大值右边部分构造出的最大二叉树。
 * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
 * <p>
 * 示例 ：
 * <p>
 * 输入：[3,2,1,6,0,5]
 * 输出：返回下面这棵树的根节点：
 * <p>
 * 6
 * /   \
 * 3     5
 * \    /
 * 2  0
 * \
 * 1
 * <p>
 * 提示：
 * <p>
 * 给定的数组的大小在 [1, 1000] 之间。
 *
 * @author bingxin.chen
 * @date 2019/12/19 16:27
 */
public class $654_MaximumBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            return constructTree(nums, 0, nums.length - 1);
        }

        public TreeNode constructTree(int[] nums, int start, int end) {
            if (start > end) {
                return null;
            }

            final int maxNumIndex = getMaxNumIndex(nums, start, end);
            TreeNode root = new TreeNode(nums[maxNumIndex]);
            root.right = constructTree(nums, maxNumIndex + 1, end);
            root.left = constructTree(nums, start, maxNumIndex - 1);

            return root;
        }

        public int getMaxNumIndex(int[] nums, int start, int end) {
            int max = start;
            while (++start <= end) {
                if (nums[start] > nums[max]) {
                    max = start;
                }
            }
            return max;
        }
    }
}
