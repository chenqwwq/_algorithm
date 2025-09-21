package top.chenqwwq.leetcode.contest.hhrc2022._3;

import top.chenqwwq.leetcode.common.TreeNode;

import java.util.*;

/**
 * @author chenqwwq
 * @date 2022/10/4
 **/
public class Solution {
    Map<String, TreeNode> map = new HashMap<>();
    Set<String> vis = new HashSet<>();
    List<TreeNode> ans = new ArrayList<>();

    public List<TreeNode> lightDistribution(TreeNode root) {
        dfs(root);
        return ans;
    }

    public String dfs(TreeNode node){
        if (node == null) return "@";
        String path = node.val +"-"+ dfs(node.left) +"-"+ dfs(node.right);
        if(map.containsKey(path) && !vis.contains(path)) {
            ans.add(node);
            vis.add(path);
        }
        if(!map.containsKey(path)) map.put(path,node);
        return path;
    }
}