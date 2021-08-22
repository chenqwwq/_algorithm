package top.chenqwwq.leetcode.week._255._1;

/**
 * @author chen
 * @date 2021/8/22
 **/
public class Solution {
	public int findGCD(int[] nums) {
		int min = Integer.MAX_VALUE, max = 0;
		for (int num : nums) {
			min = Math.min(min, num);
			max = Math.max(max, num);
		}
		while (max % min != 0) {// 在余数不能为0时,进行循环
			int temp = max % min;
			max = min;
			min = temp;
		}
		return min;
	}
}