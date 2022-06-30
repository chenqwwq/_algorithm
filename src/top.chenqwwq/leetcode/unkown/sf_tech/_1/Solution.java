package top.chenqwwq.leetcode.unkown.sf_tech._1;

import java.util.*;

/**
 * @author 沽酒
 * @since 2022/06/30
 */
public class Solution {
    HashSet<Integer> EMPTY = new HashSet<>();

    public boolean hasCycle(String graph) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (String s : graph.split(",")) {
            String[] p = s.split("->");
            int a = Integer.parseInt(p[0]), b = Integer.parseInt(p[1]);
            Set<Integer> orDefault = map.getOrDefault(a, new HashSet<>());
            orDefault.add(b);
            map.put(a, orDefault);
        }

        for (int i = 0; i < 100; i++) {
            if (!map.containsKey(i)) {
                continue;
            }
            boolean[] vis = new boolean[100];
            vis[i] = true;
            Deque<Integer> deque = new LinkedList<>();
            deque.push(i);
            while (!deque.isEmpty()) {
                Integer pop = deque.pop();
                for (int next : map.getOrDefault(pop, EMPTY)) {
                    if(next == i){
                        return true;
                    }
                    if (vis[next]) {
                        continue;
                    }
                    deque.push(next);
                    vis[next] = true;
                }
            }
        }
        return false;
    }
}