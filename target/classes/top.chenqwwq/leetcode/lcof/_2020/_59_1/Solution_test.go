package _59_1

import (
	"reflect"
	"testing"
)

/**
  @user: chenqwwq
  @date: 2020/7/24
*/

func Test_maxSlidingWindow(t *testing.T) {
	type args struct {
		nums []int
		k    int
	}
	tests := []struct {
		name string
		args args
		want []int
	}{
		/**
		示例:

		输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
		输出: [3,3,5,5,6,7]
		解释:

		  滑动窗口的位置                最大值
		---------------               -----
		[1  3  -1] -3  5  3  6  7       3
		 1 [3  -1  -3] 5  3  6  7       3
		 1  3 [-1  -3  5] 3  6  7       5
		 1  3  -1 [-3  5  3] 6  7       5
		 1  3  -1  -3 [5  3  6] 7       6
		 1  3  -1  -3  5 [3  6  7]      7
		

		提示：

		你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。

		来源：力扣（LeetCode）
		链接：https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof
		著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
		*/
		{
			name: "case1",
			args: args{
				nums: []int{1, 3, -1, -3, 5, 3, 6, 7},
				k:    3,
			},
			want: []int{3, 3, 5, 5, 6, 7},
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := maxSlidingWindow(tt.args.nums, tt.args.k); !reflect.DeepEqual(got, tt.want) {
				t.Errorf("maxSlidingWindow() = %v, want %v", got, tt.want)
			}
		})
	}
}
