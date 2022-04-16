package prefixsum

import "fmt"

/**
 * @author chen
 * @date: 2021/1/14 下午11:07
 * @description:
 *
 */

// PrefixSum 前缀和
type PrefixSum struct {
	data []int
}

// NewPrefixSum 从普通数组初始化前缀和数组
func NewPrefixSum(data []int) *PrefixSum {
	n := len(data)
	if n == 0 {
		return &PrefixSum{}
	}

	buffer, sum := make([]int, n), 0
	for i := 0; i < n; i++ {
		sum += data[i]
		buffer[i] = sum
	}
	return &PrefixSum{data: buffer}
}

// Update update 更新某个节点
// 时间复杂度为O(n)
func (target *PrefixSum) Update(idx, num int) bool {
	n := len(target.data)
	if idx >= n {
		fmt.Printf("index error,[array length:{%d},idx:{%d}]", n, idx)
		return false
	}
	for i := idx; i < n; i++ {
		target.data[i] += num
	}
	return true
}

// GetRange 获取区间和
func (target *PrefixSum) GetRange(left, right int) int {
	if left < 0 || right >= len(target.data) {
		panic(fmt.Sprintf("数组下标越界,left:{%d},right:{%d}", left, right))
	}

	return target.data[right] - target.data[left]
}
