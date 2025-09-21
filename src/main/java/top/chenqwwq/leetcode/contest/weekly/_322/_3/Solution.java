package top.chenqwwq.leetcode.contest.weekly._322._3;


import java.util.*;

/**
 * @author chenqwwq
 * @date 2022/12/8
 **/
public class Solution {

    static class Pair {
        int cur, min;

        public Pair(int a, int b) {
            this.cur = a;
            this.min = b;
        }

        public static Pair of(int a, int b) {
            return new Pair(a, b);
        }
    }

    int n;
    Map<Integer, Map<Integer, Integer>> map;

    public int minScore(int n, int[][] roads) {
        // construct map
        this.n = n;
        this.map = new HashMap<>();
        for (int[] road : roads) {
            if (!map.containsKey(road[0])) map.put(road[0], new HashMap<>());
            if (!map.containsKey(road[1])) map.put(road[1], new HashMap<>());
            map.get(road[0]).put(road[1], road[2]);
            map.get(road[1]).put(road[0], road[2]);
        }


        return Math.min(getMinRoad(1), getMinRoad(n));
    }


    public int getMinRoad(int start) {
        boolean[] exist = new boolean[n + 1];
        exist[start] = true;
        Deque<Pair> queue = new LinkedList<>();
        int ans = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> next : map.get(start).entrySet()) {
            queue.addLast(Pair.of(next.getKey(), next.getValue()));
            exist[next.getKey()] = true;
        }
        while (!queue.isEmpty()) {
            final Pair poll = queue.pollFirst();
            ans = Math.min(ans, poll.min);
            final Map<Integer, Integer> nexts = map.get(poll.cur);
            if (nexts == null) continue;
            for (Map.Entry<Integer, Integer> next : nexts.entrySet()) {
                if (exist[next.getKey()]) continue;
                exist[next.getKey()] = true;
                queue.addLast(Pair.of(next.getKey(), Math.min(next.getValue(), poll.min)));
            }
        }
        return ans;
    }
}



















