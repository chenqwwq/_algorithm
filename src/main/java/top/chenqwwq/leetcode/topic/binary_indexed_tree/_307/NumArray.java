package top.chenqwwq.leetcode.topic.binary_indexed_tree._307;

/**
 * '
 * 307. 区域和检索 - 数组可修改
 * 给你一个数组 nums ，请你完成两类查询，其中一类查询要求更新数组下标对应的值，另一类查询要求返回数组中某个范围内元素的总和。
 * <p>
 * 实现 NumArray 类：
 * <p>
 * NumArray(int[] nums) 用整数数组 nums 初始化对象
 * void update(int index, int val) 将 nums[index] 的值更新为 val
 * int sumRange(int left, int right) 返回子数组 nums[left, right] 的总和（即，nums[left] + nums[left + 1], ..., nums[right]）
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：
 * ["NumArray", "sumRange", "update", "sumRange"]
 * [[[1, 3, 5]], [0, 2], [1, 2], [0, 2]]
 * 输出：
 * [null, 9, null, 8]
 * <p>
 * 解释：
 * NumArray numArray = new NumArray([1, 3, 5]);
 * numArray.sumRange(0, 2); // 返回 9 ，sum([1,3,5]) = 9
 * numArray.update(1, 2);   // nums = [1,2,5]
 * numArray.sumRange(0, 2); // 返回 8 ，sum([1,2,5]) = 8
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 3 * 104
 * -100 <= nums[i] <= 100
 * 0 <= index < nums.length
 * -100 <= val <= 100
 * 0 <= left <= right < nums.length
 * 最多调用 3 * 104 次 update 和 sumRange 方法
 *
 * @author chen
 * @date 2021/5/12
 **/
public class NumArray {

	// 前缀和实现
//
//	int[] pre;
//	int[] src;
//
//	public NumArray(int[] nums) {
//		src = nums;
//		pre = new int[nums.length + 1];
//		pre[0] = 0;
//
//		for (int i = 0; i < nums.length; i++) {
//			pre[i + 1] = pre[i] + nums[i];
//		}
//	}
//
//	public void update(int index, int val) {
//		int diff = val - src[index];
//		src[index] = val;
//		for (int i = index + 1; i < pre.length; i++) {
//			pre[i] += diff;
//		}
//	}
//
//	public int sumRange(int left, int right) {
//		if (left == right) {
//			return src[left];
//		}
//		if (left > right) {
//			return -1;
//		}
//		return pre[right + 1] - pre[left];
//	}


	int[] arr;
	int[] src;

	public NumArray(int[] nums) {
		src = new int[nums.length];
		// 初始化数状数组
		arr = new int[nums.length + 1];
		for (int i = 0; i < nums.length; i++) {
			update(i, nums[i]);
		}
	}

	private int lowbit(int i) {
		return i & -i;
	}

	public void update(int index, int val) {
		int diff = val - src[index];
		src[index] = val;
		index++;
		while (index < arr.length) {
			arr[index] += diff;
			index += lowbit(index);
		}
	}

	public int sumRange(int i) {
		int ans = 0;
		while (i > 0) {
			ans += arr[i];
			i -= lowbit(i);
		}
		return ans;
	}

	public int sumRange(int left, int right) {
		return sumRange(right + 1) - sumRange(left);
	}
}
