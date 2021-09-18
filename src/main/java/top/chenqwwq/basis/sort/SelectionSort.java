package top.chenqwwq.basis.sort;

/**
 * 选择排序
 * <p>
 * 时间复杂度最好最坏都是O(n2)
 *
 * @author chen
 * @date 2021-09-18
 **/
public class SelectionSort implements Sort {

	@Override
	public void sortAes(int[] nums) {
		final int n = nums.length;
		for (int i = 0; i < n; i++) {
			int curr = i;
			for (int j = i + 1; j < n; j++) {
				if (nums[curr] > nums[j]) {
					curr = j;
				}
			}
			if (curr != i) {
				swap(nums, i, curr);
			}
		}
	}
}
