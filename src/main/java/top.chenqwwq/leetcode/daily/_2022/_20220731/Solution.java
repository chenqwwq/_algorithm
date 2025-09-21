package top.chenqwwq.leetcode.daily._2022._20220731;

import top.chenqwwq.leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenqwwq
 * @date 2022/7/31
 **/
public class Solution {
    private Map<Integer, Long> map ;

    public int maxLevelSum(TreeNode root) {
        map = new HashMap<>();
        dfs(root, 1);
        long max = Long.MIN_VALUE;
        int ans = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Long> entry : map.entrySet()) {
            if (entry.getValue() > max || (entry.getValue() == max && entry.getKey() < ans)) {
                ans = entry.getKey();
                max = entry.getValue();
            }
        }
        return ans;
    }

    private void dfs(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        map.put(level, map.getOrDefault(level, 0L) + node.val);
        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }
}