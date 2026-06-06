package top.chenqwwq.leetcode.daily._2023._20230714;

import top.chenqwwq.leetcode.common.TreeNode;

/**
 * @author 沽酒
 * @since 2023/07/14
 */
public class Solution {
    int ans = 0;

    public int distributeCoins(TreeNode root) {
        dfs(root);
        return ans;
    }

    public int dfs(TreeNode node) {
        if (node == null) return 0;
        final int left = dfs(node.left), right = dfs(node.right);
        final int sum = left + right + node.val;
        if (sum == 1) return 0;     // 相同表示不需要传递
        else if (sum > 1) ans += sum - 1; // 大于则需要向上传递
        else ans += 1 - sum;  // 小于表示需要上面补充
        return sum - 1;
    }
}