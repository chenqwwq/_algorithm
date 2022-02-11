package main

import (
	. "fmt"
	"sort"
)

/**
  @user: chenqwwq
  @date: 2021/8/25
*/

func main() {
	var n int
	_, _ = Scanf("%d\n", &n)
	graph := make(map[int]map[int]bool)
	for i := 0; i < n-1; i++ {
		var a, b int
		_, _ = Scanf("%d %d\n", &a, &b)
		if graph[a] == nil {
			graph[a] = make(map[int]bool)
		}
		if graph[b] == nil {
			graph[b] = make(map[int]bool)
		}
		graph[a][b] = true
		graph[b][a] = true
	}
	visit := make([]bool, n+1)
	var conn func(curr int)
	conn = func(curr int) {
		if visit[curr] {
			return
		}
		visit[curr] = true
		if nexts, exist := graph[curr]; exist {
			for k := range nexts {
				conn(k)
			}
		}
	}

	components := 0
	for i := 1; i <= n; i++ {
		if visit[i] {
			continue
		}
		components++
		conn(i)
	}
	if components != 1 {
		Printf("Error: %d components\n", components)
		return
	}

	visit = make([]bool, n+1)
	var deep func(curr int, d int)
	var ans []int
	deepest := 0

	deep = func(curr int, d int) {
		if visit[curr] {
			return
		}
		if d > deepest {
			ans = []int{curr}
			deepest = d
		} else if d == deepest {
			ans = append(ans, curr)
		}
		visit[curr] = true
		if nexts, exist := graph[curr]; exist {
			for k := range nexts {
				deep(k, d+1)
			}
		}
		visit[curr] = false
	}
	for i := 1; i <= n; i++ {
		deep(i, 1)
	}
	sort.Ints(ans)
	visit = make([]bool, n+1)
	for _, v := range ans {
		if visit[v] {
			continue
		}
		Println(v)
		visit[v] = true
	}
}
