package top.chenqwwq.leetcode.topic.graph.topological._1203;

import java.util.*;

/**
 * 1203. Sort Items by Groups Respecting Dependencies
 * There are n items each belonging to zero or one of m groups where group[i] is the group that the i-th item belongs to and it's equal to -1 if the i-th item belongs to no group.
 * The items and the groups are zero indexed. A group can have no item belonging to it.
 * <p>
 * Return a sorted list of the items such that:
 * <p>
 * The items that belong to the same group are next to each other in the sorted list.
 * There are some relations between these items where beforeItems[i] is a list containing all the items that should come before the i-th item in the sorted array (to the left of the i-th item).
 * Return any solution if there is more than one solution and return an empty list if there is no solution.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: n = 8, m = 2, group = [-1,-1,1,0,0,1,0,-1], beforeItems = [[],[6],[5],[6],[3,6],[],[],[]]
 * Output: [6,3,4,1,5,2,0,7]
 * Example 2:
 * <p>
 * Input: n = 8, m = 2, group = [-1,-1,1,0,0,1,0,-1], beforeItems = [[],[6],[5],[6],[3],[],[4],[]]
 * Output: []
 * Explanation: This is the same as example 1 except that 4 needs to be before 6 in the sorted list.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= m <= n <= 3 * 104
 * group.length == beforeItems.length == n
 * -1 <= group[i] <= m - 1
 * 0 <= beforeItems[i].length <= n - 1
 * 0 <= beforeItems[i][j] <= n - 1
 * i != beforeItems[i][j]
 * beforeItems[i] does not contain duplicates elements.
 * <p>
 * 5
 * 5
 * [2,0,-1,3,0]
 * [[2,1,3],[2,4],[],[],[]]
 * <p>
 * [3,2,4,1,0]
 * <p>
 * [3,4,1,0,2]
 *
 * @author chen
 * @date 2021-05-13
 **/
public class Solution {
	public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
		// 项目之间存在拓扑关系，组之间也存在
		// 因为组的项目可能依赖另外一个组

		for (int i = 0; i < group.length; i++) {
			if (group[i] == -1) {
				group[i] = m++;
			}
		}

		// 邻接表
		List<Integer>[] groups = new List[m];
		List<Integer>[] jobs = new List[n];
		// 入度数组
		int[] groupsIndegree = new int[m];
		int[] jobsIndegree = new int[n];

		// 初始化
		for (int i = 0; i < m; i++) {
			groups[i] = new ArrayList<>();
		}
		for (int i = 0; i < n; i++) {
			jobs[i] = new ArrayList();
		}

		// 填充邻接数据,计算入度
		// i 表示任务，group[i]表示任务对应的群组
		for (int i = 0; i < beforeItems.size(); i++) {
			final List<Integer> before = beforeItems.get(i);
			// 依赖为空
			if (before.isEmpty()) {
				continue;
			}
			// 第i个任务所依赖的任务
			for (int job : before) {
				// 任务i 依赖任务job,方向从 job 指向 i
				jobs[job].add(i);
				// i 和 job 对应的群组不同,那执行 i 的群组就存在 job 的入度
				if (group[i] != -1 && group[job] != group[i] && group[job] != -1) {
					groups[group[job]].add(group[i]);
					groupsIndegree[group[i]]++;
				}
			}
			jobsIndegree[i] = before.size();
		}

		// 拓扑排序
		final int[] jt = topological(jobsIndegree, jobs);
		if (jt.length == 0) {
			return new int[0];
		}
		final int[] gt = topological(groupsIndegree, groups);
		if (gt.length == 0) {
			return new int[0];
		}

		// 根据两个拓扑排序的结果重新排列任务
		// 任务的相对顺序不能改变
		// 组相同的任务移动到一边
		// 因为经过了拓扑排序，所以此时的任务肯定是可以排列的
		// 主要应该还是两个拓扑排序拍玩之后的组合

		List<Integer>[] groupsJob = new List[m + 1];
		for (int i = 0; i <= m; i++) {
			groupsJob[i] = new ArrayList<>();
		}

		for (int k : jt) {
			groupsJob[group[k] + 1].add(k);
		}

		int[] ans = new int[n];
		int idx = 0;
		for (int job : groupsJob[0]) {
			ans[idx++] = job;
		}

		for (int g : gt) {
			for (int j : groupsJob[g + 1]) {
				ans[idx++] = j;
			}
		}
		return ans;
	}

	public int[] topological(int[] indegree, List<Integer>[] before) {
		final int n = indegree.length;
		int[] ans = new int[n];

		Stack<Integer> stack = new Stack<>();
		// 入站所有入度为0的
		for (int i = 0; i < n; i++) {
			if (indegree[i] == 0) {
				stack.push(i);
			}
		}

		int idx = 0;
		while (!stack.isEmpty()) {
			final Integer pop = stack.pop();
			ans[idx++] = pop;
			for (Integer i : before[pop]) {
				if (--indegree[i] == 0) {
					stack.push(i);
				}
			}
		}
		return idx < n ? new int[0] : ans;
	}
}























