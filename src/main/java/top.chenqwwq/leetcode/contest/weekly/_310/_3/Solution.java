package top.chenqwwq.leetcode.contest.weekly._310._3;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @author chenqwwq
 * @date 2022/9/11
 **/
public class Solution {
    public int minGroups(int[][] intervals) {
        TreeMap<Integer, PriorityQueue<Integer>> tree = new TreeMap<>();
        for (int[] interval : intervals) {
            if(!tree.containsKey(interval[0])){
                tree.put(interval[0],new PriorityQueue<>());
            }
            tree.get(interval[0]).add(interval[1]);
        }
        int cnt = 0;
        while (!tree.isEmpty()){
            cnt++;
            Map.Entry<Integer, PriorityQueue<Integer>> entry;
            int val = 0;
            while ((entry = tree.higherEntry(val)) != null){
                PriorityQueue<Integer> queue = entry.getValue();
                val = queue.poll();
                if(queue.isEmpty()) {
                    tree.remove(entry.getKey());
                }
            }
        }
        return cnt;
    }
}