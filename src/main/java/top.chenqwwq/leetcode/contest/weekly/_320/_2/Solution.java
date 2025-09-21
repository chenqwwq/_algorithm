package top.chenqwwq.leetcode.contest.weekly._320._2;

import top.chenqwwq.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * @author chenqwwq
 * @date 2022/11/20
 **/
public class Solution {

    public static void main(String[] args) {
        TreeNode left = new TreeNode(2, new TreeNode(1), new TreeNode(4));
        TreeNode right = new TreeNode(13, new TreeNode(9), new TreeNode(15,
                new TreeNode(14), null));
        new Solution().closestNodes(new TreeNode(6, left, right),List.of(2,5,16));
    }

    List<Integer> vals;

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        final int n = queries.size();
        // 先获取到树的全部节点值
        vals = new ArrayList<>();
        dfs(root);
        List<List<Integer>> ans = new ArrayList<>();
        for (Integer query : queries) {
            ans.add(List.of(floor(query), ceiling(query)));
        }
        return ans;
    }

    int ceiling(int val) {
        // 找大于等于 val 的
        int l = 0, r = vals.size() - 1;
        while (l < r) {
            final int mid = (l + r) >> 1;
            final Integer num = vals.get(mid);
            if (num < val) l = mid + 1;
            else r = mid;
        }
        return vals.get(l) >= val ? vals.get(l) : -1;
    }

    int floor(int val) {
        // 找小于等于 val 的
        int l = 0, r = vals.size() - 1;
        while (l < r) {
            final int mid = (l + r + 1) >> 1;
            if (vals.get(mid) > val) r = mid - 1;
            else l = mid;
        }
        return vals.get(r) <= val ? vals.get(r) : -1;
    }

    void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.left);
        vals.add(node.val);
        dfs(node.right);
    }
}