package _20200907

import (
	"container/heap"
)

/**
  @user: chenqwwq
  @date: 2020/9/7
*/

/*
347. 前 K 个高频元素
给定一个非空的整数数组，返回其中出现频率前 k 高的元素。

提示：
你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
你可以按任意顺序返回答案。
*/

func topKFrequent(nums []int, k int) []int {
	// 统计频率
	fre := map[int]int{}
	for _, v := range nums {
		fre[v]++
	}

	h := &Heap{}
	heap.Init(h)

	// 全部塞到堆里面去
	for key, v := range fre {
		heap.Push(h, [2]int{key, v})
		if h.Len() > k {
			heap.Pop(h)
		}
	}

	// 构造答案
	ans := make([]int, k)
	for i := 0; i < k; i++ {
		ans[i] = heap.Pop(h).([2]int)[0]
	}

	return ans
}

// Go实现一个小顶堆
type Heap [][2]int

func (h Heap) Len() int {
	return len(h)
}

func (h Heap) Less(i, j int) bool {
	return h[i][1] < h[j][1]
}

func (h Heap) Swap(i, j int) {
	h[i], h[j] = h[j], h[i]
}

func (h *Heap) Push(x interface{}) {
	*h = append(*h, x.([2]int))
}

func (h *Heap) Pop() interface{} {
	obj := *h
	ans := obj[len(obj)-1]
	*h = obj[0 : len(obj)-1]
	return ans
}
