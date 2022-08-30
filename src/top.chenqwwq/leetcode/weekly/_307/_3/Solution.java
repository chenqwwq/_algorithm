package top.chenqwwq.leetcode.weekly._307._3;

import top.chenqwwq.leetcode.common.TreeNode;

import java.util.*;

/**
 * @author chenqwwq
 * @date 2022/8/21
 **/
public class Solution {
    Map<Integer, List<Integer>> map;

    public int amountOfTime(TreeNode root, int start) {
        map = new HashMap<>();
        dfs(root);
        Deque<Integer> deque = new LinkedList<>();
        Set<Integer> vis = new HashSet<>();
        deque.push(start);
        vis.add(start);
        int ans = 0;
        while (!deque.isEmpty()) {
            ans++;
            int size = deque.size();
            for(int i = 0;i < size;i++) {
                Integer poll = deque.pollFirst();
                for (Integer next : map.getOrDefault(poll, new ArrayList<>())) {
                    if (vis.contains(next)) {
                        continue;
                    }
                    deque.addLast(next);
                    vis.add(next);
                }
            }
        }
        return ans;
    }

    private void add(int v1, int v2) {
        List<Integer> l1 = map.getOrDefault(v1, new ArrayList<>());
        l1.add(v2);
        map.put(v1, l1);

        List<Integer> l2 = map.getOrDefault(v2, new ArrayList<>());
        l2.add(v1);
        map.put(v2, l2);
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            add(node.val, node.left.val);
            dfs(node.left);
        }
        if (node.right != null) {
            add(node.val, node.right.val);
            dfs(node.right);
        }
    }
}