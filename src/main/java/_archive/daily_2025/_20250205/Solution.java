package top.chenqwwq.leetcode.daily._2025._20250205;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chenqwwq
 * @date 2025/2/5
 **/
public class Solution {

    List<List<Integer>> ans;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ans = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0, new LinkedList<>());
        return ans;
    }

    // 选择 i 之后的某个节点
    public void dfs(int[] nums, int i, LinkedList<Integer> cur) {
        ans.add(new ArrayList<>(cur));
        for (int j = i; j < nums.length; j++) {
            if (j > i && nums[j] == nums[j - 1]) continue;

            cur.addLast(nums[j]);
            dfs(nums, j + 1, cur);
            cur.removeLast();
        }
    }
}