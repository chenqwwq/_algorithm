package top.chenqwwq.basis.sort;

/**
 * 快速排序
 * 非稳定排序，最优时间复杂度为O(nlogn)
 *
 * @author chen
 * @date 2021-09-18
 **/
public class QuickSort implements Sort {
	@Override
	public void sortAes(int[] nums) {
		sort(nums, 0, nums.length - 1);
	}

	private void sort(int[] num, int left, int right) {
		if (left >= right) {
			return;
		}

		int l = left, r = right;
		int pivot = num[left];
		while (l < r) {
			while (r > l && num[r] >= pivot) {
				r--;
			}
			while (r > l && num[l] <= pivot) {
				l++;
			}
			swap(num, l, r);
		}
		num[left] = num[l];
		num[l] = pivot;
		sort(num, left, l - 1);
		sort(num, l + 1, right);

	}
}
