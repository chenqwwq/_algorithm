package top.chenqwwq.leetcode.contest.weekly._489._1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author chenqwwq
 * @date 2026/2/15
 **/
public class Solution {
    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        final Map<Integer, Long> collect = bulbs.stream().collect(Collectors.groupingBy(o -> o, Collectors.counting()));
        List<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer, Long> entry : collect.entrySet()) {
            if ((entry.getValue() & 1) == 1) {
                ans.add(entry.getKey());
            }
        }
        ans.sort(Integer::compare);
        return ans;
    }
}