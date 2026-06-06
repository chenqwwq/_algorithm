package com.xhtech.app.response.sharding.id;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author chen
 * @date 2022-02-16
 **/
public class Solution {
    int n;
    int[] cx = new int[]{-2, -1, 1, 2, 2, 1, -1, -2},
            cy = new int[]{1, 2, 2, 1, -1, -2, -2, -1};

    public double knightProbability(int _n, int k, int row, int column) {
        this.n = _n;
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Double> hash = new HashMap<>();
        final Integer m1 = getMask(row, column);
        queue.add(m1);
        hash.put(m1, 1d);
        int q = k;

        while (q-- > 0 && !queue.isEmpty()) {
            int size = queue.size();
            Map<Integer, Double> tmp = new HashMap<>();
            for (int i = 0; i < size; i++) {
                final Integer poll = queue.poll();
                final int x = getX(poll), y = getY(poll);
                for (int j = 0; j < 8; j++) {
                    int a = x + cx[j], b = y + cy[j];
                    if (a < 0 || b < 0 || a >= n || b >= n) {
                        continue;
                    }
                    int mask = getMask(a, b);
                    if (!tmp.containsKey(mask)) {
                        queue.add(mask);
                    }
                    tmp.put(mask, tmp.getOrDefault(mask, 0d) + hash.get(poll));
                }
            }
            hash = tmp;
        }

        if (q > 0) {
            return 0d;
        }
        double sum = 0;
        for (double val : hash.values()) {
            sum += val;
        }

        return sum / Math.pow(8, k);
    }

    private Integer getX(int num) {
        return num / n;
    }

    private Integer getY(int num) {
        return num % n;
    }

    private Integer getMask(int x, int y) {
        return x * n + y;
    }

    public static void main(String[] args) {
        new Solution().knightProbability(8, 30, 6, 4);
    }
}



































