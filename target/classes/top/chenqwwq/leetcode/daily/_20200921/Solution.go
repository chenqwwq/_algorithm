package _20200921

/**
  @user: chenqwwq
  @date: 2020/9/21
*/

/**
538. 把二叉搜索树转换为累加树
给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。

例如：

输入: 原始二叉搜索树:
              5
            /   \
           2     13

输出: 转换为累加树:
             18
            /   \
          20     13
*/

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func convertBST(root *TreeNode) *TreeNode {
	// 二叉搜索树
	// 右 中 左更新

	sum := 0

	var rightFirst func(node *TreeNode)

	rightFirst = func(node *TreeNode) {
		if node == nil {
			return
		}
		rightFirst(node.Right)
		sum += node.Val
		node.Val = sum
		rightFirst(node.Left)
	}

	rightFirst(root)

	return root
}
