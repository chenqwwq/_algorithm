package top.chenqwwq.leetcode.contest.biweek._84._1;

import java.util.*;

/**
 * @author chenqwwq
 * @date 2022/8/7
 **/
public class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] item : items1) {
            map.put(item[0], map.getOrDefault(item[0], 0) + item[1]);
        }
        for (int[] item : items2) {
            map.put(item[0], map.getOrDefault(item[0], 0) + item[1]);
        }
        ArrayList<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());
        entries.sort(Comparator.comparingInt(Map.Entry::getKey));
        List<List<Integer>> ans = new ArrayList<>(entries.size());
        for(Map.Entry<Integer, Integer> entry : entries){
            List<Integer> list = new ArrayList<>();
            list.add(entry.getKey());
            list.add(entry.getValue());
            ans.add(list);
        }
        return ans;
    }
}