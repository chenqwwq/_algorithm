package top.chenqwwq.leetcode.contest.biweek._111._1;

import java.util.List;

/**
 * @author chenqwwq
 * @date 2023/8/22
 **/
public class Solution {
    public int countPairs(List<Integer> nums, int target) {
        final int n = nums.size();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            final int n1 = nums.get(i);
            for (int j = i + 1; j < n; j++) {
               final int n2 = nums.get(j);
               if(n1 + n2 < target) cnt++;
            }
        }
        return cnt;
    }
}