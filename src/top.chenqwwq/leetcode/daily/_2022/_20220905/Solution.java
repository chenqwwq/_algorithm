package top.chenqwwq.leetcode.daily._2022._20220905;

import top.chenqwwq.leetcode.common.TreeNode;

import java.util.*;

/**
 * @author chenqwwq
 * @date 2022/9/5
 **/
public class Solution {
    Map<Integer, List<TreeNode>> map = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if (root == null) {
            return null;
        }

        dfs(root);
        List<TreeNode> ans = new ArrayList<>();
        for(Integer key : map.keySet()){
            List<TreeNode> nodes = map.get(key);
            int n = nodes.size();
            for(int i = 0; i < n;i++){
                for(int j = i+1;j < n;j++){
                    if(dfs(nodes.get(i),nodes.get(j))){
                        ans.add(nodes.get(i));
                    }
                }
            }
        }
        return ans;
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }

        List<TreeNode> list = map.getOrDefault(node.val, new ArrayList<>());
        list.add(node);
        map.put(node.val, list);
        dfs(node.left);
        dfs(node.right);
    }

    public boolean dfs(TreeNode src, TreeNode target) {
        if (src == null && target == null) {
            return true;
        }
        if (src == null || target == null) {
            return false;
        }
        if (src.val != target.val) {
            return false;
        }

        return dfs(src.left, target.left) && dfs(src.right, target.right);
    }

}