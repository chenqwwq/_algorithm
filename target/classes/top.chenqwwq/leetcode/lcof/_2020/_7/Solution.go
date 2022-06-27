package _7

/**
  @user: chenqwwq
  @date: 2020/7/22
*/

/**
剑指 Offer 07. 重建二叉树
输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。

例如，给出
前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7

限制：
0 <= 节点个数 <= 5000
*/

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func buildTree(preorder []int, inorder []int) *TreeNode {
	if len(preorder) == 0 || len(inorder) == 0 {
		return nil
	}

	root := TreeNode{preorder[0], nil, nil}
	w := 0
	for i, v := range inorder {
		if v == preorder[0] {
			w = i
			break
		}
	}

	root.Left = buildTree(preorder[1:w+1], inorder[0:w])
	root.Right = buildTree(preorder[w+1:], inorder[w+1:])

	return &root
}
