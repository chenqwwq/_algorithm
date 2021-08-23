package _20200804

/**
  @user: chenqwwq
  @date: 2020/8/4
*/

/**
207. 课程表
你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。

在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]

给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？



示例 1:

输入: 2, [[1,0]]
输出: true
解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
示例 2:

输入: 2, [[1,0],[0,1]]
输出: false
解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成课程0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。


提示：

输入的先决条件是由 边缘列表 表示的图形，而不是 邻接矩阵 。详情请参见图的表示法。
你可以假定输入的先决条件中没有重复的边。
1 <= numCourses <= 10^5
*/

func canFinish(numCourses int, prerequisites [][]int) bool {
	// 采用拓扑排序
	// 拓扑排序通常用来排序一系列具有依赖关系的数据
	// 此处刚好可以用来对有向图中节点做排序
	// 第一次应用

	// 入度
	var (
		indegree = make([]int, numCourses)
		edges    = map[int][]int{}
		nodes    []int
	)

	// 遍历全部的边，生成邻接表
	for _, v := range prerequisites {
		indegree[v[1]]++
		edges[v[0]] = append(edges[v[0]], v[1])
	}

	// 找出所有入度为0的点
	for i, v := range indegree {
		if v == 0 {
			nodes = append(nodes, i)
		}
	}

	for len(nodes) != 0 {
		// 减少后续节点入度
		for _, v := range edges[nodes[0]] {
			indegree[v]--
			if indegree[v] == 0 {
				nodes = append(nodes, v)
			}
		}
		nodes = nodes[1:]
		numCourses--
	}

	return numCourses == 0

}

//func canFinish(numCourses int, prerequisites [][]int) bool {
//	// 简单理解就是判断图中是否有环
//	// prerequisites表示各条边,图为有向图
//
//	// dfs解决
//	// 一次dfs遍历中存在节点被访问了两次 就表示有环
//	var (
//		// 访问标记
//		visit = make([]int, numCourses)
//		edges = map[int][]int{}
//		dfs   func(i int) bool
//	)
//
//	// 遍历全部的边，生成邻接表
//	for _, v := range prerequisites {
//		edges[v[0]] = append(edges[v[0]], v[1])
//	}
//
//	// 深搜逻辑
//	dfs = func(i int) bool {
//		// 标记已经访问过
//		visit[i] = 1
//
//		// 遍历所有下游节点
//		for _, v := range edges[i] {
//			if visit[v] == 1 {
//				return false
//			}
//			if visit[v] == 0 {
//				b := dfs(v)
//				if !b {
//					return false
//				}
//			}
//		}
//
//		visit[i] = 2
//		return true
//	}
//
//	i := 0
//	for i < numCourses && dfs(i) {
//		i++
//	}
//
//	return i == numCourses
//}
