package _20211006

/**
 * @author chen
 * @date: 2021/10/6 8:25 上午
 * @description:
 *
 */
const INF = int64(-1e18)
func thirdMax(nums []int) int {
	// 分别表示最大的 第二大的 第三大的
	a,b,c := INF,INF,INF
	for _,num := range nums{
		target :=  int64(num)
		if target > a{
			c = b
			b = a
			a = target
		}else if target > b && target < a{
			c = b
			b = target
		}else if target > c && target < b{
			c = target
		}
	}
	if c == INF {
		return int(a)
	}
	return int(c)
}