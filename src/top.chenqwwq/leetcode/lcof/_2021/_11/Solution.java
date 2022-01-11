package top.chenqwwq.leetcode.lcof._2021._11;

/**
 * @author chen
 * @date 2021/5/29
 **/
public class Solution {
	public int minArray(int[] numbers) {
		final int len = numbers.length;
		int left = 0, right = len - 1;
		while (left < right) {
			int mid = (left + right) >> 1;
			if (numbers[mid] > numbers[right]) {
				left++;
			} else {
				right--;
			}
		}
		return numbers[left];
	}
}