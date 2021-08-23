package _20200905

import "strconv"

/**
 * @author chen
 * @date: 2020/9/5 上午11:53
 * @description:
 *
 */

/**
60. 第k个排列
给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。

按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：

"123"
"132"
"213"
"231"
"312"
"321"
给定 n 和 k，返回第 k 个排列。

说明：
给定 n 的范围是 [1, 9]。
给定 k 的范围是[1,  n!]。
*/

func getPermutation(n int, k int) string {

	// 先求阶乘
	factorial := make([]int, n-1)
	nums := make([]int, n)
	factorial[0] = 1
	for i := 1; i <= n; i++ {
		nums[i-1] = i
	}
	for i := 2; i < n; i++ {
		factorial[i-1] = factorial[i-2] * i
	}

	// 判断范围
	res := ""

	for i := n - 2; i >= 0; i-- {
		t := k / factorial[i]
		q := k % factorial[i]
		if q == 0 {
			t--
		}
		res += strconv.Itoa(nums[t])
		if t == n-1 {
			nums = nums[:t]
		} else {
			nums = append(nums[:t], nums[t+1:]...)
		}

		k -= t * factorial[i]
	}

	return res + strconv.Itoa(nums[0])
}
