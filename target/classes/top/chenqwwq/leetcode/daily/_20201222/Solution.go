package _20201222

/**
  @user: chenqwwq
  @date: 2020/12/23
*/

/**
103. 二叉树的锯齿形层序遍历
给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。

例如：
给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回锯齿形层序遍历如下：

[
  [3],
  [20,9],
  [15,7]
]

*/

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func zigzagLevelOrder(root *TreeNode) [][]int {

	var ans [][]int

	var dfs func(root *TreeNode, level int)
	var reverse func(s []int) []int
	dfs = func(root *TreeNode, level int) {
		if root == nil {
			return
		}
		for len(ans) <= level {
			ans = append(ans, []int{})
		}

		ans[level] = append(ans[level], root.Val)
		dfs(root.Left, level+1)
		dfs(root.Right, level+1)
	}

	reverse = func(s []int) []int {
		for i, j := 0, len(s)-1; i < j; i, j = i+1, j-1 {
			s[i], s[j] = s[j], s[i]
		}
		return s
	}

	dfs(root, 0)

	for i := 1; i < len(ans); i+=2 {
		ans[i] = reverse(ans[i])
	}

	return ans
}
