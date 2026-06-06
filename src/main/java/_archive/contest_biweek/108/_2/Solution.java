package top.chenqwwq.leetcode.contest.biweek._108._2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author chenqwwq
 * @date 2023/7/8
 **/
public class Solution {
    public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
        final int n = moveTo.length;
        Set<Integer> vis = new HashSet<>();
        for (int num : nums) vis.add(num);
        for (int i = 0; i < n; i++) {
            if(vis.remove(moveFrom[i])){
                vis.add(moveTo[i]);
            }
        }

        List<Integer> ans = new ArrayList<>(vis);
        ans.sort(Integer::compare);
        return ans;
    }
}