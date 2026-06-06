package top.chenqwwq.leetcode.daily._2023._20231202;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author chenqwwq
 * @date 2023/12/2
 **/
public class Solution {

    // 因为本题的数据范围较小，所以可以使用桶排的方式
    private static final int N = (int) 1e5 + 9;

    public boolean carPooling(int[][] trips, int capacity) {
        int n = 0;
        for(int[] trip : trips){
            n = Math.max(n,trip[2]);
        }

        int[] arr = new int[n+1];
        for (int[] trip : trips) {
            arr[trip[1]] += trip[0];
            arr[trip[2]] -= trip[0];
        }

        int cur = 0;
        for (int i = 0; i <= n; i++) {
            if((cur += arr[i]) > capacity) return false;
        }
        return true;
    }

    // 优先级队列
//    public boolean carPooling(int[][] trips, int capacity) {
//        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
//        Arrays.sort(trips, Comparator.comparing(o -> o[1]));
//        int cur = 0;
//        for (int[] trip : trips) {
//            while (!queue.isEmpty() && queue.peek()[0] <= trip[1]) {
//                final int[] poll = queue.poll();
//                cur -= poll[1];
//            }
//            if ((cur += trip[0]) > capacity) return false;
//            queue.add(new int[]{trip[2], trip[0]});
//        }
//        return true;
//    }
}
