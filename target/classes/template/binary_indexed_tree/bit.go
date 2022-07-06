package main

/**
 * @author chen
 * @date: 2021/1/14 下午10:52
 * @description:
 *
 */

// 树状数组
// 相当于前缀和的优化，前缀和能将求区间和的复杂度降低到O(1)，但是对于修改复杂度确实O(n)
// 树状数组可以在 O(log n) 的时间得到任意前缀和，并同时支持在 O(log n)时间内支持动态单点值的修改(增加或者减少)
// #link https://halfrost.com/binary_indexed_tree/#toc-0
// 第i个节点，如果i是奇数则只保存当前节点的值，例如 i=5 时，只保存 nums[5] 的值，翻成二进制末位为1
//

type BinaryIndexedTree struct {
	data     []int
	capacity int
}

// Init 初始化 BinaryIndexedTree
func (bit *BinaryIndexedTree) Init(nums []int) {
	n := len(nums)
	bit.capacity, bit.data = n+1, make([]int, n+1)
	for i := 0; i < n; i++ {
		bit.Add(i+1, nums[i])
	}
}

// Add 将 pos 处的元素新增 val
func (bit *BinaryIndexedTree) Add(pos, val int) bool {
	if pos >= bit.capacity {
		return false
	}
	for pos < bit.capacity {
		bit.data[pos] += val
		pos += lowbit(pos)
	}
	return true
}

// Update 将 pos 处的元素更新为 val
func (bit *BinaryIndexedTree) Update(pos, val int) bool {
	return bit.Add(pos+1, val-bit.data[pos+1])
}

// Sum 获取前缀和
func (bit *BinaryIndexedTree) Sum(pos int) int {
	ans := 0
	for pos >= 1 {
		ans += bit.data[pos]
		pos -= lowbit(pos)
	}
	return ans
}

// Range 获取范围值
func (bit *BinaryIndexedTree) Range(l, r int) int {
	return bit.Sum(r+1) - bit.Sum(l)
}

// lowbit 获得最后一位1
// 例如12 => 1100，-12 => 0100 ,12 & -12 => 0100
func lowbit(i int) int {
	return i & -i
}
