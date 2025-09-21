package main

import (
	"bufio"
	. "fmt"
	"os"
	"strconv"
	"strings"
)

/**
 * @author chen
 * @date: 2021/8/28 下午10:08
 * @description:
 *
 */

func main() {
	reader := bufio.NewReader(os.Stdin)
	scanf := func() string {
		value, _ := reader.ReadString('\n')
		return strings.Replace(value, "\n", "", -1)
	}

	src := scanf()
	n := len(src)
	hash := make([]byte, 10)
	carry := 0
	des := ""

	for i := n - 1; i >= 0; i-- {
		curr := int(src[i] - '0')
		hash[curr]++
		res := curr*2 + carry
		bit := res % 10
		hash[bit]--
		des = strconv.Itoa(bit) + des
		carry = res / 10
	}

	if carry != 0 {
		Println("No")
		Println(strconv.Itoa(carry) + des)
		return
	}

	for _, v := range hash {
		if v != 0 {
			Println("No")
			Println(des)
			return
		}
	}

	Println("Yes")
	Println(des)
}
