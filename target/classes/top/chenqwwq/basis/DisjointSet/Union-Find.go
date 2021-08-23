package UnionFindSet

/**
  @user: chenqwwq
  @date: 2020/12/29
*/

// 并查集的Go实现
// 并查集差用来处理一些不交集的合并和查找操作，也可以用来判断图点的联通性
// 朴素的并查集的查找的时间复杂度为O(h)，h为抽象的树的高度，最坏为链表O(n)

type UnionFind struct {
	tree []int
}

func NewUnionFind(size int) *UnionFind {
	tree := make([]int, size)
	for i := 0; i < len(tree); i++ {
		tree[i] = i
	}
	return &UnionFind{tree: tree}
}

type FindAndUnion interface {

	// 是否相连
	Connect(i, j int) bool

	// 找到i对应的根节点
	Find(i int) int

	// 合并
	Union(i, j int)
}

// QuickFind 追求最快的查询速度
// 要求在union的时候就将每个节点指向根节点
// Find和Connect的时间复杂度为O(1),因为要遍历整个链表查找所有需要修改根节点的元素，所以union的时间复杂度变为了O(n)

/**
type QuickFind = UnionFind

func (d *QuickFind) Find(i int) int {
	return d.tree[i]
}

func (d *QuickFind) Connect(i, j int) bool {
	return d.tree[i] == d.tree[j]
}

func (d *QuickFind) Union(i, j int) {
	q, p := d.Find(i), d.Find(j)
	// 将i连接到j上
	for i := 0; i < len(d.tree); i++ {
		if d.tree[i] == q {
			d.tree[i] = p
		}
	}
}
**/

// QuickUnion 追求最快的合并速度
// 数组中每个元素指向自己的父节点，而不是根节点,组成一个类似树的结构

/**
type QuickUnion = UnionFind

func (d *QuickUnion) Find(i int) int {
	for d.tree[i] != i {
		i = d.tree[i]
	}

	return d.tree[i]
}

func (d *QuickUnion) Connect(i, j int) bool {
	return d.Find(i) == d.Find(j)
}

func (d *QuickUnion) Union(i, j int) {
	d.tree[d.Find(i)] = d.Find(j)
}
*/

// 路径压缩
// 以QuickUnion为基础,Find方法往上遍历的时候指向根节点,路径压缩可以大幅度减少查询的时间,也能降低树的高度

/**
type PathCompression = UnionFind

func (d *PathCompression) Find(i int) int {
	for d.tree[i] != i {
		d.tree[i] = d.Find(d.tree[i])
	}

	return d.tree[i]
}
**/

// 加权按秩合并
// 在QuickUnion的基础上，在合并的时候考虑两端树的高度
// 使低阶树连接到高阶上，整体减少树的高度

type Rank struct {
	tree []int
	rank []int
}

func NewRank(size int) *Rank {

	tree, rank := make([]int, size), make([]int, size)
	for i := 0; i < len(tree); i++ {
		tree[i] = i
		rank[i] = 1
	}
	return &Rank{tree, rank}
}

func (r *Rank) Connect(i, j int) bool {
	return r.Find(i) == r.Find(j)
}

func (r *Rank) Find(i int) int {
	// 同时开启路径压缩
	for r.tree[i] != i {
		r.tree[i] = r.Find(r.tree[i])
	}
	return r.tree[i]
}

func (r Rank) Union(i, j int) {
	q, p := r.Find(i), r.Find(j)
	// 原本就同根
	if q == p {
		return
	}

	// 判断双方深度
	if r.rank[q] > r.rank[p] {
		// 将小树合并到大树
		r.tree[p] = q
	} else if r.rank[p] < r.rank[q] {
		r.tree[q] = p
	} else {
		// 相等的情况下需要增加一方的rank
		r.tree[q] = p
		r.rank[p]++
	}

}
