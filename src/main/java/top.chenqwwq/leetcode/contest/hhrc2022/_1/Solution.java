package top.chenqwwq.leetcode.contest.hhrc2022._1;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author chenqwwq
 * @date 2022/10/3
 **/
public class Solution {
    public int lastMaterial(int[] material) {
        final int n = material.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int m : material) pq.add(m);
        while (pq.size() >= 2) {
            pq.add(Math.abs(pq.poll() - pq.poll()));
        }
        return pq.poll();
    }
}