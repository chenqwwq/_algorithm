package _230

/**
  @user: chenqwwq
  @date: 2020/7/31
*/

/**
230. 二叉搜索树中第K小的元素
给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。

说明：
你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。

示例 1:

输入: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
输出: 1
示例 2:

输入: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
输出: 3
进阶：
如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数
*/

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func kthSmallest(root *TreeNode, k int) int {
	res := 0

	var dfs func(node *TreeNode)

	dfs = func(node *TreeNode) {
		if node == nil {
			return
		}
		dfs(node.Left)
		k--
		if k == 0 {
			res = node.Val
		}
		dfs(node.Right)
	}

	dfs(root)
	return res
}

//func kthSmallest(root *TreeNode, k int) int {
//	i, node := dfs(root.Left, k)
//	if node != nil {
//		return node.Val
//	}
//	if k-i == 1 {
//		return root.Val
//	}
//	_, treeNode := dfs(root.Right, k-i-1)
//	if treeNode != nil {
//		return treeNode.Val
//	}
//	return -1
//}
//
//func dfs(root *TreeNode, k int) (int, *TreeNode) {
//	if root == nil {
//		return 0, nil
//	}
//	i, node := dfs(root.Left, k)
//	if node != nil {
//		return -1, node
//	}
//	if k-i == 1 {
//		return -1, root
//	}
//	i2, treeNode := dfs(root.Right, k-i-1)
//	if treeNode != nil {
//		return -1, treeNode
//	}
//	return i + 1 + i2, nil
//}
