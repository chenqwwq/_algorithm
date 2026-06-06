package top.chenqwwq.leetcode.daily._2026._20260517;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author chenqwwq
 * @date 2026/5/17
 **/
public class Solution {

    public boolean canReach(int[] arr, int start) {
        final int n = arr.length;
        boolean[] visited = new boolean[n];

        final Deque<Integer> stack = new LinkedList<>();
        stack.push(start);
        visited[start] = true;
        while (!stack.isEmpty()) {
            int idx = stack.pollFirst();      // 弹出第一个
            if (arr[idx] == 0) return true;
            visited[idx] = true;

            int left = idx - arr[idx];
            if (left >= 0 && !visited[left]) stack.push(left);

            int right = idx + arr[idx];
            if (right < n && !visited[right]) stack.push(right);
        }
        return false;
    }
}