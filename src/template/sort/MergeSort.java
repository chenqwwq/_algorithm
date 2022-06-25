package top.chenqwwq.basis.sort;

/**
 * 归并排序
 * 稳定排序，时间复杂度为　O(nlogn)
 *
 * @author chen
 * @date 2021-09-18
 **/
public class MergeSort implements Sort {

	@Override
	public void sortAes(int[] nums) {
		final int n = nums.length;
		split(nums, 0, n - 1, new int[n]);
	}

	/**
	 * 分割，不带额外数组版本
	 */
	private void split(int[] nums, int left, int right, int[] temper) {
		if (left >= right) {
			return;
		}
		final int mid = left + right >> 1;
		split(nums, left, mid, temper);
		split(nums, mid + 1, right, temper);
		merge(nums, left, mid + 1, right, temper);
	}

	private void merge(int[] nums, int left, int mid, int right, int[] temper) {
		int idx = left, i = left, j = mid;
		while (i < mid && j <= right) {
			if (nums[i] > nums[j]) {
				temper[idx++] = nums[j++];
			} else {
				temper[idx++] = nums[i++];
			}
		}
		while (i < mid) {
			temper[idx++] = nums[i++];
		}
		while (j <= right) {
			temper[idx++] = nums[j++];
		}

		System.arraycopy(temper, left, nums, left, right - left + 1);
	}
}
