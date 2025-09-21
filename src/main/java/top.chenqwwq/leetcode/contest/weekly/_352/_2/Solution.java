package top.chenqwwq.leetcode.contest.weekly._352._2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author chenqwwq
 * @date 2023/7/2
 **/
public class Solution {

    static Set<Integer> vis = new HashSet<>();

    static final int n = (int) 1e6;

    static {
        vis.add(2);
        for (int i = 3; i <= n; i += 2) {
            boolean ok = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if(i % j == 0) {
                    ok = false;
                    break;
                }
            }
            if(ok) vis.add(i);
        }
    }

    public List<List<Integer>> findPrimePairs(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i <= n >> 1; i++) {
            if (!vis.contains(i) || !vis.contains(n - i)) continue;
            ans.add(List.of(i, n - i));
        }
        return ans;
    }
}