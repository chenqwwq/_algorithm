package top.chenqwwq.leetcode.contest.weekly._367._2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenqwwq
 * @date 2023/8/6
 **/
public class Solution {
    public boolean canSplitArray(List<Integer> nums, int m) {
        final int n = nums.size();
        if (n <= 2) return true;

        int sum = 0;
        for (int num : nums) sum += num;
        return f(nums, sum, m, 0, n - 1);
    }

    Map<Integer,Boolean> memo = new HashMap<>();

    public boolean f(List<Integer> nums, int sum, int m, int l, int r) {
        if(r == l) return true;
        if (r < l || (sum < m && r - l > 0)) return false;
        int flag = l << 16 | r;
        if(memo.containsKey(flag)) return memo.get(flag);
        final boolean res = f(nums, sum - nums.get(l), m, l + 1, r) || f(nums, sum - nums.get(r), m, l, r - 1);
        memo.put(flag,res);
        return res;
    }
}