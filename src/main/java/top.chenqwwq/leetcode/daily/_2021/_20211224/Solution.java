package top.chenqwwq.leetcode.daily._2021._20211224;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author chenbingxin
 * @date 2021/12/24
 **/
public class Solution {
    public int eatenApples(int[] apples, int[] days) {
        // 贪心,吃最快腐烂的
        final int n = apples.length;
        int ans = 0,time = 0;;
        final PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        while (time < n || !queue.isEmpty()) {
            if (time < n && apples[time] > 0) {
                queue.add(new int[]{time + days[time] - 1, apples[time]});
            }
            while (!queue.isEmpty() && queue.peek()[0] < time) {
                queue.poll();
            }
            if (!queue.isEmpty()) {
                final int[] tar = queue.poll();
                if(--tar[1] > 0 && tar[0]>time){
                    queue.add(tar);
                }
                ans++;
            }
            time++;
        }
        return ans;
    }
}
