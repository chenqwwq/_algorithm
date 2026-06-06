package top.chenqwwq.leetcode.daily._2024._20240312;

import top.chenqwwq.leetcode.common.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chenqwwq
 * @date 2024/3/12
 **/
public class FindElements {
     Set<Integer> set = new HashSet<>();

    public FindElements(TreeNode root) {
        root.val = 0;
        recover(root);
    }

    private void recover(TreeNode node) {
        if (node == null) return;
        set.add(node.val);
        if (node.left != null){
            node.left.val = node.val * 2 + 1;
            recover(node.left);
        }
        if (node.right != null) {
            node.right.val = node.val * 2 + 2;
            recover(node.right);
        }
    }

    public boolean find(int target) {
        return set.contains(target);
    }
}