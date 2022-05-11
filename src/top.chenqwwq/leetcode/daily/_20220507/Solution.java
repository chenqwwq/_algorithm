package top.chenqwwq.leetcode.daily._20220507;

import sun.awt.image.ImageWatched;

import java.util.*;

/**
 * @author chenqwwq
 * @date 2022/5/7
 **/
public class Solution {
    private boolean isConn(String s1, String s2) {
        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                cnt++;
            }
        }
        return cnt < 2;
    }

    Map<String, Set<String>> graph = new HashMap<>();

    public void add(String start, String[] bank) {
        for (String s : bank) {
            if (start.equals(s)) {
                continue;
            }
            if (isConn(start, s)) {
                Set<String> l1 = graph.getOrDefault(start, new HashSet<>()),
                        l2 = graph.getOrDefault(s, new HashSet<>());
                l1.add(s);
                graph.put(start, l1);
                l2.add(start);
                graph.put(s, l2);
            }
        }
    }

    public int minMutation(String start, String end, String[] bank) {
        boolean exist = false;
        for (String b : bank) {
            if (b.equals(end)) {
                exist = true;
                break;
            }
        }
        if (!exist) {
            return -1;
        }
        add(start, bank);
        for (String b : bank) {
            add(b, bank);
        }

        Deque<String> dq = new LinkedList<>();
        Set<String> vis = new HashSet<>();
        dq.push(start);
        vis.add(start);
        int level = 0;

        while (!dq.isEmpty()) {
            level++;
            int size = dq.size();
            while (size-- > 0) {
                String cur = dq.removeFirst();
                for (String next : graph.getOrDefault(cur, new HashSet<>())) {
                    if (next.equals(end)) {
                        return level;
                    }
                    if (vis.contains(next)) {
                        continue;
                    }
                    dq.addLast(next);
                    vis.add(next);
                }
            }
        }
        return -1;
    }
}
