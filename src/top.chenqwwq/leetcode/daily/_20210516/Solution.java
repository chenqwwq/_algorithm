package top.chenqwwq.leetcode.daily._20210516;

/**
 * 421. 数组中两个数的最大异或值
 * 给你一个整数数组 nums ，返回 nums[i] XOR nums[j] 的最大运算结果，其中 0 ≤ i ≤ j < n 。
 * <p>
 * 进阶：你可以在 O(n) 的时间解决这个问题吗？
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,10,5,25,2,8]
 * 输出：28
 * 解释：最大运算结果是 5 XOR 25 = 28.
 * 示例 2：
 * <p>
 * 输入：nums = [0]
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：nums = [2,4]
 * 输出：6
 * 示例 4：
 * <p>
 * 输入：nums = [8,10,2]
 * 输出：10
 * 示例 5：
 * <p>
 * 输入：nums = [14,70,53,83,49,91,36,80,92,51,66,70]
 * 输出：127
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 2 * 104
 * 0 <= nums[i] <= 231 - 1
 *
 * @author chen
 * @date 2021/5/16
 **/
public class Solution {
	// 练习前缀树

	class Node {
		Node[] node = new Node[2];
	}

	Node root = new Node();

	public void add(int num) {
		Node tmp = root;
		for (int i = 31; i >= 0; i--) {
			int n = (num >> i) & 1;
			if (tmp.node[n] == null) {
				tmp.node[n] = new Node();
			}
			tmp = tmp.node[n];
		}
	}

	public int getMaxValue(int x) {
		int ans = 0;
		Node tmp = root;
		// 获取最大的衣火值
		for (int i = 31; i >= 0; i--) {
			int n = (x >> i) & 1, diff = n ^ 1;
			if (tmp.node[diff] == null) {
				ans |= (diff << i);
				tmp = tmp.node[diff];
			} else {
				ans |= (n << i);
				tmp = tmp.node[n];
			}
		}
		return ans;
	}

	public int findMaximumXOR(int[] nums) {
		int ans = Integer.MIN_VALUE;
		for (int i : nums) {
			add(i);
			final int maxValue = getMaxValue(i);
			ans = Math.max(ans, maxValue ^ i);
		}
		return ans;
	}
}