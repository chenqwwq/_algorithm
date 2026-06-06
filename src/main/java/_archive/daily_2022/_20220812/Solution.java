package top.chenqwwq.leetcode.daily._2022._20220812;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 沽酒
 * @since 2022/08/12
 */
public class Solution {
    public List<List<Integer>> groupThePeople(int[] nums) {
        final int n = nums.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            final List<Integer> list = map.getOrDefault(nums[i], new ArrayList<>());
            list.add(i);
            map.put(nums[i], list);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            final int cnt = entry.getKey();
            final List<Integer> us = entry.getValue();
            List<Integer> group = new ArrayList<>();
            int i = 0;
            while (i < us.size()) {
                group.add(us.get(i++));
                if (group.size() == cnt) {
                    ans.add(new ArrayList<>(group));
                    group = new ArrayList<>();
                }
            }
        }
        return ans;
    }
}