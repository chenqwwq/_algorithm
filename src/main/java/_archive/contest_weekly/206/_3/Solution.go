package _3

import "math"

/**
 * @author chen
 * @date: 2020/9/13 上午11:33
 * @description:
 *
 */

/**
5513. 连接所有点的最小费用
给你一个points 数组，表示 2D 平面上的一些点，其中 points[i] = [xi, yi] 。

连接点 [xi, yi] 和点 [xj, yj] 的费用为它们之间的 曼哈顿距离 ：|xi - xj| + |yi - yj| ，其中 |val| 表示 val 的绝对值。

请你返回将所有点连接的最小总费用。只有任意两点之间 有且仅有 一条简单路径时，才认为所有点都已连接。
*/

func minCostConnectPoints(points [][]int) int {
	flag := make([]bool, len(points))

	// 以邻接矩阵形式保存
	graph := make([][]int, len(points))
	for i, j := range points {
		graph[i] = make([]int, len(points))
		for k, v := range points {
			if i == k {
				graph[i][k] = 0
				continue
			}
			graph[i][k] = abs(j[0]-v[0]) + abs(j[1]-v[1])
		}
	}

	// prim
	// 选举0作为顶节点
	flag[0] = true
	cnt := 1
	ans := 0

	for cnt != len(points) {
		len := math.MaxInt64
		target := -1
		// 选择最小的
		for i, b := range flag {
			// 起点要是已经选择过得
			if !b {
				continue
			}
			for k, v := range graph[i] {
				// 终点是未选择过得
				if flag[k] {
					continue
				}
				if v < len {
					len = v
					target = k
				}
			}

		}
		if target != -1 {
			flag[target] = true
			ans += len
			cnt++
		}
	}

	return ans
}

func abs(a int) int {
	if a < 0 {
		return -a
	}
	return a
}
