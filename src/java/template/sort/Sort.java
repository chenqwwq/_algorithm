package template.sort;

/**
 * @author chen
 * @date 2021-08-12
 **/
public interface Sort {
	/**
	 * 排序主流程
	 *
	 * @param nums 对 nums 进行排序
	 */
	void sortAes(int[] nums);


	/**
	 * 交换元素
	 */
	default void swap(int[] nums, int i, int j) {
		final int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
