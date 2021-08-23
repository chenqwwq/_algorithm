package _20200801

import (
	"math"
)

/**
  @user: chenqwwq
  @date: 2020/8/1
*/

/**
632. 最小区间
你有 k 个升序排列的整数数组。找到一个最小区间，使得 k 个列表中的每个列表至少有一个数包含在其中。

我们定义如果 b-a < d-c 或者在 b-a == d-c 时 a < c，则区间 [a,b] 比 [c,d] 小。

示例 1:

输入:[[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
输出: [20,24]
解释:
列表 1：[4, 10, 15, 24, 26]，24 在区间 [20,24] 中。
列表 2：[0, 9, 12, 20]，20 在区间 [20,24] 中。
列表 3：[5, 18, 22, 30]，22 在区间 [20,24] 中。
注意:

给定的列表可能包含重复元素，所以在这里升序表示 >= 。
1 <= k <= 3500
-105 <= 元素的值 <= 105
对于使用Java的用户，请注意传入类型已修改为List<List<Integer>>。重置代码模板后可以看到这项改动。
*/

func smallestRange(nums [][]int) []int {
	size := len(nums)
	// map[i] 表示存在i值的数组
	// store的所有key值的集合就是所有的值
	store := map[int][]int{}
	_max, _min := math.MinInt64, math.MaxInt64
	for i, arr := range nums {
		for _, v := range arr {
			store[v] = append(store[v], i)
			_max = max(_max, v)
			_min = min(_min, v)
		}
	}

	// 窗口左右边界
	low, high := _min, _min-1
	resLow, resHigh := _min, _max
	// 在窗口内数组存在几个匹配的数字
	idx := make([]int, size)
	// 窗口内当前包含的数组个数
	cnt := 0

	for high < _max {
		// 窗口扩展
		high++
		if len(store[high]) <= 0 {
			continue
		}

		for _, v := range store[high] {
			idx[v]++
			if idx[v] == 1 {
				cnt++
			}
		}

		// 窗口的扩展需要到包含全部的数组值
		if cnt != size {
			continue
		}

		// 匹配

		// 收缩窗口
		// 需要收缩到不包含全部的数组
		for cnt == size {
			// 寻找最优区间
			if high-low < resHigh-resLow {
				resHigh = high
				resLow = low
			}

			// 去除最小节点
			for _, v := range store[low] {
				// 不需要判断idx[v]是否大于0
				// 因为store[low]中保存的就是包含这个节点的数组
				if idx[v] == 1 {
					cnt--
				}
				idx[v]--
			}

			low++
		}
	}

	return []int{resLow, resHigh}
}

func max(a, b int) int {
	if a > b {
		return a
	}

	return b
}

func min(a, b int) int {
	if a > b {
		return b
	}

	return a
}
