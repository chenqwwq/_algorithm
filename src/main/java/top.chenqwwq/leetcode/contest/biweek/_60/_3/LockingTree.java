package top.chenqwwq.leetcode.contest.biweek._60._3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author chen
 * @date 2021/9/4
 **/
public class LockingTree {

	int[] status;
	int[] parent;
	Map<Integer, Set<Integer>> sun;

	public LockingTree(int[] parent) {
		final int n = parent.length;
		this.status = new int[n];
		this.parent = parent;
		this.sun = new HashMap<>();
		for (int i = 1; i < n; i++) {
			final Set<Integer> orDefault = sun.getOrDefault(parent[i], new HashSet<>());
			orDefault.add(i);
			sun.put(parent[i], orDefault);
		}
	}

	public boolean lock(int num, int user) {
		if (status[num] != 0) {
			return false;
		}
		status[num] = user;
		return true;
	}

	public boolean unlock(int num, int user) {
		if (status[num] != user) {
			return false;
		}
		status[num] = 0;
		return true;
	}

	public boolean upgrade(int num, int user) {
		if (!checkUp(num) || !upgradeDown(num)) {
			return false;
		}
		status[num] = user;
		return true;
	}


	private boolean upgradeDown(int num) {
		boolean flag = false;
		final Set<Integer> suns = sun.get(num);
		if (suns == null || suns.isEmpty()) {
			return false;
		}
		for (int i : suns) {
			if (status[i] != 0) {
				status[i] = 0;
				flag = true;
			}
			flag = flag | upgradeDown(i);
		}
		return flag;
	}

	private boolean checkUp(int num) {
		if (num == -1) {
			return true;
		}
		if (status[num] != 0) {
			return false;
		}
		return checkUp(parent[num]);
	}
}