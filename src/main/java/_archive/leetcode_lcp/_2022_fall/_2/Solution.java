package top.chenqwwq.leetcode.lcp._2022_fall._2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author chenqwwq
 * @date 2022/9/24
 **/
public class Solution {
    public int transportationHub(int[][] path) {
        if (path == null || path.length == 0) return -1;
        Map<Integer, Set<Integer>> in = new HashMap<>();
        Set<Integer> cnt = new HashSet<>(),out = new HashSet<>();
        for (int[] p : path) {
            int o = p[0], i = p[1];
            Set<Integer> s1 = in.getOrDefault(i, new HashSet<>());
            s1.add(o);
            in.put(i, s1);
            out.add(o);
            cnt.add(o);
            cnt.add(i);
        }
        final int n = cnt.size();
        for (Map.Entry<Integer, Set<Integer>> entry : in.entrySet()) {
            if (entry.getValue().size() == n - 1 && !out.contains(entry.getKey())){
                return entry.getKey();
            }
        }
        return -1;
    }
}