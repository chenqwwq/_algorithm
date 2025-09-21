package top.chenqwwq.leetcode.archive.lcof2._84;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenbingxin
 * @date 2021/12/6
 **/
public class Solution {

	private static final int INF = -11;
	List<List<Integer>> ans;

	public List<List<Integer>> permuteUnique(int[] nums) {
		ans = new ArrayList<>();
		Arrays.sort(nums);
		backtrace(nums,0,new ArrayList<>(nums.length));
		return ans;
	}

	public void backtrace(int[] nums,int cnt,List<Integer> curr){
		if(cnt == nums.length){
			ans.add(new ArrayList<>(curr));
			return;
		}
		boolean[] visit = new boolean[21];
		// 在 cnt 位选择的数字
		for (int i = 0;i < nums.length;i++){
			final int num = nums[i];
			if(num == INF || visit[num + 10]){
				continue;
			}
			curr.add(num);
			nums[i] = INF;
			visit[num + 10] = true;
			backtrace(nums,cnt+1,curr);
			curr.remove(curr.size() - 1);
			nums[i] = num;
		}
	}
}