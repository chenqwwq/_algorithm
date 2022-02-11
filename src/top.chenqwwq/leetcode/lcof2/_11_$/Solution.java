package top.chenqwwq.leetcode.lcof2._11_$;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenbingxin
 * @date 2021/12/10
 **/
public class Solution {
	public int findMaxLength(int[] nums) {
		// 和为长度一半的情况
		final int n = nums.length;
		Map<Integer,Integer> map = new HashMap<>();
		map.put(0,-1);
		int sum = 0,ans = 0;
		for (int i = 0;i < n;i++){
			sum += nums[i] == 0 ? -1 : 1;
			if(map.containsKey(sum)){
				ans = Math.max(ans,i - map.get(sum));
			}else{
				map.put(sum,i);
			}
		}
		return ans;
	}
}