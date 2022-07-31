package top.chenqwwq.leetcode.biweek._38._1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chen
 * @date 2020/10/31
 **/
public class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        final ArrayList<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());
        entries.sort(Map.Entry.<Integer, Integer>comparingByValue().thenComparing((o1, o2) -> o2.getKey().compareTo(o1.getKey())));
        int i = 0;
        for(Map.Entry<Integer,Integer> entry : entries){
            int cnt = entry.getValue();
            while (cnt-->0){
                nums[i++] = entry.getKey();
            }
        }
        return nums;
    }
}