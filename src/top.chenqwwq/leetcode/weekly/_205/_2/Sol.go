package _2

/**
 * @author chen
 * @date: 2020/9/6 下午4:07
 * @description:
 *
 */
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func levelOrderBottom(root *TreeNode) [][]int {
	var res [][]int

	var dfs func(root *TreeNode, level int)

	dfs = func(root *TreeNode, level int) {
		if root == nil {
			return
		}
		if len(res) <= level {
			res = append(res, []int{})
		}
		res[level] = append(res[level], root.Val)
		dfs(root.Left, level+1)
		dfs(root.Right, level+1)
	}

	dfs(root, 0)
	for i, j := 0, len(res)-1; i < j; i, j = i+1, j-1 {
		res[i], res[j] = res[j], res[i]
	}
	return res
}
