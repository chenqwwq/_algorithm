package top.chenqwwq.leetcode.contest.weekly._418._2;

import java.util.*;

/**
 * @author chenqwwq
 * @date 2024/10/6
 **/
public class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        // 建图
        final Map<Integer, List<Integer>> graph = new HashMap<>();
        final int[] id = new int[n];
        for (int[] in : invocations) {
            final List<Integer> list = graph.getOrDefault(in[0], new ArrayList<>());
            list.add(in[1]);
            graph.put(in[0], list);
            id[in[1]]++;
        }

        // 获取可疑组
        final Queue<Integer> q = new LinkedList<>();
        q.add(k);
        final Set<Integer> sus = new HashSet<>();
        boolean[] vis = new boolean[n];
        vis[k] = true;
        sus.add(k);
        while (!q.isEmpty()) {
            final Integer p = q.poll();
            for (int next : graph.getOrDefault(p, Collections.emptyList())) {
                --id[next];
                if (vis[next]) continue;
                vis[next] = true;
                sus.add(next);
                q.add(next);
            }
        }

        // 判断是否需要删除
        boolean flag = true;
        for (Integer p : sus) {
            if (id[p] > 0) {
                flag = false;
                break;
            }
        }

        final List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!flag || !sus.contains(i)) {
                ans.add(i);
            }
        }
        return ans;
    }
}