package main

import (
	"fmt"
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
// node AVL 树节点
type node struct {
	left, right *node
	val         int
	height      int
}

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

func main() {
	// LL
	RR := Constructor()
	RR.Add(3)
	fmt.Println(RR)
	RR.Add(2)
	fmt.Println(RR)
	RR.Add(1)
	fmt.Println(RR)

	LL := Constructor()
	LL.Add(1)
	fmt.Println(LL)
	LL.Add(2)
	fmt.Println(LL)
	LL.Add(3)
	fmt.Println(LL)

	LR := Constructor()
	LR.Add(1)
	fmt.Println(LR)
	LR.Add(3)
	fmt.Println(LR)
	LR.Add(2)
	fmt.Println(LR)

	RL := Constructor()
	RL.Add(3)
	fmt.Println(RL)
	RL.Add(1)
	fmt.Println(RL)
	RL.Add(2)
	fmt.Println(RL)
}

func (avl *AVL) Add(val int) *node {
	// create new node
	newNode := newNode(val)
	if avl.root == nil {
		avl.root = newNode
		return newNode
	}
	// add to root
	avl.root = add(avl.root, newNode)
	return newNode
}

func (avl *AVL) Del(val int) *node {
	// TODO:
	return nil
}

func (avl *AVL) Contains(target int) *node {
	return nil
}

func (avl *AVL) Find(target int) *node {
	return avl.root.find(target)
}

func (avl *AVL) Max() *node {
	return maxNode(avl.root)
}

func (avl *AVL) Min() *node {
	return minNode(avl.root)
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

// 内部方法

func del(_node *node, target int) *node {
	if _node == nil {
		return nil
	}
	if _node.val == target {
		if _node.left != nil && _node.right != nil {

		} else if _node.left != nil {
			_node = _node.left
		} else if _node.right != nil {
			_node = _node.right
		} else {
			_node = nil
		}
	}
	return nil
}

// getBalanceFactor 获取平衡因子
// 左边节点高度减去右边节点高度的数值
func (this *node) getBalanceFactor() int {
	if this == nil {
		return 0
	}
	return this.left.getHeight() - this.right.getHeight()
}

func (this *node) find(target int) *node {
	if this == nil {
		return nil
	}

	if this.val == target {
		return this
	}
	if this.val > target {
		return this.left.find(target)
	}
	return this.right.find(target)
}

func maxNode(_node *node) *node {
	if _node == nil || _node.right == nil {
		return _node
	}
	return maxNode(_node.right)
}

func minNode(_node *node) *node {
	if _node == nil || _node.left == nil {
		return _node
	}
	return minNode(_node.left)
}

func add(root, newNode *node) *node {
	if root == nil {
		return newNode
	}
	if root.val == newNode.val {
		return root
	}
	if newNode.val < root.val {
		root.left = add(root.left, newNode)
		if !root.isBalance() {
			if root.left.getBalanceFactor() > 0 {
				root = root.rotateRR()
			} else {
				root = root.rotateLR()
			}
		}
	} else {
		root.right = add(root.right, newNode)
		if !root.isBalance() {
			if root.right.getBalanceFactor() < 0 {
				root = root.rotateLL()
			} else {
				root = root.rotateRL()
			}
		}
	}
	root.height = max(root.right.getHeight(), root.left.getHeight()) + 1
	return root
}

func (this *node) format() string {
	if this == nil {
		return "#"
	}
	return strconv.Itoa(this.val) + this.left.format() + this.right.format()
}

func newNode(val int) *node {
	return &node{
		val:    val,
		height: 1,
	}
}

func (this *node) isBalance() bool {
	if this == nil {
		return true
	}
	return abs(this.left.getHeight()-this.right.getHeight()) <= 1
}

func (this *node) getHeight() int {
	if this == nil {
		return 0
	}
	return this.height
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
func (this *node) rotateRR() *node {
	// modify ptr
	left := this.left
	this.left = left.right
	left.right = this

	// update node's height
	// important: 个人在这里有一个误区
	// 高度表示的是当前节点下的子节点的层数，同个节点的左右节点的高度可能是不同的
	this.height = max(this.left.getHeight(), this.right.getHeight()) + 1
	left.height = max(left.left.getHeight(), left.right.getHeight()) + 1
	return left
}

// rotateLL
func (this *node) rotateLL() *node {
	right := this.right
	this.right = right.left
	right.left = this
	this.height = max(this.left.getHeight(), this.right.getHeight()) + 1
	right.height = max(right.left.getHeight(), right.right.getHeight()) + 1
	return right
}

// rotateLR
func (this *node) rotateLR() *node {
	this.left = this.left.rotateLL()
	return this.rotateRR()
}

// rotateRL
func (this *node) rotateRL() *node {
	this.right = this.right.rotateRR()
	return this.rotateLL()
}
