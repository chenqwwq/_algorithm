package _20211017

/**
 * @author chen
 * @date: 2021/10/17 下午1:46
 * @description:
 *
 */

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func kthSmallest(root *TreeNode, k int) int {
	var cnt = 0
	var dfs func(root *TreeNode, k int) int
	dfs = func(root *TreeNode, k int) int {
		if root == nil {
			return -1
		}
		if i := dfs(root.Left, k); i != -1 {
			return i
		}
		cnt++
		if cnt == k {
			return root.Val
		}
		return dfs(root.Right, k)
	}
	return dfs(root,k)
}
