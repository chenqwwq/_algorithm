package main

import (
	"strconv"
)

/**
 * @author chen
 * @date: 2021/10/2 11:17 下午
 * @description:
 * AVL 树就是可以自平衡的二叉查找树，查找和平衡的时间复杂度都为O(logN)
 * AVL 需要平衡的情况分为 LL，RR，LR，RL 四种，
 * LL 情况如下：
 *  [5]        [5]					[4]
 *   /   ===>  /    == rotate =>    / \
 * [4]       [4]				  [3] [5]
 *          /
 *        [3]
 * 文字表述上就是失衡节点(5)下挂到左子节点(4)的右节点上，并且将其右节点改为自己的右节点，RR 可以类推。
 * <p>
 * 如果是 LR 就是先 LL 转化为 RR 的形态，在进行 RR 的操作，RL 可以类推
 * <p>
 * 旋转注意节点高度的变化
 */

// AVLTree 接口
type AVLTree interface {
	Add(val int) *node
	Del(avl int) *node
	IsBalance() bool
	Max() *node
	Min() *node
	Find(target int) *node
	Contains(target int) *node
}

// AVL 树
type AVL struct {
	root          *node
	balanceFactor int // 平衡因子，能接受的左右子树的高度差
}

func (avl *AVL) Add(val int) *node {
	// create new node
	newNode := newNode(val)
	if avl.root == nil {
		avl.root = newNode
		return newNode
	}
	// add to root
	avl.root = avl.root.add(newNode)
	return newNode
}

func (avl *AVL) Del(val int) *node {
	avl.root = avl.root.del(val)
	return avl.root
}

func (avl *AVL) Contains(target int) *node {
	return avl.root.contains(target)
}

func (avl *AVL) Find(target int) *node {
	return avl.root.find(target)
}

func (avl *AVL) Max() *node {
	return avl.root.maxNode()
}

func (avl *AVL) Min() *node {
	return avl.root.minNode()
}

func Constructor() *AVL {
	return &AVL{nil, 1}
}

func (avl *AVL) String() string {
	return avl.root.format()
}

func (avl *AVL) IsBalance() bool {
	return avl.root.isBalance()
}

// node AVL 树节点
type node struct {
	left, right *node
	val         int
	height      int
}

// 内部方法

func newNode(val int) *node {
	return &node{
		val:    val,
		height: 1,
	}
}

// contains 是否包含某个值
func (n *node) contains(target int) *node {
	if n == nil {
		return nil
	}

	if n.val == target {
		return n
	} else if n.val < target {
		return n.right.contains(target)
	} else {
		return n.left.contains(target)
	}
}

// del 删除节点  返回删除后的子树根节点
func (n *node) del(target int) *node {
	if n == nil {
		return nil
	}
	// 需要删除的不是当前节点,但是删除之后高度可能发生变化
	ret := n
	if target < n.val {
		n.left = n.left.del(target)
	} else if target > n.val {
		n.right = n.right.del(target)
	} else if n.val == target {
		// 需要删除的就是当前节点
		if n.left != nil && n.right != nil {
			// 如果左右子树都在,就找左子树的最大值或者右子树的最小值
			// 这里选择左子树的最大值
			// right 存在，所以 maxNode 肯定存在
			maxNode := n.left.maxNode()
			maxNode.left = n.left.del(maxNode.val)
			maxNode.right = n.right
			ret = maxNode
		} else if n.left != nil {
			ret = n.left
		} else if n.right != nil {
			ret = n.right
		} else {
			ret = nil
		}
		// 还有如果当前节点为子节点的时候
	}
	if ret == nil {
		return ret
	}
	ret.height = max(ret.left.getHeight(), ret.right.getHeight()) + 1
	// 判断是否需要重新平衡
	return ret.balance()
}

// balance 平衡
func (n *node) balance() *node {
	if n.isBalance() {
		return n
	}
	if n.getBalanceFactor() > 0 {
		if n.left.getBalanceFactor() > 0 {
			return n.rotateRR()
		} else {
			return n.rotateLR()
		}
	} else {
		if n.right.getBalanceFactor() < 0 {
			return n.rotateLL()
		} else {
			return n.rotateRL()
		}
	}
}

// getBalanceFactor 获取平衡因子
// 左边节点高度减去右边节点高度的数值
func (n *node) getBalanceFactor() int {
	if n == nil {
		return 0
	}
	return n.left.getHeight() - n.right.getHeight()
}

func (n *node) find(target int) *node {
	if n == nil {
		return nil
	}

	if n.val == target {
		return n
	}
	if n.val > target {
		return n.left.find(target)
	}
	return n.right.find(target)
}

func (n *node) maxNode() *node {
	if n == nil || n.right == nil {
		return n
	}
	return n.right.maxNode()
}

func (n *node) minNode() *node {
	if n == nil || n.left == nil {
		return n
	}
	return n.left.minNode()
}

func (n *node) add(newNode *node) *node {
	if n == nil {
		return newNode
	}
	if n.val == newNode.val {
		return n
	}
	if newNode.val < n.val {
		n.left = n.left.add(newNode)
	} else {
		n.right = n.right.add(newNode)
	}

	n.height = max(n.right.getHeight(), n.left.getHeight()) + 1
	return n.balance()
}

func (n *node) format() string {
	if n == nil {
		return "#"
	}
	return strconv.Itoa(n.val) + n.left.format() + n.right.format()
}

func (n *node) isBalance() bool {
	if n == nil {
		return true
	}
	return abs(n.left.getHeight()-n.right.getHeight()) <= 1
}

func (n *node) getHeight() int {
	if n == nil {
		return 0
	}
	return n.height
}

// 旋转方法
// LL 和 RR 可能颠倒

// rotateRR 表示的是左左的失去平衡
// 理解中的需要左旋的情况
//       5(root)
//      / \
//     4   t1              4
//    / \	  --右旋->	 /   \
//   3   t2		        3     5
//  / \                / \   / \
// t3  t4             t3 t4 t2  t1
//
func (n *node) rotateRR() *node {
	// modify ptr
	left := n.left
	n.left = left.right
	left.right = n

	// update node's height
	// important: 个人在这里有一个误区
	// 高度表示的是当前节点下的子节点的层数，同个节点的左右节点的高度可能是不同的
	n.height = max(n.left.getHeight(), n.right.getHeight()) + 1
	left.height = max(left.left.getHeight(), left.right.getHeight()) + 1
	return left
}

// rotateLL
func (n *node) rotateLL() *node {
	right := n.right
	n.right = right.left
	right.left = n
	n.height = max(n.left.getHeight(), n.right.getHeight()) + 1
	right.height = max(right.left.getHeight(), right.right.getHeight()) + 1
	return right
}

// rotateLR
func (n *node) rotateLR() *node {
	n.left = n.left.rotateLL()
	return n.rotateRR()
}

// rotateRL
func (n *node) rotateRL() *node {
	n.right = n.right.rotateRR()
	return n.rotateLL()
}

func abs(a int) int {
	if a < 0 {
		return -a
	}
	return a
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
