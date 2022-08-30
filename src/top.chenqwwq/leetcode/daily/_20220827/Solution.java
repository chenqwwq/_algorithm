package top.chenqwwq.leetcode.daily._20220827;

import top.chenqwwq.leetcode.common.TreeNode;

import java.util.*;

/**
 * @author chenqwwq
 * @date 2022/8/27
 **/
public class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Deque<Map.Entry<Integer, TreeNode>> deque = new LinkedList<>();
        int ans = 0;
        deque.addLast(new AbstractMap.SimpleEntry<>(1, root));
        // bfs 逐层遍历
        while (!deque.isEmpty()) {
            // 如何统计单层
            int cur = deque.size();
            int l = -1, r = -1;
            while (cur-- > 0) {
                Map.Entry<Integer, TreeNode> e = deque.pollFirst();
                if (e.getValue() == null) continue;
                if (l == -1) l = r = e.getKey();
                else r = e.getKey();
                deque.addLast(new AbstractMap.SimpleEntry<>(e.getKey() << 1, e.getValue().left));
                deque.addLast(new AbstractMap.SimpleEntry<>(e.getKey() << 1 | 1, e.getValue().right));
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        new Solution().widthOfBinaryTree(new TreeNode(1,new TreeNode(3,new TreeNode(5),new TreeNode(3)),new TreeNode(2,null,new TreeNode(9))));
    }
}
