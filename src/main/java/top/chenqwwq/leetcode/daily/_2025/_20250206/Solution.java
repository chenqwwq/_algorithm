package top.chenqwwq.leetcode.daily._2025._20250206;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenqwwq
 * @date 2025/2/6
 **/
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        ans = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] vis = new boolean[nums.length];
        dfs(nums, 0, new ArrayList<>());
        return ans;
    }


    List<List<Integer>> ans;

    private void dfs(int[] nums, int cnt, List<Integer> cur) {
        if (cnt == nums.length) {
            ans.add(new ArrayList<>(cur));
            return;
        }

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == -11 || (j > 0 && nums[j] == nums[j - 1])) continue;
            int num = nums[j];
            cur.add(num);
            nums[j] = -11;
            dfs(nums, cnt + 1, cur);
            cur.remove(cur.size() - 1);
            nums[j] = num;
        }
    }
}