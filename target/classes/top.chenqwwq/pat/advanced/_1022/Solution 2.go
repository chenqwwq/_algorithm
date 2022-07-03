package main

import (
	"bufio"
	. "fmt"
	"os"
	"sort"
	"strconv"
	"strings"
)

/**
  @user: chenqwwq
  @date: 2021/8/26
*/

func main() {
	reader := bufio.NewReader(os.Stdin)
	scanf := func() string {
		value, _ := reader.ReadString('\n')
		return strings.Replace(value, "\n", "", -1)
	}
	// n个数据
	n, _ := strconv.Atoi(scanf())
	// 保存数据,go 只能使用 map 实现 set 的功能
	// 0 - 标题
	// 1 - 作者名称
	// 2 - 关键字
	// 3 - 出版社
	// 4 - 发行年份
	dict := make([]map[string]map[string]bool, 5)
	for i := 0; i < 5; i++ {
		dict[i] = make(map[string]map[string]bool)
	}
	// 添加方法
	add := func(hash map[string]map[string]bool, key, id string) {
		if hash[key] == nil {
			hash[key] = make(map[string]bool)
		}
		hash[key][id] = true
	}
	for i := 0; i < n; i++ {
		id := scanf()
		add(dict[0], scanf(), id)
		add(dict[1], scanf(), id)
		for _, key := range strings.Split(scanf(), " ") {
			add(dict[2], key, id)
		}
		add(dict[3], scanf(), id)
		add(dict[4], scanf(), id)
	}

	// m 个查询
	m, _ := strconv.Atoi(scanf())
	printSet := func(hash map[string]bool) {
		var keys []string
		for k := range hash {
			keys = append(keys, k)
		}
		sort.Strings(keys)
		for _, v := range keys {
			Println(v)
		}
	}
	for i := 1; i <= m; i++ {
		line := scanf()
		split := strings.Split(line, ": ")
		_type, _ := strconv.Atoi(split[0])
		Println(line)
		if hash, exist := dict[_type-1][split[1]]; exist {
			printSet(hash)
		} else {
			Println("Not Found")
		}
	}
}
