package top.chenqwwq.leetcode.daily._20210803;

/**
 * 581. 最短无序连续子数组
 * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * <p>
 * 请你找出符合题意的 最短 子数组，并输出它的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,6,4,8,10,9,15]
 * 输出：5
 * 解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：nums = [1]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 104
 * -105 <= nums[i] <= 105
 *
 * @author chen
 * @date 2021-08-03
 **/
public class Solution {

	public int findUnsortedSubarray(int[] nums) {
		final int n = nums.length;
		if (n < 2) {
			return 0;
		}
		int ml = Integer.MAX_VALUE, left = -1, mr = Integer.MIN_VALUE, right = 0;
		for (int i = 0; i < n; i++) {

			if (nums[n - i - 1] > ml) {
				left = n - i - 1;
			} else {
				ml = nums[n - i - 1];
			}

			if (nums[i] < mr) {
				right = i;
			} else {
				mr = nums[i];
			}
		}
		return left == -1 ? 0 : right - left + 1;
	}
}