package _1631

import (
	"sort"
)

/**
  @user: chenqwwq
  @date: 2021/1/29
*/

/**
1631. 最小体力消耗路径
你准备参加一场远足活动。给你一个二维 rows x columns 的地图 heights ，其中 heights[row][col] 表示格子 (row, col) 的高度。一开始你在最左上角的格子 (0, 0) ，且你希望去最右下角的格子 (rows-1, columns-1) （注意下标从 0 开始编号）。你每次可以往 上，下，左，右 四个方向之一移动，你想要找到耗费 体力 最小的一条路径。
一条路径耗费的 体力值 是路径上相邻格子之间 高度差绝对值 的 最大值 决定的。
请你返回从左上角走到右下角的最小 体力消耗值 。

示例 1：
输入：heights = [[1,2,2],[3,8,2],[5,3,5]]
输出：2
解释：路径 [1,3,5,3,5] 连续格子的差值绝对值最大为 2 。
这条路径比路径 [1,2,2,2,5] 更优，因为另一条路径差值最大值为 3 。

示例 2：
输入：heights = [[1,2,3],[3,8,4],[5,3,5]]
输出：1
解释：路径 [1,2,3,4,5] 的相邻格子差值绝对值最大为 1 ，比路径 [1,3,5,3,5] 更优。
示例 3：

输入：heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
输出：0
解释：上图所示路径不需要消耗任何体力。

提示：

rows == heights.length
columns == heights[i].length
1 <= rows, columns <= 100
1 <= heights[i][j] <= 106
*/

// 并查集的解法

type UnionFind struct {
	parent, size []int
}

func NewUnionFind(cap int) *UnionFind {
	parent, size := make([]int, cap), make([]int, cap)
	for i := 0; i < cap; i++ {
		parent[i], size[i] = i, 1
	}
	return &UnionFind{parent: parent, size: size}
}

func (uf *UnionFind) find(i int) int {
	if uf.parent[i] != i {
		uf.parent[i] = uf.find(uf.parent[i])
	}
	return uf.parent[i]
}

// 合并
func (uf *UnionFind) union(i, j int) {
	q, p := uf.find(i), uf.find(j)
	if q == p {
		return
	}

	// 交换
	if uf.size[q] < uf.size[p] {
		q, p = p, q
	}

	uf.parent[p] = uf.parent[q]
	uf.size[q] += 1
}

func (uf *UnionFind) isSameParent(i, j int) bool {
	return uf.find(i) == uf.find(j)
}

type edge struct {
	i, j, cast int
}

func minimumEffortPath(heights [][]int) int {
	abs := func(i, j int) int {
		t := i - j
		if t >= 0 {
			return t
		}

		return -t
	}
	m, n := len(heights), len(heights[0])

	var edges []edge
	// 添加所有的边
	// 节点(i,j)到
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			idx, height := i*n+j, heights[i][j]
			// 纵向连线
			if i > 0 {
				edges = append(edges, edge{idx - m, idx, abs(height, heights[i-1][j])})
			}
			if j > 0 {
				edges = append(edges, edge{idx - 1, idx, abs(height, heights[i][j-1])})
			}
		}
	}

	sort.Slice(edges, func(i, j int) bool {
		return edges[i].cast < edges[j].cast
	})

	// 从最小边开始添加,使头位可以相连
	uf, end := NewUnionFind(m*n), m*n-1
	for _, v := range edges {
		uf.union(v.i, v.j)
		if uf.isSameParent(0, end) {
			return v.cast
		}
	}
	return 0
}
