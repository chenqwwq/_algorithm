package top.chenqwwq.leetcode.topic.union_find._128;

import java.util.Arrays;

/**
 * 128. 最长连续序列
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * <p>
 * <p>
 * <p>
 * 进阶：你可以设计并实现时间复杂度为 O(n) 的解决方案吗？
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 示例 2：
 * <p>
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 *
 * @author chen
 * @date 2021-06-08
 **/
public class Solution {

	public int longestConsecutive(int[] nums) {
		final int n = nums.length;
		if (n < 2) {
			return n;
		}
		Arrays.sort(nums);

		int curr = nums[0], ans = 1, len = 1;
		for (int i = 1; i < n; i++) {
			if (curr == nums[i]) {
				continue;
			}
			if (curr == nums[i] - 1) {
				curr = nums[i];
				ans = Math.max(ans, ++len);
				continue;
			}
			curr = nums[i];
			len = 1;
		}
		return ans;
	}

//	class UnionFind {
//		Map<Integer, Integer> hash = new HashMap<>();
//
//		public UnionFind(int[] nums) {
//			for (int num : nums) {
//				hash.put(num, num);
//			}
//		}
//
//		/**
//		 * i 肯定存在
//		 */
//		public void merge(int i, int j) {
//			if (!hash.containsKey(j)) {
//				return;
//			}
//			hash.put(find(i), find(j));
//		}
//
//		public int find(int x) {
//			if (!hash.containsKey(x)) {
//				return -1;
//			}
//			if (hash.get(x) != x) {
//				hash.put(x, find(hash.get(x)));
//			}
//			return hash.get(x);
//		}
//	}
//
//	public int longestConsecutive(int[] nums) {
//		if (nums.length < 2) {
//			return nums.length;
//		}
//		final UnionFind uf = new UnionFind(nums);
//		// 合并
//		for (int num : nums) {
//			uf.merge(num, num + 1);
//		}
//
//		int ans = Integer.MIN_VALUE;
//		for (int num : nums) {
//			ans = Math.max(ans, uf.find(num) - num + 1);
//		}
//		return ans;
//	}
}