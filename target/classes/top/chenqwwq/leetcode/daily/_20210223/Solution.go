package _20210223

/**
 * @author chen
 * @date: 2021/2/23 下午9:25
 */

/**
@description:
1052. 爱生气的书店老板
今天，书店老板有一家店打算试营业 customers.length 分钟。每分钟都有一些顾客（customers[i]）会进入书店，所有这些顾客都会在那一分钟结束后离开。
在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。 当书店老板生气时，那一分钟的顾客就会不满意，不生气则他们是满意的。
书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 X 分钟不生气，但却只能使用一次。
请你返回这一天营业下来，最多有多少客户能够感到满意的数量。

示例：
输入：customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], X = 3
输出：16
解释：
书店老板在最后 3 分钟保持冷静。
感到满意的最大客户数量 = 1 + 1 + 1 + 1 + 7 + 5 = 16.
提示：
1 <= X <= customers.length == grumpy.length <= 20000
0 <= customers[i] <= 1000
0 <= grumpy[i] <= 1
*/

func maxSatisfied(customers []int, grumpy []int, X int) int {
	n := len(customers)
	if n == 0 {
		return 0
	}

	// 计算所有生气的时候的顾客数目
	angryCnt, ta, res := make([]int, n), 0, 0
	maxAngry := 0
	max := func(a, b int) int {
		if a > b {
			return a
		}
		return b
	}

	for i := 0; i < n; i++ {
		if grumpy[i] == 1 {
			ta += customers[i]
		} else {
			res += customers[i]
		}
		angryCnt[i] = ta
		if i >= X-1 {
			if i == X-1 {
				maxAngry = angryCnt[i]
			} else {
				maxAngry = max(maxAngry, angryCnt[i]-angryCnt[i-X])
			}
		}
	}

	return res + maxAngry
}
