package _20200805

/**
  @user: chenqwwq
  @date: 2020/8/5
*/

/*
337. 打家劫舍 III
在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。

计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。

示例 1:

输入: [3,2,3,null,3,null,1]

     3
    / \
   2   3
    \   \
     3   1

输出: 7
解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
示例 2:

输入: [3,4,5,1,3,null,1]

     3
    / \
   4   5
  / \   \
 1   3   1

输出: 9
解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
*/

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func rob(root *TreeNode) int {
	// 树型dp

	var dfs func(root *TreeNode) [2]int
	// root表示节点 take表示是否取该节点
	// res[0] 表示不取本节点
	// res[1] 表示取本节点的
	dfs = func(root *TreeNode) [2]int {

		if root == nil {
			return [2]int{}
		}

		left := dfs(root.Left)
		right := dfs(root.Right)

		// 如果取当前节点 那么左右节点都不能取
		withRoot := left[0] + right[0] + root.Val
		// 如果不取 那么左右节点可以自由选择取还是不取
		outRoot := max(left[0], left[1]) + max(right[0], right[1])

		return [2]int{outRoot, withRoot}
	}

	ints := dfs(root)
	return max(ints[0], ints[1])
}

func max(i, j int) int {
	if i > j {
		return i
	}
	return j
}
