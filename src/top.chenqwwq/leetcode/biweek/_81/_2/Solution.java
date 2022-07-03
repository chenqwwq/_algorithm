package top.chenqwwq.leetcode.biweek._81._2;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLExtensible;

import java.util.*;

/**
 * @author chenqwwq
 * @date 2022/6/26
 **/
public class Solution {
    public long countPairs(int n, int[][] edges) {
        final int m = edges.length;

        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            final int a = edge[0], b = edge[1];
            Set<Integer> s1 = graph.getOrDefault(a, new HashSet<>());
            s1.add(b);
            graph.put(a, s1);

            Set<Integer> s2 = graph.getOrDefault(b, new HashSet<>());
            s2.add(a);
            graph.put(b, s2);
        }

        boolean[] vis = new boolean[n];
        Deque<Integer> deque = new LinkedList<>();
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (vis[i]) {
                continue;
            }
            vis[i] = true;
            deque.push(i);
            int cnt = 0;
            while (!deque.isEmpty()) {
                cnt++;
                Integer cur = deque.pollFirst();
                for (Integer next : graph.getOrDefault(cur, new HashSet<>())) {
                    if (vis[next]) {
                        continue;
                    }
                    deque.addLast(next);
                    vis[next] = true;
                }
            }
            nums.add(cnt);
        }
        long ans = 0;
        for (int num : nums) {
            ans += ((long) num * (n - num));
        }
        return ans >> 1;
    }
}