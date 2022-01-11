package top.chenqwwq.leetcode.lcof2._6;

/**
 * @author chenbingxin
 * @date 2021/12/6
 **/
public class Solution {
	public int[] twoSum(int[] numbers, int target) {
		final int n = numbers.length;
		int l = 0, r = n - 1;
		while (l < r){
			final int curr = numbers[l] + numbers[r];
			if(curr == target){
				return new int[]{l,r};
			}else if(curr < target){
				l++;
			}else{
				r--;
			}
		}
		return new int[]{};
	}
}
