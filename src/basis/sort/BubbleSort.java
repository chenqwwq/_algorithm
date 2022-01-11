package top.chenqwwq.basis.sort;

import top.chenqwwq.basis.sort.Sort;

/**
 * 冒泡排序
 * <p>
 * 时间复杂度为 O(n2)，为稳定的排序算法
 * <p>
 * 基本思路就是相邻元素的比较和交换
 *
 * @author chen
 * @date 2021-08-12
 **/
public class BubbleSort implements Sort {

	@Override
	public void sortAes(int[] nums) {
		final int n = nums.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (nums[i] < nums[j]) {
					swap(nums, i, j);
				}
			}
		}
	}
}
