package main

import (
	"_algorithm/src/main/java/top/chenqwwq/basis/BinaryIndexedTree"
	"fmt"
	"time"
)

/**
 * @author chen
 * @date: 2021/1/14 下午11:49
 * @description:
 *
 */

func main() {
	data := make([]int, 100000)
	for i := 0; i < len(data); i++ {
		data[i] = 1
	}
	sum := uint64(0)
	for i := 0; i < 10; i++ {
		now := time.Now().Nanosecond()
		BinaryIndexedTree.NewBit(data)
		sum += uint64(time.Now().Nanosecond() - now)
	}
	fmt.Println(sum / 10)
}
