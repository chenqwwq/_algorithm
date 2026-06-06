package top.chenqwwq.leetcode.daily._2023._20230706;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenqwwq
 * @date 2023/7/7
 **/
public class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        if ((finalSum & 1) == 1) return List.of();
        List<Long> ans = new ArrayList<>();
        for (long cur = 2; cur <= finalSum; finalSum -= cur, cur += 2) {
            ans.add(cur);
        }
        ans.set(ans.size() - 1, ans.get(ans.size() - 1) + finalSum);
        return ans;
    }

}