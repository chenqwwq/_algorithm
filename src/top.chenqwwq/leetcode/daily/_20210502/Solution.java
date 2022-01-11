package top.chenqwwq.leetcode.daily._20210502;

import java.util.*;

/**
 * @author chen
 * @date 2021/5/2
 **/
public class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        // 保存每列和边缘计数
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < wall.size(); i++) {
            final List<Integer> wal = wall.get(i);
            int curr = wal.get(0);
            if (wal.size() != 1) {
                for (int j = 1; j < wal.size(); j++) {
                    hash.put(curr, hash.getOrDefault(curr, 0) + 1);
                    curr += wal.get(j);
                }
            }
        }


        int minCnt = 0;
        for (int i : hash.keySet()) {
            final Integer spaceCnt = hash.getOrDefault(i, 0);
            if (spaceCnt > minCnt) {
                minCnt = spaceCnt;
            }
        }
        return wall.size() - minCnt;
    }
}
