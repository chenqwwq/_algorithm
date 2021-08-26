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
	var n int
	_, _ = Scanf("%d\n", &n)
	dict := make([]map[string]map[int]bool, 5)
	for i := 0; i < 5; i++ {
		dict[i] = make(map[string]map[int]bool)
	}
	add := func(dict map[string]map[int]bool, key string, value int) {
		if dict[key] == nil {
			dict[key] = make(map[int]bool)
		}
		dict[key][value] = true
	}
	reader := bufio.NewReader(os.Stdin)
	scanf := func() string {
		value, _ := reader.ReadString('\n')
		return strings.Replace(value, "\n", "", -1)
	}
	for i := 0; i < n; i++ {
		id, _ := strconv.Atoi(scanf())
		add(dict[0], scanf(), id)
		add(dict[1], scanf(), id)
		k := scanf()
		for _, key := range strings.Split(k, " ") {
			add(dict[2], key, id)
		}
		add(dict[3], scanf(), id)
		add(dict[4], scanf(), id)
	}
	m, _ := strconv.Atoi(scanf())
	printSet := func(hash map[int]bool) {
		var keys []int
		for k,_ := range hash {
			keys = append(keys, k)
		}
		sort.Ints(keys)
		for _, v := range keys {
			Println(v)
		}
	}
	for i := 1; i <= m; i++ {
		line := scanf()
		split := strings.Split(line, ":")
		_type, _ := strconv.Atoi(split[0])
		key := strings.TrimSpace(split[1])
		Println(line)
		if hash, exist := dict[_type-1][key]; exist {
			printSet(hash)
		} else {
			Println("Not Found")
		}
	}
}
