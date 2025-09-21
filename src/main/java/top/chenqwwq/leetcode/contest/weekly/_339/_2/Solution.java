package top.chenqwwq.leetcode.contest.weekly._339._2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenqwwq
 * @date 2023/4/2
 **/
public class Solution {
    int inf = 201;

    public List<List<Integer>> findMatrix(int[] nums) {
        int[] hash = new int[inf];
        int max = 0;
        for (int num : nums) {
            max = Math.max(++hash[num], max);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < max; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < inf; j++) {
                if (hash[j] > 0){
                    list.add(j);
                    hash[j]--;
                }
            }
            ans.add(list);
        }
        return ans;
    }
}