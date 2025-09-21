package top.chenqwwq.leetcode.contest.weekly._249._3;

import java.util.*;

/**
 * @author chen
 * @date 2021/7/11
 **/
public class Solution {

    private final int mod = (int) 1e9 + 7;

    public int colorTheGrid(int m, int n) {
        int pow = (int) Math.pow(3, m);
        Map<Integer, Integer[]> valid = new HashMap<>();
        for (int i = 0; i < pow; i++) {
            int num = i;
            Integer[] cur = new Integer[m];
            boolean ok = true;
            for (int j = 0; j < m; j++) {
                cur[j] = num % 3;
                if (j > 0 && Objects.equals(cur[j], cur[j - 1])) {
                    ok = false;
                    break;
                }
                num /= 3;
            }
            if (ok) {
                valid.put(i, cur);
            }
        }
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        for (Map.Entry<Integer, Integer[]> e1 : valid.entrySet()) {
            for (Map.Entry<Integer, Integer[]> e2 : valid.entrySet()) {
                if (Objects.equals(e1.getKey(), e2.getKey())) {
                    continue;
                }
                boolean ok = true;
                Integer[] v1 = e1.getValue(), v2 = e2.getValue();
                for (int i = 0; i < m; i++) {
                    if (Objects.equals(v1[i], v2[i])) {
                        ok = false;
                        break;
                    }
                }
                if (ok) {
                    Set<Integer> orDefault = adj.getOrDefault(e1.getKey(), new HashSet<>());
                    orDefault.add(e2.getKey());
                    adj.put(e1.getKey(), orDefault);
                }
            }
        }
        long[] ans = new long[pow], tmp = new long[pow];
        for (Integer key : valid.keySet()) {
            ans[key] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (Integer key : valid.keySet()) {
                for (Integer next : adj.getOrDefault(key, new HashSet<>())) {
                    tmp[key] = (tmp[key] + ans[next]) % mod;
                }
            }
            for (int j = 0; j < pow; j++) {
                ans[j] = tmp[j];
                tmp[j] = 0;
            }
        }
        long ret = 0;
        for (long num : ans) {
            ret = (ret + num) % mod;
        }
        return (int) ret;
    }
}