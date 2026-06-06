package top.chenqwwq.leetcode.daily._2022._20220822;

import top.chenqwwq.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author chenqwwq
 * @date 2022/8/22
 **/
public class Solution {
    int m, n;

    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> ans = new ArrayList<>();
        m = getHeight(root);
        n = (int) Math.pow(2, m) - 1;
        for (int i = 0; i < m; i++) {
            ans.add(new ArrayList<>(n));
            for (int j = 0; j < n; j++) {
                ans.get(i).add(j, "");
            }
        }
        dfs(ans,0,(n-1) >> 1,root);
        return ans;

    }

    private void dfs(List<List<String>> ans, int x, int y, TreeNode node) {
        if (node == null) return;
        ans.get(x).set(y, String.valueOf(node.val));
        dfs(ans, x + 1, y - (int) Math.pow(2, m-1 - x - 1), node.left);
        dfs(ans, x + 1, y + (int) Math.pow(2, m-1 - x - 1), node.right);
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1,new TreeNode(2),null);
        new Solution().printTree(node);
    }
}