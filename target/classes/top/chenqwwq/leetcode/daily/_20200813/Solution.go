package _20200813

import (
	"strconv"
)

/**

43. 字符串相乘
给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。

示例 1:

输入: num1 = "2", num2 = "3"
输出: "6"
示例 2:

输入: num1 = "123", num2 = "456"
输出: "56088"
说明：

num1 和 num2 的长度小于110。
num1 和 num2 只包含数字 0-9。
num1 和 num2 均不以零开头，除非是数字 0 本身。
不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。

  @user: chenqwwq
  @date: 2020/8/12
*/

func multiply(num1 string, num2 string) string {
	if num1 == "0" || num2 == "0" {
		return "0"
	}

	// 输入转换成int数组
	n2 := make([]int, len(num2))
	for i, v := range num2 {
		n2[i] = int(v - '0')
	}

	// 逐位相乘
	res := "0"
	i := len(num1)
	for k, v := range num1 {
		res = add(res, oneBitMultiply(int(v-'0'), &n2, i-k-1))
	}

	return res
}


func add(num1, num2 string) string {
	i, j := len(num1) - 1, len(num2) - 1
	add := 0
	ans := ""
	for ; i >= 0 || j >= 0 || add != 0; i, j = i - 1, j - 1 {
		x, y := 0, 0
		if i >= 0 {
			x = int(num1[i] - '0')
		}
		if j >= 0 {
			y = int(num2[j] - '0')
		}
		result := x + y + add
		ans = strconv.Itoa(result % 10) + ans
		add = result / 10
	}
	return ans
}


func oneBitMultiply(b int, n1 *[]int, num int) string {
	// 先填充0
	res := ""
	pre := 0
	for i := len(*n1) - 1; i >= 0; i-- {
		t := b*(*n1)[i] + pre
		i := t % 10
		pre = t / 10
		res = strconv.Itoa(i) + res
	}

	if pre != 0 {
		res = strconv.Itoa(pre) + res
	}

	for ; num > 0; num-- {
		res += "0"
	}

	return res
}
