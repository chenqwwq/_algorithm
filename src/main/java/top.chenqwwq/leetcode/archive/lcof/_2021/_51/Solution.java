package top.chenqwwq.leetcode.archive.lcof._2021._51;

/**
 * 剑指 Offer 51. 数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,5,6,4]
 * 输出: 5
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= 数组长度 <= 50000
 *
 * @author chen
 * @date 2021-05-27
 **/
public class Solution {
	public int reversePairs(int[] nums) {
		final int n = nums.length;
		return fork(nums, 0, n - 1, new int[n]);
	}

	private int fork(int[] nums, int left, int right, int[] temp) {
		if (left >= right) {
			return 0;
		}

		int mid = (left + right) >> 1;
		return fork(nums, left, mid, temp) + fork(nums, mid + 1, right, temp) + join(nums, left, right, mid, temp);
	}

	private int join(int[] nums, int left, int right, int mid, int[] temp) {
		int ans = 0;
		int k = left, i = left, j = mid + 1;
		while (i <= mid && j <= right) {
			if (nums[i] <= nums[j]) {
				temp[k++] = nums[i++];
			} else {
				temp[k++] = nums[j++];
				ans += mid - i + 1;
			}
		}

		while (i <= mid) {
			temp[k++] = nums[i++];
		}

		while (j <= right) {
			temp[k++] = nums[j++];
		}

		while (left <= right) {
			nums[left] = temp[left];
			left++;
		}

		return ans;
	}
}