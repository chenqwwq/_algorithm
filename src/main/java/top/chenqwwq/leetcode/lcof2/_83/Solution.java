package top.chenqwwq.leetcode.lcof2._83;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenbingxin
 * @date 2021/12/6
 **/
public class Solution {
	private static final int INF = -11;

	List<List<Integer>> ans;

	public List<List<Integer>> permute(int[] nums) {
		ans = new ArrayList<>();
		backtrace(nums,0,new ArrayList<>(nums.length));
		return ans;
	}

	public void backtrace(int[] nums,int cnt,List<Integer> curr){
		if(cnt == nums.length){
			ans.add(new ArrayList<>(curr));
			return;
		}
		for (int i = 0;i < nums.length;i++){
			if(nums[i] == INF){
				continue;
			}
			final int num = nums[i];
			curr.add(num);
			nums[i] = INF;
			backtrace(nums,cnt+1,curr);
			curr.remove(curr.size()-1);
			nums[i] = num;
		}
	}
}