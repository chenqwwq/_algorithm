package top.chenqwwq.leetcode.archive.lcof2._82;

import java.util.*;

/**
 * @author chenbingxin
 * @date 2021/12/6
 **/
public class Solution {

	List<List<Integer>> ans;

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		// 回溯
		ans = new ArrayList<>();
		Arrays.sort(candidates);

		backtrace(candidates, 0, target, new ArrayList<>());
		return new ArrayList<>(ans);
	}

	public void backtrace(int[] candidates, int i, int target, List<Integer> curr) {
		if (target == 0) {
			ans.add(new ArrayList<>(curr));
			return;
		}
		if (target <= 0 || i >= candidates.length) {
			return;
		}

		curr.add(candidates[i]);
		backtrace(candidates, i + 1, target - candidates[i], curr);
		curr.remove(curr.size() - 1);
		while (i < candidates.length - 1 && candidates[i] == candidates[i+1]){
			i++;
		}
		backtrace(candidates, i + 1, target, curr);
	}
}