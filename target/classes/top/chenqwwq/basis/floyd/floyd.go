package floyd

/**
 * @author chen
 * @date: 2021/8/25 下午10:51
 * @description:
 *
 */

// floyd
// n 表示节点数目
// edges 表示图所有的边,分别是边的起点，终点，权值
// node 表示需要求的点
func floyd(n int, edges [][3]int, node int) []int {
	// 求任意一点到其余点的最短距离
	const INF = 0x3F3F3F3F
	var graph [][]int
	for i := 0; i < n; i++ {
		for j := 0; j < n; j++ {
			if i == j {
				graph[i][j] = 0
			} else {
				graph[i][j], graph[j][i] = INF, INF
			}
		}
	}

	for _, edge := range edges {
		graph[edge[0]][edge[1]] = edge[2]
	}

	min := func(a, b int) int {
		if a > b {
			return b
		}
		return a
	}

	// 三层循环暴力松弛
	for i := 0; i < n; i++ {
		for j := 0; j < n; j++ {
			for q := 0; q < n; q++ {
				// 松弛
				graph[j][q] = min(graph[j][q], graph[j][i]+graph[i][q])
			}
		}
	}

	return graph[node]
}
