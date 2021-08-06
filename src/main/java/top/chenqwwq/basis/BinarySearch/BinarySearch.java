package top.chenqwwq.basis.BinarySearch;

/**
 * 以升序数组查询
 *
 * @author chen
 * @date 2021-07-09
 **/
public class BinarySearch {

	/**
	 * 找到等于 target 数
	 */
	public int find1(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			final int mid = (left + right) >> 1;
		if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return -1;
	}

	/**
	 * 找到等于 target 的数,如果存在多个则返回第一个
	 */
	public int find2(int[] nums, int target) {
		final int n = nums.length;
		int left = 0, right = n - 1;
		while (left <= right) {
			final int mid = (left + right) >> 1;
			// 因为找第一个就是最左边的数,所以相等的时候也往左边靠
			if (nums[mid] >= target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return (left < n && nums[left] == target) ? left : -1;
	}

	/**
	 * 找到等于 target 的数,如果存在多个则返回第一个
	 */
	public int find3(int[] nums, int target) {
		final int n = nums.length;
		int left = 0, right = n - 1;
		while (left <= right) {
			final int mid = (left + right) >> 1;
			if (nums[mid] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return (right > 0 && nums[right] == target) ? right : -1;
	}

	/**
	 * 找到小于 target 的数
	 */
	public int find4(int[] nums, int target) {
		return -1;
	}


	/**
	 * 找到比　target 大的第一个数
	 */
	public int find5(int[] nums, int target) {
		final int n = nums.length;
		int left = 0, right = n - 1;
		while (left <= right) {
			final int mid = (left + right) >> 1;
			if (nums[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return left;
	}
}
