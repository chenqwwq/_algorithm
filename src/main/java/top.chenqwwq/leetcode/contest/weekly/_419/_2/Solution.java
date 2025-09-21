package top.chenqwwq.leetcode.contest.weekly._419._2;

import top.chenqwwq.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenqwwq
 * @date 2024/10/13
 **/
public class Solution {

    public int kthLargestPerfectSubtree(TreeNode root, int k) {
        final List<Integer> ss = new ArrayList<>();
        h(ss,root);
        if(ss.size() < k) return -1;
        ss.sort((o1, o2) -> Integer.compare(o2, o1));
        return ss.get(k-1);
    }
    final int inf = 0x3f3f3f3f;

    public int h(List<Integer> ss, TreeNode node) {
        if (node == null) return 0;
        final int l = h(ss, node.left), r = h(ss, node.right);
        if(r == inf || l != r) return inf;
        final int s = l + r + 1;
        ss.add(s);
        return s;
    }
}