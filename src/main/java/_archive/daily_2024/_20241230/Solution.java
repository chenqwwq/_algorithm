package top.chenqwwq.leetcode.daily._2024._20241230;

import ch.qos.logback.core.status.OnConsoleStatusListener;
import top.chenqwwq.leetcode.common.ListNode;
import top.chenqwwq.leetcode.common.TreeNode;

import java.util.Objects;

/**
 * @author chenqwwq
 * @date 2024/12/30
 **/
public class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        return isSubPath(head, root, true);
    }

    public boolean isSubPath(ListNode head, TreeNode root, boolean isHead) {
        if (head == null) return true;
        if (root == null) return false;
        if(isHead && (isSubPath(head, root.left,true) || isSubPath(head, root.right,true))) return true;
        if (head.val == root.val) return isSubPath(head.next, root.left, false) || isSubPath(head.next, root.right, false);
        return false;
    }
}