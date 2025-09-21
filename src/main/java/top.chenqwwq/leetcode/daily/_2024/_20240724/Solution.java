package top.chenqwwq.leetcode.daily._2024._20240724;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenqwwq
 * @date 2024/7/24
 **/
public class Solution {

    public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
        final int n = moveFrom.length;
        Map<Integer, Boolean> vis = new HashMap<>();
        for (int idx : nums) vis.put(idx, true);
        for (int i = 0; i < n; i++) {
            if (vis.getOrDefault(moveFrom[i], false)) {
                vis.put(moveFrom[i], false);
                vis.put(moveTo[i], true);
            }
        }
        final List<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer, Boolean> entry : vis.entrySet()) {
            if (entry.getValue()) {
                ans.add(entry.getKey());
            }
        }
        ans.sort(Integer::compare);
        return ans;
    }
}