package top.chenqwwq.leetcode.daily._20220624;

import top.chenqwwq.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 沽酒
 * @date 2022/06/24
 */
public class Solution {
    Map<Integer, Integer> map = new HashMap<>();

    public List<Integer> largestValues(TreeNode root) {
        dfs(root, 0);
        Integer num;
        final List<Integer> ans = new ArrayList<>();
        for (int i = 0;i < 0x3f3f3f3f;i++){
            if((num = map.get(i)) == null){
                break;
            }
            ans.add(num);
        }
        return ans;
    }

    private void dfs(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        if (!map.containsKey(level) ||  node.val > map.get(level)) {
            map.put(level, node.val);
        }
        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }
}