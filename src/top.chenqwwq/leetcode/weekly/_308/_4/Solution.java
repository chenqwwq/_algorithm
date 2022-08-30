package top.chenqwwq.leetcode.weekly._308._4;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author chenqwwq
 * @date 2022/8/28
 **/
public class Solution {
    public int[][] buildMatrix(int k, int[][] rows, int[][] cols) {
        int[] h1 = handle(k + 1, rows);
        if (h1 == null) return new int[][]{};
        int[] h2 = handle(k + 1, cols);
        if (h2 == null) return new int[][]{};
        int[][] ans = new int[k][k];
        for (int i = 1; i <= k; i++) {
            ans[h1[i] - 1][h2[i] - 1] = i;
        }
        return ans;
    }

    private  int[] handle(int k, int[][] rows) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] degree = new int[k];
        for (int[] row : rows) {
            List<Integer> list = map.getOrDefault(row[0], new ArrayList<>());
            list.add(row[1]);
            map.put(row[0], list);
            degree[row[1]]++;
        }

        // 节点和其深度
        Deque<Integer> deque = new LinkedList<>();
        // 从入度为0的节点开始遍历
        for (int i = 1; i < k; i++) {
            if (degree[i] == 0) {
                deque.add(i);
            }
        }
        int[] ret = new int[k];
        int p = 0;
        while (!deque.isEmpty()){
            int cur = deque.pollFirst();
            ret[cur] = p++;
            for(int next : map.getOrDefault(cur,new ArrayList<>())){
                if(--degree[next]==0) deque.addLast(next);
            }
        }

        if(p != k) return null;
        return ret;
    }
}