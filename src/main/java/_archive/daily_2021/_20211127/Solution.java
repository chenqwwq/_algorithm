package top.chenqwwq.leetcode.daily._2021._20211127;

import java.util.*;

/**
 * @author chenbingxin
 * @date 2021/11/27
 **/
public class Solution {

	List<Integer> remain = new ArrayList<>();
	int m,n,cnt;
	Random random = new Random();

	public Solution(int m, int n) {
		this.m = m;
		this.n = n;
		reset();
	}

	public int[] flip() {
		final int idx = random.nextInt(cnt--);
		final int value = remain.remove(idx);
		return new int[]{value / n,value % n};
	}

	public void reset() {
		remain = new ArrayList<>();
		for (int i = 0;i < n * m;i++){
			remain.add(i);
		}
		this.cnt = n * m;

	}
}