package _0402

/**
  @user: chenqwwq
  @date: 2020/12/15
*/

/**
面试题 04.02. 最小高度树
给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。

示例:
给定有序数组: [-10,-3,0,5,9],
一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：

          0
         / \
       -3   9
       /   /
     -10  5
*/

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func sortedArrayToBST(nums []int) *TreeNode {
	var rebuild func(left, right int) *TreeNode
	rebuild = func(left, right int) *TreeNode {
		if left > right {
			return nil
		}
		mid := left + (right-left)>>1
		return &TreeNode{
			nums[mid],
			rebuild(left, mid-1),
			rebuild(mid+1, right),
		}
	}

	return rebuild(0, len(nums)-1)
}
