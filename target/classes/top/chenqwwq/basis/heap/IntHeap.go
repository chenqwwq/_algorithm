package heap

/**
 * @author chen
 * @date: 2021/1/3 下午9:16
 * @description:
 *
 */

/**
所谓的堆可以简单理解成一棵完全二叉树，只是最大值在顶上(大顶堆时)。
通常二叉树使用一个数组表示，二叉树的节点从上到下，从左到右分别标记为0,1,2...n，也对应着数组的下标。
在每次添加元素或者删除元素的时候只需要维持这个原则就行(大顶堆为例):
	data[x] >= data[2x+1] && data[x] >= data[2x+2]  *转化为树的时候也就是每个节点都大于它的左右子节点,但左右节点无序

从以下三个场景来分析一个堆的行为:
1. 添加元素
元素都是添加在数组的末尾的，不过需要从末尾一直往上升级，和它的父节点比较，例如data[i]节点就需要和data[(i-1)>>1]比较
     2                   2                    3
	/    --添加元素3-->   / \    --siftUp-->   / \
   1                   1    3                1   2

2. 删除元素
删除元素的时候需要使用数组中最后的元素覆盖最顶部的元素，然后从顶部一路下放,
        5				     	  2             		   4
	  /  \                       / \			          / \
  	 3    4    --删除节点5-->     3   4    --siftDown-->   3   2
 	/ \                        /                        /
   1   2                      1                        1
这个下放的过程需要从左右子节点中选择较大的节点比较
3. 将已有的元素堆化
对所有的非叶子节点的元素siftDown,从底部开始
例如对于一个size=9的数字，希望堆化，则从(9-1) >> 1 = 4 开始进行调整

*/

// int 类型的大顶堆
type IntHeap struct {
	// 保存原始数据
	data []int

	// 元素个数
	size int
}

// NewIntHeap IntHeap的初始化方法
// size 表示初始的数组大小
// topBig 是否为大顶堆
func NewIntHeap(capacity int, topBig bool) *IntHeap {
	return &IntHeap{
		data: make([]int, capacity),
		size: 0,
	}
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

// siftUp 元素向上筛选
// 每次都是和自己父节点比较,对于大顶堆来说，如果父节点小则直接交换
func (i *IntHeap) siftUp(idx int, element int) {
	for idx > 0 {
		parent := (idx - 1) >> 1
		// 父节点确实大于子节点,直接跳过
		if i.data[parent] >= element {
			break
		}
		i.data[idx] = i.data[parent]
		idx = parent
	}
	i.data[idx] = element
}

// siftDown 元素从上往下筛选
func (i *IntHeap) siftDown(idx int, element int) {
	// 对于一个完全二叉树来说，如果为n阶级，那么子节点的个数为2 ^ n ,基本占全部的节点个数的一半
	half := i.size >> 1
	for idx < half {
		// 选择一个子节点
		target := (idx << 1) + 1
		right := target + 1
		// 存在只有一半子树的情况
		if right < i.size && i.data[right] > i.data[target] {
			target = right
		}

		if element > i.data[target] {
			break
		}

		i.data[idx] = i.data[target]
		idx = target
	}

	i.data[idx] = element
}

// 建堆,时间复杂度O(n)
// 就是对于每一个非叶子节点都进行向下筛选
func (i *IntHeap) heapify() {
	for index := (i.size - 1) >> 1; index >= 0; index-- {
		i.siftDown(index, i.data[index])
	}
}

func (i *IntHeap) InitFromCollection(elements []int) {
	if len(elements) > len(i.data) {
		return
	}
	for k, v := range elements {
		i.data[k] = v
	}
	i.size = len(elements)
}

func (i *IntHeap) Push(item int) {
	// TODO: grow()
	target := i.size
	i.size++
	i.siftUp(target, item)
}

func (i *IntHeap) Poll() int {
	i.size--
	ans := i.data[0]
	last := i.data[i.size]
	i.siftDown(0, last)
	return ans
}
