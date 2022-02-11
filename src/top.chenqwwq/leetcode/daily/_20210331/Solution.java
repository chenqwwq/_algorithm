package top.chenqwwq.leetcode.daily._20210331;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 90. Subsets II
 * Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
 * <p>
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,2]
 * Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
 * Example 2:
 * <p>
 * Input: nums = [0]
 * Output: [[],[0]]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 *
 * @author chen
 * @date 2021-03-31
 **/
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums.length == 1) {
            return new ArrayList<List<Integer>>() {{
                add(new ArrayList<>());
                add(Collections.singletonList(nums[0]));
            }};
        }

        final ArrayList<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void backtrack(int[] nums, int idx, List<Integer> curr, List<List<Integer>> ans) {
        // 边界情况
        ans.add(new ArrayList<>(curr));
        for (int i = idx; i < nums.length; i++) {
            if (i != idx && nums[i] == nums[i - 1]) {
                continue;
            }
            curr.add(nums[i]);
            backtrack(nums, i + 1, curr, ans);
            curr.remove(curr.size() - 1);
        }
    }
}
