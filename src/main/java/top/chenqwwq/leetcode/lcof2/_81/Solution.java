package top.chenqwwq.leetcode.lcof2._81;

import java.util.ArrayList;
import java.util.List;

/**
 * [2,3,6,7]
 * 7
 * [2,3,5]
 * 8
 * [2]
 * 1
 *
 * @author chenbingxin
 * @date 2021/12/3
 **/
public class Solution {
	private List<List<Integer>> ans;

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		ans = new ArrayList<>();
		backtracking(candidates, target, 0, new ArrayList<>());
		return ans;
	}

	public void backtracking(int[] candidates, int target, int idx, List<Integer> curr) {
		if (target == 0) {
			ans.add(new ArrayList<>(curr));
			return;
		}
		if (idx >= candidates.length || target < 0) {
			return;
		}
		// 当前元素取不取，取几个
		curr.add(candidates[idx]);
		backtracking(candidates, target - candidates[idx], idx, curr);
		curr.remove(curr.size() - 1);
		backtracking(candidates, target, idx + 1, curr);
	}
}