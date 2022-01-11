package top.chenqwwq.leetcode.archive.$20200418.common;

import java.util.ArrayList;
import java.util.List;

/**
 * 199. 二叉树的右视图
 * <p>
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 * <p>
 * 1            <---
 * /   \
 * 2     3         <---
 * \     \
 * 5     4       <---
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-right-side-view
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author bingxin.chen
 * @date 2019/8/2 12:28
 */
public class LeetCode199 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        private List<Integer> res = new ArrayList<>();

        public List<Integer> rightSideView(TreeNode root) {
            // dfs 先遍历右边
            dfs(root, 1);
            return res;
        }

        public void dfs(TreeNode root, int i) {
            if (root == null) {
                return;
            }

            if (res.size() < i) {
                res.add(root.val);
            }

            dfs(root.right, i + 1);
            dfs(root.left, i + 1);
        }
    }
}
