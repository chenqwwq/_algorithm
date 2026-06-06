package template.sort;

/**
 * @author chen
 * @date 2021-09-18
 **/
public class InsertionSort implements Sort {
	@Override
	public void sortAes(int[] nums) {
		final int n = nums.length;
		// 基础插入
//		for (int i = 0; i < n; i++) {
//			int target = i;
//			for (int j = i - 1; j >= 0; j--) {
//				if (nums[j] > nums[i]) {
//					target = j;
//				} else {
//					break;
//				}
//			}
//			if (target == i) {
//				continue;
//			}
//			final int tmp = nums[i];
//			if (i - target >= 0) {
//				System.arraycopy(nums, target, nums, target + 1, i - target);
//				nums[target] = tmp;
//			}
//		}

		// 二分优化
		for (int i = 0; i < n; i++) {
			final int idx;
			if ((idx = findTargetByDic(nums, 0, i - 1, nums[i])) >= i) {
				continue;
			}
			final int tmp = nums[i];
			System.arraycopy(nums, idx, nums, idx + 1, i - idx);
			nums[idx] = tmp;

		}
	}

	/**
	 * 利用二面查找确定下标
	 * <p>
	 * 找到第一个小于
	 */
	private int findTargetByDic(int[] nums, int left, int right, int target) {

		while (left <= right) {
			final int mid = left + right >> 1;
			if (nums[mid] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}
}
