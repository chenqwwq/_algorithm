package top.chenqwwq.leetcode.weekly._309._4;

import java.util.*;

/**
 * @author chenqwwq
 * @date 2022/9/4
 **/
public class Solution {
    public int mostBooked(int n, int[][] meetings) {
        final int m = meetings.length;
        int[] room = new int[n];
        // 会议室 : 结束时间
        PriorityQueue<Long[]> inUse = new PriorityQueue<>(Comparator.comparingLong(o -> o[1]));
        TreeSet<Integer> ready = new TreeSet<>();
        for (int i = 0; i < n; i++) ready.add(i);

        // 按照开始时间排序
        Arrays.sort(meetings, Comparator.comparingInt(o -> o[0]));
        long time = 0;

        for (int i = 0; i < m; i++) {
            int start = meetings[i][0], end = meetings[i][1];
            time = Math.max(time, start);
            while (!inUse.isEmpty() && inUse.peek()[1] <= time) {
                ready.add((inUse.poll()[0]).intValue());
            }
            if (ready.isEmpty() && !inUse.isEmpty()) {
                Long[] finish = inUse.poll();
                ready.add(finish[0].intValue());
                time = finish[1];
                while (!inUse.isEmpty() && inUse.peek()[1] <= time) {
                    Long[] tmp = inUse.poll();
                    ready.add(tmp[0].intValue());
                }
            }
            Integer id = ready.pollFirst();
            room[id]++;
            inUse.add(new Long[]{Long.valueOf(id), (long) end - start + time});
        }
        int ans = 0, max = -1;
        for (int i = 0; i < n; i++) {
            if (room[i] > max) {
                max = room[i];
                ans = i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        new Solution().mostBooked(2, new int[][]{{0, 10}, {1, 5}, {2, 7}, {3, 4}});
    }
}