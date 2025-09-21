package top.chenqwwq.leetcode.daily._2022._20220922;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenqwwq
 * @date 2022/9/22
 **/
public class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        final int n = arr.length;
        Map<Integer, int[]> map = new HashMap<>();
        for (int[] p : pieces) map.put(p[0], p);
        int i = 0;
        while (i < n){
            if(!map.containsKey(arr[i])) return false;
            int[] nums = map.get(arr[i]);
            int j = 0,m = nums.length;
            while (i < n && j < m){
                if(arr[i++] != nums[j++]) return false;
            }
            if(j != m) return false;
        }
        return i == n;
    }
}