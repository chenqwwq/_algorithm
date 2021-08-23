package _20200904

import "strconv"

/**
  @user: chenqwwq
  @date: 2020/9/4
*/
/**
257. 二叉树的所有路径
给定一个二叉树，返回所有从根节点到叶子节点的路径。

说明: 叶子节点是指没有子节点的节点。
*/

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func binaryTreePaths(root *TreeNode) []string {
	var res []string

	var dfs func(node *TreeNode, cur string)

	dfs = func(node *TreeNode, cur string) {
		if node == nil {
			return
		}

		if len(cur) == 0 {
			cur += strconv.Itoa(node.Val)
		} else {
			cur += "->" + strconv.Itoa(node.Val)
		}

		if node.Right == nil && node.Left == nil {
			res = append(res, cur)
		}

		dfs(node.Left, cur)
		dfs(node.Right, cur)
	}

	dfs(root, "")

	return res
}
