package top.chenqwwq.leetcode.archive.$20200418.common;

/**
 * 889. 根据前序和后序遍历构造二叉树
 * <p>
 * 输入：pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
 * 输出：[1,2,3,4,5,6,7]
 *
 * @author bingxin.chen
 * @date 2019/4/12 09:39
 */
public class LeetCode889 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public TreeNode constructFromPrePost(int[] pre, int[] post) {
            if (pre == null || post == null || pre.length == 0 || post.length == 0) {
                return null;
            }

            return null;
        }
    }
}
