package top.chenqwwq.leetcode.contest.weekly._226._2;

import java.util.*;

/**
 * @author chen
 * @date 2021/1/31
 **/
public class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        int len = adjacentPairs.length + 1;
        Map<Integer, List<Integer>> map = new HashMap<>(len);
        Map<Integer, Integer> count = new HashMap<>();
        for (int[] pair : adjacentPairs) {
            List<Integer> put = map.getOrDefault(pair[0], new ArrayList<>());
            put.add(pair[1]);
            map.put(pair[0], put);
            List<Integer> orDefault = map.getOrDefault(pair[1], new ArrayList<>());
            orDefault.add(pair[0]);
            map.put(pair[1], orDefault);

            if (null != count.putIfAbsent(pair[0], 1)) {
                count.remove(pair[0]);
            }

            if (null != count.putIfAbsent(pair[1], 1)) {
                count.remove(pair[1]);
            }
        }

        int start = count.keySet().stream().findAny().get();
        int[] ans = new int[len];
        ans[0] = start;
        ans[1] = map.get(ans[0]).get(0);
        for (int i = 2; i < len; i++) {
            List<Integer> integers = map.get(ans[i - 1]);
            for (int j : integers) {
                if (j != ans[i - 2]) {
                    ans[i] = j;
                }
            }
        }
        return ans;
    }
}