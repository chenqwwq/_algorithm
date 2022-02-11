package top.chenqwwq.leetcode.lcof._2021._39;

/**
 * 剑指 Offer 39. 数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * <p>
 * <p>
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 * <p>
 * <p>
 * 限制：
 * <p>
 * 1 <= 数组长度 <= 50000
 *
 * @author chen
 * @date 2021-05-26
 **/
public class Solution {
	public int majorityElement(int[] nums) {
		int ans = nums[0], cnt = 1;
		for (int i = 1; i < nums.length; i++) {
			if (ans == nums[i]) {
				cnt++;
			} else {
				if (cnt == 0) {
					ans = nums[i];
					cnt = 1;
				} else {
					cnt--;
				}
			}
		}
		return ans;
	}
}