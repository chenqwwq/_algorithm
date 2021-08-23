package _20200919

/**
 * @author chen
 * @date: 2020/9/19 下午10:29
 * @description:
 *
 */
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func sumOfLeftLeaves(root *TreeNode) int {
	ans := 0
	var dfs func(root *TreeNode)

	dfs = func(root *TreeNode) {
		if root == nil {
			return
		}
		if root.Left != nil {
			ans += root.Left.Val
		}

		dfs(root.Left)
		dfs(root.Right)
	}

	dfs(root)
	return ans
}
