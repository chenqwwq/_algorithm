package toposort

/**
  @user: chenqwwq
  @date: 2021/8/20
*/

/**
拓扑排序是在有向无环图(DAG,Directed Acyclic Graph) 所有顶点的线性排序。
且该序列必须满足下面两个条件：
  1. 每个顶点出现且只出现一次。
  2. 若存在一条从顶点 A 到顶点 B 的路径，那么在序列中顶点 A 出现在顶点 B 的前面。

当然也可以借助拓扑排序判断是否为 DAG,只要是 DAG 就会有有拓扑排序

算法流程
1. 从 DAG 中选出入度为0的点
2. 从途中删除该顶点所有相关联的边
3. 重复1，2，直到 DAG 中不存在任何无前驱顶点


## 例题

1. [210. 课程表 II](https://leetcode-cn.com/problems/course-schedule-ii/
2  [剑指offer 113](https://leetcode-cn.com/problems/QA2IGt/)
*/

// components 获取连通分量
// graph 为邻接矩阵
func components(n int, graph [][]bool) int {
	return 1
}
