package top.chenqwwq.leetcode.daily._2021._20210512;

/**
 * 1310. 子数组异或查询
 * 有一个正整数数组 arr，现给你一个对应的查询数组 queries，其中 queries[i] = [Li, Ri]。
 * <p>
 * 对于每个查询 i，请你计算从 Li 到 Ri 的 XOR 值（即 arr[Li] xor arr[Li+1] xor ... xor arr[Ri]）作为本次查询的结果。
 * <p>
 * 并返回一个包含给定查询 queries 所有结果的数组。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [1,3,4,8], queries = [[0,1],[1,2],[0,3],[3,3]]
 * 输出：[2,7,14,8]
 * 解释：
 * 数组中元素的二进制表示形式是：
 * 1 = 0001
 * 3 = 0011
 * 4 = 0100
 * 8 = 1000
 * 查询的 XOR 值为：
 * [0,1] = 1 xor 3 = 2
 * [1,2] = 3 xor 4 = 7
 * [0,3] = 1 xor 3 xor 4 xor 8 = 14
 * [3,3] = 8
 * 示例 2：
 * <p>
 * 输入：arr = [4,8,2,10], queries = [[2,3],[1,3],[0,0],[0,3]]
 * 输出：[8,0,4,4]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 3 * 10^4
 * 1 <= arr[i] <= 10^9
 * 1 <= queries.length <= 3 * 10^4
 * queries[i].length == 2
 * 0 <= queries[i][0] <= queries[i][1] < arr.length
 *
 * @author chen
 * @date 2021-05-12
 **/
public class Solution {
	public int[] xorQueries(int[] arr, int[][] queries) {
		int[] pre = new int[arr.length + 1];
		pre[0] = 0;
		for (int i = 1; i <= arr.length; i++) {
			pre[i] = pre[i - 1] ^ arr[i - 1];
		}

		int[] ans = new int[queries.length];
		for (int i = 0; i < queries.length; i++) {
			ans[i] = pre[queries[i][1] + 1] ^ pre[queries[i][0]];
		}
		return ans;
	}
}





















