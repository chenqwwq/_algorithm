package _20200928

/**
  @user: chenqwwq
  @date: 2020/9/28
*/

/**
117. 填充每个节点的下一个右侧节点指针 II
给定一个二叉树

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。

初始状态下，所有 next 指针都被设置为 NULL。

进阶：

你只能使用常量级额外空间。
使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
*/

type Node struct {
	Val   int
	Left  *Node
	Right *Node
	Next  *Node
}

func connect(root *Node) *Node {
	// 常数级的额外空间
	var dfs func(root *Node, level int) *Node
	var nodes []*Node

	dfs = func(root *Node, level int) *Node {
		if root == nil {
			return nil
		}

		if len(nodes) <= level {
			nodes = append(nodes, root)
		} else {
			root.Next = nodes[level]
			nodes[level] = root
		}

		dfs(root.Right, level+1)
		dfs(root.Left, level+1)

		return root
	}

	return dfs(root, 0)
}
