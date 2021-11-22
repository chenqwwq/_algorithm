package top.chenqwwq.basis.dichotomy;

/**
 * 以升序数组查询
 *
 * @author chen
 * @date 2021-07-09
 **/
public class Dichotomy {

	public int exist(int[] nums, int target) {
		return -1;
	}

	/**
	 * 找到第一个大于或者等于 target 的数字的下标
	 */
	public int ceiling(int[] nums, int target) {
		final int n = nums.length;
		int l = 0, r = n - 1;
		while (l <= r) {
			final int mid = (l + r) >> 1;
			if (nums[mid] < target) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return l;
	}

	/**
	 * 找到第一个小雨或者等于的数字
	 */
	public int floor(int[] nums, int target) {
		final int n = nums.length;
		int l = 0, r = n - 1;
		while (l <= r) {
			final int mid = (l + r) >> 1;
			if (nums[mid] > target) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return r;
	}

}
