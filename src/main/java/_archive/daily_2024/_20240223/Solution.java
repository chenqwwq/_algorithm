package top.chenqwwq.leetcode.daily._2024._20240223;

import top.chenqwwq.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chenqwwq
 * @date 2024/2/23
 **/
public class Solution {

    Map<Integer, Long> map = new HashMap<>();

    public long kthLargestLevelSum(TreeNode root, int k) {
        dfs(root, 0);
        if (map.size() < k) return -1;
        final ArrayList<Long> nums = new ArrayList<>(map.values());
        nums.sort((o1, o2) -> Long.compare(o2, o1));
        return nums.get(k - 1);
    }

    private void dfs(TreeNode node, int l) {
        if (node == null) return;
        map.put(l, map.getOrDefault(l, 0L) + node.val);
        dfs(node.left, l + 1);
        dfs(node.right, l + 1);
    }
}