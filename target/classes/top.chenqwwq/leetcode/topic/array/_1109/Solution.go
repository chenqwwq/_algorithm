package _1109

/**
  @user: chenqwwq
  @date: 2020/9/11
*/

/**
1109. 航班预订统计
这里有 n 个航班，它们分别从 1 到 n 进行编号。
我们这儿有一份航班预订表，表中第 i 条预订记录 bookings[i] = [i, j, k] 意味着我们在从 i 到 j 的每个航班上预订了 k 个座位。
请你返回一个长度为 n 的数组 answer，按航班编号顺序返回每个航班上预订的座位数。

示例：

输入：bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
输出：[10,55,45,25,25]

提示：
1 <= bookings.length <= 20000
1 <= bookings[i][0] <= bookings[i][1] <= n <= 20000
1 <= bookings[i][2] <= 10000
*/

func corpFlightBookings(bookings [][]int, n int) []int {
	// 差分数组

	// 初始都为0
	diff := make([]int, n+1)

	for _, arr := range bookings {
		diff[arr[0]] += arr[2]
		if arr[1]+1 < len(diff) {
			diff[arr[1]+1] -= arr[2]
		}
	}

	ans := make([]int, n+1)
	// 恢复
	for i := 1; i < len(diff); i++ {
		ans[i] = diff[i] + ans[i-1]
	}

	return ans[1:]
}
