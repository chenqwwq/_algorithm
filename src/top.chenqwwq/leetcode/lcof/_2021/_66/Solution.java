package top.chenqwwq.leetcode.lcof._2021._66;

import java.util.Arrays;

/**
 * 剑指 Offer 66. 构建乘积数组
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 所有元素乘积之和不会溢出 32 位整数
 * a.length <= 100000
 *
 * @author chen
 * @date 2021-08-12
 **/
public class Solution {
	public int[] constructArr(int[] a) {
		final int n = a.length;
		final int[] pre = new int[n + 2], suf = new int[n + 2];
		Arrays.fill(pre, 1);
		Arrays.fill(suf, 1);
		for (int i = 1; i <= n; i++) {
			pre[i] = pre[i - 1] * a[i - 1];
			suf[n - i + 1] = suf[n - i + 2] * a[n - i];
		}

		int[] ans = new int[n];
		for (int i = 0; i < n; i++) {
			ans[i] = pre[i] * suf[i + 2];
		}

		return ans;
	}
}