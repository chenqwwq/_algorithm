package top.chenqwwq.leetcode.contest.weekly._474._1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenqwwq
 * @date 2025/11/2
 **/
public class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        boolean[] exist = new boolean[101];
        for (int num : nums) {
            exist[num] = true;
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            if (!exist[i]) {
                ans.add(i);
            }
        }
        return ans;
    }
}