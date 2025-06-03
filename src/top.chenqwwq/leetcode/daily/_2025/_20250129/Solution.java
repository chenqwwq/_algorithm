package top.chenqwwq.leetcode.daily._2025._20250129;

import javax.swing.undo.AbstractUndoableEdit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenqwwq
 * @date 2025/1/29
 **/
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        final int n = nums.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            final List<Integer> list = map.getOrDefault(nums[i], new ArrayList<>());
            list.add(i);
            map.put(nums[i], list);
        }
        for (List<Integer> data : map.values()) {
            for (int i = 0; i < data.size() - 1; i++) {
                if (data.get(i + 1) - data.get(i) <= k) return true;
            }
        }
        return false;
    }
}