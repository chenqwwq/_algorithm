package top.chenqwwq.leetcode.daily._20210518;

/**
 * 1442. 形成两个异或相等数组的三元组数目
 * 给你一个整数数组 arr 。
 * <p>
 * 现需要从数组中取三个下标 i、j 和 k ，其中 (0 <= i < j <= k < arr.length) 。
 * <p>
 * a 和 b 定义如下：
 * <p>
 * a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]
 * b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]
 * 注意：^ 表示 按位异或 操作。
 * <p>
 * 请返回能够令 a == b 成立的三元组 (i, j , k) 的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [2,3,1,6,7]
 * 输出：4
 * 解释：满足题意的三元组分别是 (0,1,2), (0,2,2), (2,3,4) 以及 (2,4,4)
 * 示例 2：
 * <p>
 * 输入：arr = [1,1,1,1,1]
 * 输出：10
 * 示例 3：
 * <p>
 * 输入：arr = [2,3]
 * 输出：0
 * 示例 4：
 * <p>
 * 输入：arr = [1,3,5,7,9]
 * 输出：3
 * 示例 5：
 * <p>
 * 输入：arr = [7,11,12,9,5,2,7,17,22]
 * 输出：8
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 300
 * 1 <= arr[i] <= 10^8
 *
 * @author chen
 * @date 2021-05-18
 **/
public class Solution {

	//	public int countTriplets(int[] arr) {
//		// pre[k] == pre[i-1] 就表示
//		// 利用 hash 记录 pre[k]
//		int[] pre = new int[arr.length + 1];
//		for (int i = 0; i < arr.length; i++) {
//			pre[i] = arr[i] ^ pre[i];
//		}
//
//		int ans = 0;
//		for (int i = 1; i < pre.length - 1; i++) {
//
//		}
//		return ans;
//	}
	public int countTriplets(int[] arr) {
		final int n = arr.length;
		int[] pre = new int[n + 1];

		// 计算前缀
		for (int i = 0; i < n; i++) {
			pre[i + 1] = arr[i] ^ pre[i];
		}

		int ans = 0;
		for (int i = 1; i <= n; i++) {
			for (int k = i + 1; k <= n; k++) {
				//  b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]
				if (pre[k] == pre[i - 1]) {
					ans += (k - i);
				}
			}
		}
		return ans;
	}
}