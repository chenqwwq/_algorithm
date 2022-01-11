package dijkstra

/**
 * @author chen
 * @date: 2021/8/25 下午10:20
 * @description:
 * dijkstra 算法 单源最短路径算法
 */

/**
dijkstra 算法以贪心为基础,以最短的路径持续松弛所有的边,以此找出最短路径
dijkstra 适用于单源且无负权值图
时间复杂度: O(n^2)
*/

// dijkstra
// n 表示节点数目
// edges 表示图所有的边,分别是边的起点，终点，权值
// src 和 des 分别表示起点和终点
func dijkstra(n int, edges [][3]int, src, des int) int {
	const INF = 0xFFFFFFFF
	graph := make(map[int][][2]int)
	for _, edge := range edges {
		if graph[edge[0]] == nil {
			graph[edge[0]] = [][2]int{}
		}
		graph[edge[0]] = append(graph[edge[0]], [2]int{edge[1], edge[2]})
	}

	// 队列保存所有已经收缩的节点
	var queue [][2]int
	visit := make([]bool, n)

	nexts, exist := graph[src]
	if !exist {
		return -1
	}
	queue = append(queue, nexts...)
	visit[src] = true

	for len(queue) != 0 {
		curr, min := 0, INF
		// 每次选择最小权重的路径
		// 可以使用堆来优化选取过程
		for _, v := range queue {
			if v[1] < min {
				curr = v[0]
			}
		}
		if curr == des {
			return min
		}
		visit[curr] = true
		if nexts, exist := graph[curr]; exist {
			for _, next := range nexts {
				// 忽略已经访问过得节点
				if visit[next[1]] {
					continue
				}
				queue = append(queue, [2]int{next[0], next[1] + min})
			}
		}
	}
	return -1
}
