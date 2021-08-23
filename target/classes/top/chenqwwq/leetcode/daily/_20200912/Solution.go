package _20200912

/**
 * @author chen
 * @date: 2020/9/12 上午9:25
 * @description:
 *
 */

/**
637. 二叉树的层平均值
给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。

示例 1：

输入：
    3
   / \
  9  20
    /  \
   15   7
输出：[3, 14.5, 11]
解释：
第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
*/

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func averageOfLevels(root *TreeNode) []float64 {
	var ans []float64
	var cnt []float64

	var dfs func(node *TreeNode, n int)
	dfs = func(node *TreeNode, n int) {
		if node == nil {
			return
		}
		if len(ans) <= n {
			ans = append(ans, float64(node.Val))
			cnt = append(cnt, 1)
		} else {
			ans[n] = ans[n] + float64(node.Val)
			cnt[n]++
		}
		dfs(node.Right, n+1)
		dfs(node.Left, n+1)
	}

	dfs(root, 0)

	for i := 0; i < len(ans); i++ {
		ans[i] /= cnt[i]
	}

	return ans
}
