package main

/**
  @user: chenqwwq
  @date: 2021/8/20

https://leetcode-cn.com/problems/QA2IGt/
*/

func findOrder(n int, prerequisites [][]int) []int {
	if n == 1 {
		return []int{0}
	}

	visit, degree := make([]bool, n), make([]int, n)
	graph := make(map[int][]int)
	var queue, ans []int

	for _, require := range prerequisites {
		degree[require[0]]++
		if graph[require[1]] == nil {
			graph[require[1]] = []int{}
		}
		graph[require[1]] = append(graph[require[1]], require[0])
	}

	for i, v := range degree {
		if v == 0 {
			ans = append(ans, i)
			queue = append(queue, i)
		}
	}

outer:
	for len(queue) != 0 {
		node := queue[0]
		visit[node] = true
		if nexts, exist := graph[node]; exist {
			for _, n := range nexts {
				if visit[n] {
					break outer
				}
				degree[n]--
				if degree[n] == 0 {
					ans = append(ans, n)
					queue = append(queue, n)
				}
			}
		}
		queue = queue[1:]
	}

	if len(ans) == n {
		return ans
	}
	return []int{}
}
