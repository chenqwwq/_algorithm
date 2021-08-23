package _20201206

/**
 * @author chen
 * @date: 2020/12/7 下午9:39
 * @description:
 *
 */

/**
118. 杨辉三角
给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
在杨辉三角中，每个数是它左上方和右上方的数的和。

示例:

输入: 5
输出:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
*/

func generate(numRows int) [][]int {
	var res [][]int

	for i := 0; i < numRows; i++ {
		res = append(res, []int{1})
	}

	for i := 1; i < numRows; i++ {
		res[i] = append(res[i], 1)
		for j := i + 1; j < numRows; j++ {
			res[j] = append(res[j], res[j-1][i]+res[j-1][i-1])
		}
	}
	return res
}
