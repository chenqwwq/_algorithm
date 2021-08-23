package _20200818

/**
  @user: chenqwwq
  @date: 2020/8/18
*/

/**
109. 有序链表转换二叉搜索树
给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。

本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。

示例:

给定的有序链表： [-10, -3, 0, 5, 9],

一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：

      0
     / \
   -3   9
   /   /
 -10  5
*/

type ListNode struct {
	Val  int
	Next *ListNode
}
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func sortedListToBST(head *ListNode) *TreeNode {
	if head == nil {
		return nil
	}

	arr := tranToArr(head)

	return buildTree(*arr, 0, len(*arr)-1)
}

func buildTree(arr []int, low, high int) *TreeNode {
	if low > high {
		return nil
	}
	if low == high {
		return &TreeNode{arr[low], nil, nil}
	}

	mid := low + (high-low)>>1

	return &TreeNode{
		Val:   arr[mid],
		Right: buildTree(arr, mid+1, high),
		Left:  buildTree(arr, low, mid-1),
	}
}

func tranToArr(head *ListNode) *[]int {
	var res []int
	for head != nil {
		res = append(res, head.Val)
		head = head.Next
	}
	return &res
}
