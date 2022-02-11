package top.chenqwwq.leetcode.daily._20210508;

import java.util.HashSet;
import java.util.Set;

/**
 * 1723. Find Minimum Time to Finish All Jobs
 * You are given an integer array jobs, where jobs[i] is the amount of time it takes to complete the ith job.
 * <p>
 * There are k workers that you can assign jobs to. Each job should be assigned to exactly one worker. The working time of a worker is the sum of the time it takes to complete all jobs assigned to them. Your goal is to devise an optimal assignment such that the maximum working time of any worker is minimized.
 * <p>
 * Return the minimum possible maximum working time of any assignment.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: jobs = [3,2,3], k = 3
 * Output: 3
 * Explanation: By assigning each person one job, the maximum time is 3.
 * Example 2:
 * <p>
 * Input: jobs = [1,2,4,7,8], k = 2
 * Output: 11
 * Explanation: Assign the jobs the following way:
 * Worker 1: 1, 2, 8 (working time = 1 + 2 + 8 = 11)
 * Worker 2: 4, 7 (working time = 4 + 7 = 11)
 * The maximum working time is 11.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= k <= jobs.length <= 12
 * 1 <= jobs[i] <= 107
 *
 * @author chen
 * @date 2021-05-08
 **/
public class Solution {
	int ans = Integer.MAX_VALUE;

	public int minimumTimeRequired(int[] jobs, int k) {
		if (jobs.length <= k) {
			return getSmallest(jobs);
		}

		// 数据量确实不大 直接穷举把
		dfs(jobs, 0, new int[k]);
		return ans;
	}

	public void dfs(int[] jobs, int curr, int[] costs) {
		if (jobs.length == curr) {
			ans = Math.min(ans, getSmallest(costs));
			return;
		}
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < costs.length; i++) {
			if (!set.add(costs[i]) || costs[i] + jobs[curr] >= ans) {
				continue;
			}
			costs[i] += jobs[curr];
			dfs(jobs, curr + 1, costs);
			costs[i] -= jobs[curr];
		}
	}


	private int getSmallest(int[] nums) {
		int ans = nums[0];
		for (int i : nums) {
			ans = Math.max(ans, i);
		}
		return ans;
	}
}
