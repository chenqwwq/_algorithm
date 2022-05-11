package top.chenqwwq.leetcode.daily._20220501;

import com.sun.org.apache.xpath.internal.operations.String;
import top.chenqwwq.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenqwwq
 * @date 2022/5/1
 **/
public class Solution {
    private void inorder(TreeNode node, List<Integer> l) {
        if (node == null) {
            return;
        }
        inorder(node.left, l);
        l.add(node.val);
        inorder(node.right, l);
    }

    public List<Integer> getAllElements(TreeNode r1, TreeNode r2) {
        List<Integer> l1 = new ArrayList<>(), l2 = new ArrayList<>(), ans = new ArrayList<>();
        inorder(r1, l1);
        inorder(r2, l2);
        int i = 0, j = 0;
        while (i < l1.size() && j < l2.size()) {
            if (l1.get(i) < l2.get(j)) {
                ans.add(l1.get(i++));
            } else {
                ans.add(l2.get(j++));
            }
        }
        while (i < l1.size()) {
            ans.add(l1.get(i++));
        }
        while (j < l2.size()) {
            ans.add(l2.get(j++));
        }

        return ans;
    }
}